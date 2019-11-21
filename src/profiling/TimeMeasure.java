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
	
	/**
	 * 
	 * @return measured time in milliseconds
	 */
	public double getMilliSeconds() {
		return (stop - start) * Math.pow(10, -6);
	}
	
	@Override
	public String toString() {
		return getMilliSeconds() + " ms";
	}
}
