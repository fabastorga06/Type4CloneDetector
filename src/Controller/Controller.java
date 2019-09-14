package Controller;

import Model.CloneDetector;

public class Controller {
	
	public void initLogic() {		
		CloneDetector detector = CloneDetector.getInstance(); 
		detector.startCloneAnalysis();
	}
	
	public void setupParallelism() {
		
	}

}
