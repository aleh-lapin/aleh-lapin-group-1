package jmp.module02.gc.task;

public class WorkerExceptionHandler implements Thread.UncaughtExceptionHandler { 
	
	public void uncaughtException(Thread t, Throwable e) { 
		System.out.println("caught " + e + " in thread " + t); 
	}
}
