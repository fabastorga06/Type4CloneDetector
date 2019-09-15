package Model;

public class CloneDetector {
	
	private static CloneDetector _cloneInstance = null; 	 
	private FileChecker _checker;
   
    private CloneDetector() { 
    	_checker = new FileChecker();
    } 
  
    /*    Singleton pattern   */
    public static CloneDetector getInstance() { 
        if (_cloneInstance == null) {
        	_cloneInstance = new CloneDetector();
        } 
        return _cloneInstance; 
    } 
    
    public void startCloneAnalysis() {
    	_checker.checkFileMethods();
    	
    }
}