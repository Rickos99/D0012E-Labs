package profiling;

public class TimeMeasure {
	
	private long start, stop, totalTime = 0l;

	public void start() {
		start = System.nanoTime();
	}
	
	public void stop() {
		stop = System.nanoTime();
		totalTime += stop - start;
		reset();
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
		return totalTime;
	}
	
	/**
	 * 
	 * @return measured time in milliseconds
	 */
	public double getMilliSeconds() {
		return (getMeasuredTime()) * Math.pow(10, -6);
	}
	
	@Override
	public String toString() {
		return getMilliSeconds() + " ms";
	}
}
