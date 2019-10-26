package Model;

import java.lang.reflect.InvocationTargetException;

public class CloneDetector {
	
	private FileChecker _checker;
	boolean _ok;
   
    public CloneDetector() 
    { 
    	_checker = new FileChecker();
    	_ok = false;
    } 
    
    public boolean startCloneAnalysis()
    {
    	try {
			_checker.checkFileMethods();
			ResultComparator _comparator = new ResultComparator();	
			_comparator.compareResults();	
			_ok = true;
		} 
		catch (ClassNotFoundException e) {
			_ok = false;
	    	System.out.println("Your file is not executable, "
							+ "please try with another Java file...");
	    } catch (InvocationTargetException e) {
	    	_ok = false;
	        System.out.println("Syntax error in your file, please check it...");
	    } catch (Exception e) {
	    	_ok = false;
	        e.printStackTrace();
	    }
		
		return _ok;		
    }
}