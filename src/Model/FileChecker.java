package Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class FileChecker extends ClassLoader {

	private static String _className;
	@SuppressWarnings("rawtypes")
	private Class _returnParam;
	
	public FileChecker()  
	{
		_className = "Test.FileTest";
		_returnParam = null;
	}
	
	public void checkFileMethods() 
	{
		try {             
            ClassLoader classLoader = this.getClass().getClassLoader();
             
			@SuppressWarnings("rawtypes")
			Class testClass = classLoader.loadClass(_className);             
            System.out.println("Loaded class name: " + testClass.getName());         
        
			@SuppressWarnings({ "unchecked", "rawtypes" })
		    Constructor constructor = testClass.getConstructor();
            @SuppressWarnings("unused")
			Object testObject = constructor.newInstance();
            
            System.out.println("\nMethods:");
            Method methods[] = testClass.getDeclaredMethods();
            for (Method method : methods) {
            	System.out.println(" " + method.getName());
            	invokeClassMethod(testClass, method.getName());
            }            	             
 
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@SuppressWarnings("rawtypes")
	public void invokeClassMethod(Class test, String method)
	{
            try {             
            	@SuppressWarnings("unchecked")
				Method _method = test.getMethod(method);
            	_returnParam = _method.getReturnType(); 
            	System.out.println("tipo retorno: " + _returnParam);
            	int res = (int)_method.invoke(test.newInstance());
            	System.out.println("resultado: " + res);
     
            } catch (Exception e) {
                e.printStackTrace();
            }
         
    }
}