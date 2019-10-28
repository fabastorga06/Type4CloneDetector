/**
 * Class that connects view module with model module 
 * in order to implement MVC pattern design
 * @author: Fabián Astorga Cerdas
 */

package Controller;

import java.io.FileNotFoundException;
import com.itextpdf.text.DocumentException;
import Model.CloneDetector;
import Model.FileManager;

public class Controller {
	
	private static Controller single_instance = null; 
	private FileManager _fileManager;	
	
	/**
	 * Class constructor
	 */
	public Controller () 
	{
		_fileManager = new FileManager();
	}
	
	/**
	 * Singleton design pattern to use only one instance of the class 
	 * for efficient memory use
	 * @return a unique instance of Controller class
	 */
	
	public static Controller getInstance() 
    { 
        if (single_instance == null) 
        {
        	single_instance = new Controller();
        }  
        return single_instance; 
    }
	
	/**
	 * Executes type-4 clone detection algorithm
	 * @return flag indicates all process is executed correctly
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public boolean initLogic() throws FileNotFoundException, DocumentException 
	{		
		CloneDetector detector = new CloneDetector(); 
		return detector.startCloneAnalysis();
	}
	
	/**
	 * Function that calls FileManager class and read the input file
	 */
	public void callFileManager() 
	{
		try {
			_fileManager.readFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Return the file content in order to show it in the viewer
	 * @return file content
	 */
	public String getFileContent()
	{
		return _fileManager.getContent().toString();
	}
	
	/**
	 * 	Make a file copy and put that copy in a Test package inside the project files.
	 *  Creates the copy with a Google library.
	 */
	public void startFileManager()
	{
		_fileManager.processFile();
	}
}
