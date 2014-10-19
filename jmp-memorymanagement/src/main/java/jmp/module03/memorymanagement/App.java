package jmp.module03.memorymanagement;

import org.apache.log4j.Logger;

import compile.runtime.HeapAnalyzer;
import compile.runtime.MemoryEater;
import compile.runtime.PermGenAnalyzer;
import compile.runtime.StackFrameAnalyzer;
import javassist.ClassPool;

public class App 
{
	
	private static final Logger LOG = Logger.getLogger(App.class);
	
    public static void main( String[] args ) throws Exception
    {
    	try{
    		//MemoryEater.acquire();
    		//StackFrameAnalyzer.analyze(1);
    		//HeapAnalyzer.analyze();
    		PermGenAnalyzer.analyze();
    	} finally {
    		LOG.error(" INTERRUPTED ");
    	}
    }
    
    private static Class generate(String name) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		return pool.makeClass(name).toClass();
	}
}
