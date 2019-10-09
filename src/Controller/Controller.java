package Controller;

import Model.CloneDetector;

public class Controller {
	
	public void initLogic(String[] args) {		
		CloneDetector detector = new CloneDetector(); 
		detector.startCloneAnalysis(args);
	}
	
	public void setupParallelism() {
		
	}

}
