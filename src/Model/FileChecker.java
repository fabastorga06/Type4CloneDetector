/**
 * Class that verifies the input file and creates an 
 * exact copy for later analysis
 * @author: Fabián Astorga Cerdas
 */

package Model;

import java.io.FileNotFoundException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class FileChecker extends ClassLoader {

	private static String _className;
	private MethodParser _parser;
	private MethodInvoker _invoker;
	
	/**
	 * Class constructor
	 */
	public FileChecker()  
	{
		_className = "Test.FileTest";
		_parser = null;
		_invoker = null;
	}
	
	/**
	 * Creates a class instance of the file a get their methods
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws FileNotFoundException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void checkFileMethods() throws ClassNotFoundException, NoSuchMethodException,
	SecurityException, InstantiationException, IllegalAccessException, 
	IllegalArgumentException, InvocationTargetException, FileNotFoundException 
	{
            
			ClassLoader classLoader = this.getClass().getClassLoader();
			Class testClass = classLoader.loadClass(_className);   
			Constructor constructor = testClass.getConstructor();
			Object testObject = constructor.newInstance();
			Method methods[] = testClass.getDeclaredMethods();
			
			for (Method method : methods) 
				invokeClassMethod(testClass, method.getName());
			           	            
	}
	
	/**
	 * analyze the signature of each method to verify its types of parameters 
	 * and make the invocation automatically with Java Reflection
	 * @param test file class 
	 * @param methodName in order to execute it 
	 * @throws FileNotFoundException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("rawtypes")
	public void invokeClassMethod(Class test, String methodName) throws FileNotFoundException, 
	NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, 
	InvocationTargetException, InstantiationException
	{
               	
        	_parser = new MethodParser(methodName);
        	_parser.parseMethodSign();
        	
        	ArrayList<Object> paramList = new ArrayList<Object>();
        	paramList = _parser.getParamList();
        	
        	_invoker = new MethodInvoker();
        	_invoker.invokeMethodByParams(test, methodName, paramList);        
    }
}