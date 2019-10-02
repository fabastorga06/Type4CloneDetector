package Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodInvoker {
	
	@SuppressWarnings("rawtypes")
	private Class[] _paramClasses;
	private Object[] _paramValues;
	private ParameterClasses _pc;
	
	public MethodInvoker() 
	{
		_pc = new ParameterClasses();
	}
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void invokeMethodByParams(Class test, String methodName, ArrayList<Object> paramList) 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, InstantiationException
	{		
		Method _method = null;		
		_paramClasses = _pc.getParameterClasses(paramList);
		_method = test.getDeclaredMethod(methodName, _paramClasses);		
		_paramValues = paramList.toArray(new Object[paramList.size()]);  
		
		System.out.println("Resultado: " + _method.invoke(test.newInstance(), _paramValues));
		
		// ALMACENAR RESULTADOS 
		
	}	

}