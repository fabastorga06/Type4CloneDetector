/**
 * Class that manages loaded file
 * @author: Fabián Astorga Cerdas
 */

package Model;

import java.util.Scanner;
import javax.swing.JFileChooser;
import java.io.*;
import com.google.common.io.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager implements Constants {
	
	private File _file;
	private JFileChooser _fileChooser = new JFileChooser();
	private StringBuilder _content = new StringBuilder();
	private String _newFileName; 
	
	public StringBuilder getContent() { return _content; }
	public String getFileName() { return _newFileName; }
		 
	public void readFile() throws Exception
	{	  
	  if(_fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {	   
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
	
	public static void copyFileToNewDir(String from, String to) throws IOException {
		Path src = Paths.get(from);
		Path dest = Paths.get(to);
		Files.copy(src.toFile(), dest.toFile() );
	}	
		
	public void processFile() 
	{		
		try {
			copyFileToNewDir(_file.getAbsolutePath(), PROJECT_DIR + NEW_NAME_FILE);
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}				
	} 
}