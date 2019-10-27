/**
 * Class that initializes all clone detection process
 * @author: Fabián Astorga Cerdas
 */

package Model;

import java.lang.reflect.InvocationTargetException;

public class CloneDetector {
	
	private FileChecker _checker;
	private boolean _ok;
   
	/**
	 * Class constructor
	 */
    public CloneDetector() 
    { 
    	_checker = new FileChecker();
    	_ok = false;
    } 
    
    /**
     * Start clones detection process with unit tests 
     * @return flag indicates if process was completed successfully
     */
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