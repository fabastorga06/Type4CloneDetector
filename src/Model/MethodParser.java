/**
 * Class that parse each method sign and extracts its parameters types strings
 * and generate data types objects 
 * @author: Fabian Astorga Cerdas
 */

package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MethodParser implements Constants {
	
	private String _methodName;
	private int _paramThreshold = 15;
	private ArrayList<Object> _paramList;
	private ArrayList<String> _tokenList;
	private ParamFactory<Object> _factory = null;
	
	/**
	 * Constructor class
	 * @param methodName name of the method to parse it
	 */
	public MethodParser(String methodName)
	{
		this._methodName = methodName;
		this._paramList = new ArrayList<Object>();
		this._tokenList = new ArrayList<String>();
		this._factory = new ParamFactory<Object>();
	}
	
	/**
	 * Parse method sign in order to extract data types
	 * @throws FileNotFoundException
	 */
	public void parseMethodSign() throws FileNotFoundException 
	{
		 File inputFile = new File(INPUT_FILE);
		 @SuppressWarnings("resource")
		 Scanner input = new Scanner(inputFile);
		 int index = 0;
	
		 while (input.hasNext()) {
		     String line = input.nextLine();
		     String[] lineArray = line.split("[, ;{}()=]+");
			 for (String token : lineArray) {
				if (token.equals(_methodName)) {
					index++;
				}
				if (index != 0) {
					if (index == this._paramThreshold) {
						break;
					}
					_tokenList.add(token);	
					index++;
				}
			 }
		 }
		 		 
		 for (int i = 1; i < _tokenList.size(); i+=2) {
			 Object obj = _factory.getParameter(_tokenList.get(i));
			 if (obj == null) {
				 break;
			 }
			 this._paramList.add(obj); 
		 }		 
	}
	
	/**
	 * Get parameters list of each method
	 * @return Parameters list with type data object
	 */
	public ArrayList<Object> getParamList() 
	{
		return this._paramList;
	}
}