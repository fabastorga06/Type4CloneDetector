package View;

import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.*;

public class FileManager {
	
	private File _file;
	protected static final String _projectDir = "C:\\workspace\\Type4CloneDetector"
												+ "\\src\\Test\\FileTest.java";
	private JFileChooser _fileChooser = new JFileChooser();
	public StringBuilder _content = new StringBuilder();
		 
	public void readFile() throws Exception {
	  
	  if(_fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){	   
		   _file = _fileChooser.getSelectedFile();		   
		   Scanner input = new Scanner(_file);
		   
		   while( input.hasNext() ) {
			   _content.append(input.nextLine());
			   _content.append("\n");
		   }
		   input.close();
	  }	  
	  else {		  
		  _content.append("No file was selected, try again");
	  }
	}
	
	public void changeFileDir() {
		
        /* if file copied successfully then delete the original file */
        if(_file.renameTo(new File(_projectDir))) 
            System.out.println("File moved successfully"); 
        else
            System.out.println("Failed to move the file"); 
	}

}