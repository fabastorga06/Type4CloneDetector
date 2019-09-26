package Model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class FileChecker extends ClassLoader {

	private static String _className;
	@SuppressWarnings("rawtypes")
	private Class _returnParam;
	private Parameter[] _parameters;
	
	public FileChecker()  
	{
		_className = "Test.FileTest";
		_returnParam = null;
		_parameters = null;
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
        	System.out.println("Your file is not executable, please try with other java file...");
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
            	
            	_parameters = _method.getParameters();
            	System.out.println("num params: " + _parameters.length);
            	
            	if (_parameters.length == 0) {
            		System.out.println("No hay parametros" );
            		System.out.println("resultado: " + _method.invoke(test.newInstance()));
            		/* Guardar resultado en alguna estructura de datos */	
            	}
            	else {
            		System.out.println("Sí hay parametros" );
            		/* generar parametros para probar metodo */
            		for (Parameter param : _parameters) {
                    	System.out.println("parametros: " + param.getName());
                    	//invokeClassMethod(testClass, method.getName());
                    }        
            		
            		/* Guardar resultado en alguna estructura de datos */   
            		System.out.println("resultado: " + _method.invoke(test.newInstance(), "caballo"));
            	}
     
            } catch (Exception e) {
                e.printStackTrace();
            }
         
    }
}