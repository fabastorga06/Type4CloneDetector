package Model;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

public class ResultComparator {

	public ResultComparator() {}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void compareResults()
	{
		ResultsTable _results = ResultsTable.getInstance();
		Map<Method, Object> _map = _results.getResultsMap();
		ReportCreator _report = new ReportCreator();
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
		    			System.out.println("¡Clon Tipo-4 Detectado!");	
		    			clones.add(new ArrayList<String>());
		    			clones.get(index).add(mainMethod.toString());
		    			clones.get(index).add(methods.get(j).toString());	    	
		    			index++;
		    		}
		    		System.out.println("resultado 1: " + results.get(i));
		    		System.out.println("resultado 2: " + results.get(j));
		    		System.out.println("----------------------------------------------------");
		    	}		    		
		    }
		}
		
		try 
		{
			_report.writeInfoReport(clones);
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	
}