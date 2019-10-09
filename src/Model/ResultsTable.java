package Model;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultsTable {
	
    private static ResultsTable single_instance = null; 
    private Map<Method, Object> _resultsMap;
    
    private ResultsTable() 
    {
    	_resultsMap = new LinkedHashMap<>();
    }
    
    public static ResultsTable getInstance() 
    { 
        if (single_instance == null) 
        {
        	single_instance = new ResultsTable();
        }  
        return single_instance; 
    }
    
    public void putResultOnMap(Method key, Object value) 
    {
    	_resultsMap.put(key, value);
    }
    
    public Map<Method, Object> getResultsMap()
    {
    	return _resultsMap;
    }
}