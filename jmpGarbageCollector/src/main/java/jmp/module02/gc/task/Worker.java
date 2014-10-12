package jmp.module02.gc.task;

public class Worker extends Thread {

	private double data[];
	
	private int startIndex;
	
	private int endIndex;
	
	private int threshold;
	
	public Worker(double[] data, int startIndex, int endIndex, int threshold) {
		this.data = new double[endIndex - startIndex];
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.threshold = threshold;
		System.arraycopy(data, 0, this.data, 0, this.data.length);
		
		start();
	}

	public void run() {
		if ((endIndex - startIndex) < threshold) {
			System.out.println(" start to compute " + Thread.currentThread());
			recalculate(0, startIndex, endIndex);
		} else {
			int middleIndex = (startIndex + endIndex) / 2;
			new Worker(data, startIndex, middleIndex, threshold);
			new Worker(data, middleIndex, endIndex, threshold);
		}
	}
	
	private void recalculate(int pos, int startIndex, int endIndex){
		if (pos < (endIndex - startIndex)) {
			Double result = Math.sqrt(data[pos]) * Math.E;
			data[pos] = result;
			System.out.println(" calculate " + data[pos]);
			recalculate(++pos, startIndex, endIndex);
		}
	}
	
}
