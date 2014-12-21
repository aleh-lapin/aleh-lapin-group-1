package jmp.module11.utils;

import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("exchangerGenerator")
public class ExchangerGenerator<T> implements IGenerator {
	
	private Random generatorInstance = new Random();
	
	@Autowired
	private IGeneratorConfiguration config;
	
	@Value(value="java.lang.Double")
	private Class<T> defaultType;

	@Override
	@PostConstruct
	public void configure() {
		generatorInstance.setSeed(config.getSeed());
	}

	@Override
	public synchronized <E> E next(Class<E> clazz) {
		return getNextValue(clazz);
	}
	
	private <E> E getNextValue(Class<E> clazz) {
		if (clazz != null) {
			if (clazz == Long.class) {
				return clazz.cast(new Long(generatorInstance.nextLong()));
			} else if (clazz == Integer.class) {
				return clazz.cast(new Integer(generatorInstance.nextInt()));
			} else if (clazz == Double.class) {
				return clazz.cast(new Double(generatorInstance.nextDouble()));
			} else if (clazz == Float.class) {
				return clazz.cast(new Float(generatorInstance.nextFloat()));
			}
		} else {
			throw new RuntimeException("Specify exact generator type.");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized T next() {
		return (T)getNextValue(defaultType);
	}

	public Random getGeneratorInstance() {
		return generatorInstance;
	}

	public void setGeneratorInstance(Random generatorInstance) {
		this.generatorInstance = generatorInstance;
	}

	public IGeneratorConfiguration getConfig() {
		return config;
	}

	public void setConfig(IGeneratorConfiguration config) {
		this.config = config;
	}

	public Class<T> getDefaultType() {
		return defaultType;
	}

	public void setDefaultType(Class<T> defaultType) {
		this.defaultType = defaultType;
	}
	
}
