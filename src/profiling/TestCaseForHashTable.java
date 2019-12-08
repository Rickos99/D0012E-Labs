package profiling;

public class TestCaseForHashTable {
    public int longestCollisionChain = 0;
    public int numberOfInsertions = 0;
    public int numberOfCollisions = 0;
    public int numberOfOverflows = 0;
    public int aCollisionChain = 0;
    public int numberOfProbes = 0;
    public int numberOfHashes = 0;
    public int numberOfInputs = 0;
    
    public final int maxSize;
    public final String testTitle;
    
    public TimeMeasure timer = new TimeMeasure();
    
    public TestCaseForHashTable(int maxSizeOfHashTable, String title) {
      this.maxSize = maxSizeOfHashTable;
      this.testTitle = title;
    }
    
    public void updateLongestCollisionChain() {
    	if(aCollisionChain > longestCollisionChain) {
    		longestCollisionChain = aCollisionChain;
    	}
    	aCollisionChain = 0;
    }
    
    public double getLoadFactor() {
		  return roundDecimals(numberOfInsertions/(numberOfInputs*1d));
	  }
    
    public void beginInsertion() {
      numberOfInputs++;
      timer.start();
    }
    
    public void endInsertion() {
    	timer.stop();
		  updateLongestCollisionChain();
    }
    
    public void printResult() {
      System.out.println(testTitle());
      System.out.println("Capacity:                " + maxSize);
    	System.out.println("No. input values:        " + numberOfInputs);
      System.out.println("--------------");
    	System.out.println("Running time:            " + roundDecimals(timer.getMilliSeconds()) + "ms");
    	System.out.println("Longest collision-chain: " + longestCollisionChain);
    	System.out.println("Number of collisions:    " + numberOfCollisions);
    	System.out.println("Number of overflows:     " + numberOfOverflows);
    	System.out.println("Number of probes:        " + numberOfProbes);
    	System.out.println("Number of hashed:        " + numberOfHashes);
    	System.out.println("Number of insertions:    " + numberOfInsertions);
    	System.out.println("Load factor:             " + getLoadFactor());
    	System.out.println("------------------------------------------------------------");
    }
    
    private double roundDecimals(double value) {
		  return (double)Math.round(value * 10000d) / 10000d;
    }
    
    private String testTitle(){
      String fill = "";
      String title = " Test result: " + testTitle + " ";
      
      final int titleLength = title.length();
      final int totalLength = 60;
      final int nOfDashes = (int)((totalLength - titleLength)/2d);
      
      for (int i = 0; i < nOfDashes; i++) {
        fill += "-";
      }

      title = fill + title + fill;
      while (title.length() < totalLength){
        title += "-";
      }
      return title;
    }
}
