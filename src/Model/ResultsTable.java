package Model;

import java.util.HashMap;
import java.util.Map;

public class ResultsTable {
	
    private static ResultsTable single_instance = null; 
    private Map<String, Object> _resultsMap;
    
    private ResultsTable() 
    {
    	_resultsMap = new HashMap<>();
    }
    
    public static ResultsTable getInstance() 
    { 
        if (single_instance == null) 
        {
        	single_instance = new ResultsTable();
        }  
        return single_instance; 
    }
    
    public void putResultOnMap(String key, Object value) 
    {
    	_resultsMap.put(key, value);
    }
    
    public Map<String, Object> getResultsMap()
    {
    	return _resultsMap;
    }

}