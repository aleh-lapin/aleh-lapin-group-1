package jmp.module14.data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jmp.module14.data.Resource.ResourceState;

public class ResourceManagerImpl implements ResourceManager {

	private Map<String, Resource> resources = new ConcurrentHashMap<String, Resource>();

	private Map<String, IRepository> repositories = new ConcurrentHashMap<String, IRepository>();

	@Override
	public void bindResource(Resource resource, boolean useXAProtocol) {
		resources.put(resource.getName(), resource);
		repositories.put(resource.getName(), Participant.newInstance(resource, useXAProtocol));
	}

	@Override
	public Collection<Resource> enlistResource() {
		return resources.values();
	}

	@Override
	public Resource getResource(Class<?> type) {
		return resources.get(type.getSimpleName());
	}

	@Override
	public IRepository getRepository(Class<?> type) {
		return repositories.get(type.getSimpleName());
	}

	public static class Participant implements InvocationHandler {

		private Resource target;

		private boolean useXAProtocol;

		public static IRepository newInstance(Resource resource, boolean useXAProtocol) {
			return (IRepository)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
					new Class<?>[]{IRepository.class, Resource.class},  new Participant(resource, useXAProtocol));
		}

		public Participant(Resource target, boolean useXAProtocol) {
			this.target = target; 
			this.useXAProtocol = useXAProtocol;
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args)
				throws Throwable {
			Object result = null;
			if (method.getName().startsWith("push") || method.getName().startsWith("modify")) {
				synchronized (target) {

					target.prepare();
					try {
						result = method.invoke(target, args);
						Thread.sleep(2000);
						if (useXAProtocol)
							target.commit();
					} catch(InvocationTargetException e) {
						if (useXAProtocol)
							target.setState(ResourceState.RECOVERED);
					}
				}
			} else {
				try {
					result = method.invoke(target, args);
				} catch(InvocationTargetException e) {
					throw e.getTargetException();
				}
			}
			return result;
		}

	}

}
