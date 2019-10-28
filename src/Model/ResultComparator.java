/**
 * Class that verifies if a couple of methods are type-4 clones
 * by functional similarity
 * @author: Fabian Astorga Cerdas
 */

package Model;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultComparator {

	/**
	 * 	Algorithm that compares each result of a method with the rest of
	 * them in order to detect functional similarity
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void compareResults()
	{
		ResultsTable _results = ResultsTable.getInstance();
		Map<Method, Object> _map = _results.getResultsMap();
		List<List<String>> clones = new ArrayList<List<String>>();
		int index = 0;
		
		List methods = new ArrayList(_map.keySet());
		List results = new ArrayList(_map.values());
								
		for (int i = 0; i < methods.size(); ++i) {
		    Object mainMethod = methods.get(i);
		    for (int j = 0; j < methods.size(); ++j) {
		    	if (mainMethod != methods.get(j)) {
		    		if (results.get(i).toString().equals(results.get(j).toString())) 
		    		{	
		    			clones.add(new ArrayList<String>());
		    			clones.get(index).add(mainMethod.toString());
		    			clones.get(index).add(methods.get(j).toString());	    	
		    			index++;
		    		}
		    	}		    		
		    }
		}
		
		try 
		{
			ReportCreator _report = new ReportCreator();
			CsvCreator _csv = new CsvCreator();
			
			_report.writeInfoReport(clones);
			_csv.generateCsvFile(clones);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}		
	}	
}