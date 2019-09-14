package Model;

public class CloneDetector {
	
	private static CloneDetector _cloneInstance = null; 	  
   
    private CloneDetector() { } 
  
    /*    Singleton pattern   */
    public static CloneDetector getInstance() { 
        if (_cloneInstance == null) {
        	_cloneInstance = new CloneDetector();
        } 
        return _cloneInstance; 
    } 
    
    public void startCloneAnalysis() {
    	
    }
}
