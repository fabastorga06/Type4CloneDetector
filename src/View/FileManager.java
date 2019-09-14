package View;

import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.*;
import com.google.common.io.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
	
	private File _file;
	protected static final String _projectDir = "C:\\workspace\\Type4CloneDetector\\src\\Test\\";
	private JFileChooser _fileChooser = new JFileChooser();
	private StringBuilder _content = new StringBuilder();
	private String _fileName; 
	
	public StringBuilder getContent() { return _content; }
		 
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
	
	public String changeFileFormat() {
		_fileName = _file.getName();
		String[] arrName = _fileName.split("\\."); 
		String newNameFile = arrName[0] + ".java";     
		System.out.println("new file name: " + newNameFile);
		return newNameFile;
	}
	
	public static void copyFileToNewDir(String from, String to) throws IOException {
		Path src = Paths.get(from);
		Path dest = Paths.get(to);
		Files.copy(src.toFile(), dest.toFile());
	}
	
	public void processFile() {		
        /* if file copied successfully */
		try {
			String newFileName = changeFileFormat();
			copyFileToNewDir(_file.getAbsolutePath(), _projectDir + newFileName);
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}				
	} 
}