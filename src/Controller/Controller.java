package Controller;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import Model.CloneDetector;

public class Controller {
	
	public void initLogic(String[] args) throws FileNotFoundException, DocumentException {		
		CloneDetector detector = new CloneDetector(); 
		detector.startCloneAnalysis(args);
	}
	
	public void setupParallelism() {
		
	}

}
