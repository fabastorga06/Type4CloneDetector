package Controller;

import Model.CloneDetector;

public class Controller {
	
	public void initLogic() {		
		CloneDetector detector = new CloneDetector(); 
		detector.startCloneAnalysis();
	}
	
	public void setupParallelism() {
		
	}

}
