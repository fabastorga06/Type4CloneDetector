/**
 * Class that saves all methods results in a data structure.
 * Its made with singleton pattern design to have only one instance
 * in the program
 * @author: Fabian Astorga Cerdas
 */

package Model;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultsTable {
	
    private static ResultsTable single_instance = null; 
    private Map<Method, Object> _resultsMap;
    
    /**
     * Class constructor
     */
    private ResultsTable() 
    {
    	_resultsMap = new LinkedHashMap<>();
    }
    
    /**
     * Get a unique instance of the class
     * @return instance of the class
     */
    public static ResultsTable getInstance() 
    { 
        if (single_instance == null) 
        {
        	single_instance = new ResultsTable();
        }  
        return single_instance; 
    }
    
    /**
     * Save method result inside data structure
     * @param key Method object from Java Reflection
     * @param value Result object
     */
    public void putResultOnMap(Method key, Object value) 
    {
    	_resultsMap.put(key, value);
    }
    
    /**
     * Get the results table
     * @return Linked hashmap data structure
     */
    public Map<Method, Object> getResultsMap()
    {
    	return _resultsMap;
    }
}