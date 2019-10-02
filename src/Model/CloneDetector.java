package Model;

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
		// Hacer comparación
    }
}