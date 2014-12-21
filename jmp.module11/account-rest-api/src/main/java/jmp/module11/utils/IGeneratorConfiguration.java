package jmp.module11.utils;

public interface IGeneratorConfiguration {
	
	enum GeneratorSequence {
		
		INT_SEQ(Integer.TYPE), 
		DOUBLE_SEQ(Double.TYPE), 
		FLOAT_SEQ(Float.TYPE), 
		GAUSSIAN_SEQ(Double.TYPE), 
		LONG_SEQ(Long.TYPE);
		
		private final Class<?> clazz;
		
		private GeneratorSequence(Class<?> clazz){
			this.clazz = clazz;
		}

		public Class<?> getClazz() {
			return clazz;
		}
		
	}
	
	void init();
	
	void setSeed(Long seed);
	
	Long getSeed();
	
	<T> Class<T> getGeneratorType();

}
