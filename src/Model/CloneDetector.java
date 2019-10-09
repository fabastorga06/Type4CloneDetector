package Model;

import mpi.MPI;

public class CloneDetector {
	
	private FileChecker _checker;
   
    public CloneDetector() 
    { 
    	_checker = new FileChecker();
    } 
    
    public void startCloneAnalysis(String[] args) 
    {    
    	
    	long startTime = System.nanoTime();

		/* code being measured starts */		
		MPI.Init(args);
		int rank = MPI.COMM_WORLD.Rank();
		int size = MPI.COMM_WORLD.Size();
		int procs = MPI.NUM_OF_PROCESSORS;
		System.out.println("process: " + rank + "\n" + "size: " + size
								+ "\n" + "processors: " + procs);  
		
    	
		_checker.checkFileMethods();   
		
		/* Hacer comparación de resultados y generar reporte */
		ResultComparator _comparator = new ResultComparator();	
		_comparator.compareResults();
		
		
		MPI.Finalize(); 		
		/* the code being measured ends */
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " + 
								timeElapsed / 1000000);
		
    }
}