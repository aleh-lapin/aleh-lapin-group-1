package jmp.module11.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("exchangerConfig")
public class ExchangerGeneratorConfiguration implements IGeneratorConfiguration {
	
	private Long seed;
	
	@SuppressWarnings("rawtypes")
	private Class generatorType;

	@Override
	public void init() {
		Assert.isNull(seed, "Specify generator seed.");
		Assert.isNull(generatorType, "Specify default generator type.");
	}

	@Override
	@Value(value="10")
	public void setSeed(Long seed) {
		this.seed = seed;		
	}

	@Override
	public Long getSeed() {
		return this.seed;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Class<T> getGeneratorType() {
		return this.generatorType;
	}

	@Value(value="java.lang.Long")
	public <T> void setGeneratorType(Class<T> generatorType) {
		this.generatorType = generatorType;
	}
	

}
