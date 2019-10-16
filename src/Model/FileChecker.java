package Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class FileChecker extends ClassLoader {

	private static String _className;
	private MethodParser _parser;
	private MethodInvoker _invoker;
	
	public FileChecker()  
	{
		_className = "Test.FileTest";
		_parser = null;
		_invoker = null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public void checkFileMethods() 
	{
		try 
		{             
			ClassLoader classLoader = this.getClass().getClassLoader();
			Class testClass = classLoader.loadClass(_className);   
			Constructor constructor = testClass.getConstructor();
			Object testObject = constructor.newInstance();
			Method methods[] = testClass.getDeclaredMethods();
			
			for (Method method : methods) 
				invokeClassMethod(testClass, method.getName());
			           	             
 
        } catch (ClassNotFoundException e) {
        	System.out.println("Your file is not executable, "
							+ "please try with other java file...");
        } catch (InvocationTargetException e) {
            System.out.println("Syntax error in your file, please check it...");
            System.out.println(e.getCause());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@SuppressWarnings("rawtypes")
	public void invokeClassMethod(Class test, String methodName)
	{
        try {           	
        	_parser = new MethodParser(methodName);
        	_parser.parseMethodSign();
        	
        	ArrayList<Object> paramList = new ArrayList<Object>();
        	paramList = _parser.getParamList();
        	
        	_invoker = new MethodInvoker();
        	_invoker.invokeMethodByParams(test, methodName, paramList);
 
        } catch (Exception e) {
            e.printStackTrace();
        }         
    }
}