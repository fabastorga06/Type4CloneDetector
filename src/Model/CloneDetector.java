package Model;

import java.util.Map;

public class CloneDetector {
	
	private FileChecker _checker;
   
    public CloneDetector() 
    { 
    	_checker = new FileChecker();
    } 
    
    public void startCloneAnalysis() 
    {    
		_checker.checkFileMethods();    
				
		//Obtener tabla de resultados 
		ResultsTable _results = ResultsTable.getInstance();
		Map<String, Object> map = _results.getResultsMap();
		System.out.println("Mapa de resultados: " + map );
		
		/* Hacer comparación de resultados */
		
    }
}