package profiling;

public class TimeMeasure {
	
	private long start, stop;

	public void start() {
		start = System.nanoTime();
	}
	
	public void stop() {
		stop = System.nanoTime();
	}
	
	public void reset() {
		start = 0;
		stop = 0;
	}
	
	/**
	 * 
	 * @return measured time in nanoseconds
	 */
	public long getMeasuredTime() {
		return stop - start;
	}
	
	@Override
	public String toString() {
		return ((stop - start) * Math.pow(10, -6)) + " ms";
	}
}
