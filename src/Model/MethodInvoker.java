/** 
 * Class that handle with the invocation of the method
 * that composes the file
 * @author: Fabian Astorga Cerdas
 */

package Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodInvoker {
	
	@SuppressWarnings("rawtypes")
	private Class[] _paramClasses;
	private Object[] _paramValues;
	private ParameterClasses _pc;
	private ResultsTable _results;
	
	/**
	 * Class constructor
	 */
	public MethodInvoker() 
	{
		_pc = new ParameterClasses();
		_results = ResultsTable.getInstance();
	}
	
	/**
	 * Evaluate each method and invoke it in order to know its functionality
	 * @param test File class instance
	 * @param methodName method name string
	 * @param paramList List with data types objects of the method parameters 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void invokeMethodByParams(Class test, String methodName, ArrayList<Object> paramList) 
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, InstantiationException
	{		
		Method _method = null;		
		_paramClasses = _pc.getParameterClasses(paramList);
		_method = test.getDeclaredMethod(methodName, _paramClasses);		
		_paramValues = paramList.toArray(new Object[paramList.size()]);  
		
		if(!_method.isAccessible()) {
			_method.setAccessible(true);
		}	
		
		Object resultMethod = _method.invoke(test.newInstance(), _paramValues);		
		_results.putResultOnMap(_method, resultMethod);	 	
		
	}	

}