package jmp.module04.multithreading.tasks;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Logger;

public class TaskManager {

	private URLClassLoader classLoader;

	private Barrier barrier = new Barrier(10);

	private List<Future<Boolean>> promises = new ArrayList<Future<Boolean>>();

	private static final Logger LOG = Logger.getLogger(TaskManager.class);

	private static final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();

	private static final ThreadFactory threadFactory = new ThreadFactory() {

		private final AtomicInteger count = new AtomicInteger(1);

		public Thread newThread(Runnable r)
		{
			return new Thread(r, "SequentialAsyncTask #" + this.count.getAndIncrement());
		}
	};

	private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10L, TimeUnit.MILLISECONDS, workQueue, threadFactory);

	private class WorkerRunnable implements Callable<Boolean> {

		private Class<?> clazz;
		private Object object;

		public WorkerRunnable(Class<?> clazz, Object object) {
			this.clazz = clazz;
			this.object = object;
		}

		public Boolean call() {

			String accountId = ""+getAccointId();

			try {
				barrier.await();
				Method method = clazz.getDeclaredMethod("execute", new Class<?>[]{String.class, Double.class, String.class});
				method.invoke(object, new Object[]{accountId, rand(), randCurrencyType()});
					
			} catch (Exception e) {
				LOG.equals(e);
			}
			return true;
		}
	}

	public void start(int threadNum) {
		Method close = null;
		Object exec = null;
		Class<?> clazz = null;
		try {
			classLoader = new JarEntryClassLoader("accounts.jar");
			clazz = classLoader.loadClass("jmp.module04.multithreading.utils.Executor");
			exec = clazz.newInstance();
		} catch (Exception e1) {
			LOG.equals(e1);
		}
		for(int i = 0; i < threadNum; i++) {
			promises.add(executor.submit(new WorkerRunnable(clazz, exec)));
		}
		while(!promises.isEmpty()) {
			Iterator<Future<Boolean>> iterator = promises.iterator();
			while(iterator.hasNext()){
				Future<Boolean> response = iterator.next();
				if (!response.isDone()) {
					continue;
				}
				try {
					if (response.get()) {
						iterator.remove();
					}
				} catch (InterruptedException e) {
					LOG.equals(e);
				} catch (ExecutionException e) {
					LOG.equals(e);
				}
			}
		}
		if (promises.isEmpty()) {
			executor.shutdownNow();
			try {
				close = clazz.getDeclaredMethod("close", new Class<?>[]{});
				close.invoke(exec, new Object[]{});
			} catch (Exception e1) {
				LOG.equals(e1);
			}
		}
	}

	private double rand() {
		return Math.random() * 1000D;
	}

	private int getAccointId() {
		int type = 20;
		type *= Math.random();
		return (type > 0) ? type : getAccointId();
	}

	private String randCurrencyType(){
		String[] types = {"EU", "RU", "US", "UK"};
		int type = 3;
		type *= Math.random();
		return types[type];
	}

}
