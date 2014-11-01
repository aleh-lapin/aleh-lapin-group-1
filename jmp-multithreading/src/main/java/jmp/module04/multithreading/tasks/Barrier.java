package jmp.module04.multithreading.tasks;

public class Barrier {

	private int need;
	private int arrived;
	private boolean releasing; 

	public Barrier(int number) {
		need = number;
		releasing = false;
	}
	
	public synchronized void await()
			throws InterruptedException {
		while(releasing)
			wait();
		try {
			arrived++;
			while((arrived !=need) && !releasing) 
				wait(); 
			if(arrived == need) {
				releasing = true;
				notifyAll();
			}
		} finally {
			System.out.println(" === " + arrived);
			arrived--;
			if (arrived == 0) {
				releasing = false;
				notifyAll();
			}
		}
	}
	
	public synchronized int value() { 
		return arrived;
	}
	
	public int capacity() { 
		return need;
	}

}
