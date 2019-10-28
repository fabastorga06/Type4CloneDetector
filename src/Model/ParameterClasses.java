/** 
 * Class made as factory pattern design
 * @author: Fabian Astorga Cerdas
 */

package Model;

import java.util.ArrayList;

public class ParameterClasses {
	
	/**
	 * Generate classes objects according the input object list 
	 * in order to execute each method with Java Reflection
	 * @param paramlist object list with data types parameters objects
	 * @return Class list with the data types classes instances
	 */
	@SuppressWarnings("rawtypes")
	public Class[] getParameterClasses(ArrayList<Object> paramlist) 
	{
		Class[] oc = new Class[paramlist.size()];	
				
		for (int i = 0; i < paramlist.size(); ++i) {
			
			if (paramlist.get(i) instanceof String) 
			{
				oc[i] = String.class;
			}
			else if (paramlist.get(i) instanceof Integer) 
			{
				oc[i] = Integer.TYPE;
			}
			else if (paramlist.get(i) instanceof Boolean) 
			{
				oc[i] = Boolean.TYPE;
			}
			else if (paramlist.get(i) instanceof Double) 
			{
				oc[i] = Double.TYPE;
			}
			else if (paramlist.get(i) instanceof Byte) 
			{
				oc[i] = Byte.TYPE;
			}
			else if (paramlist.get(i) instanceof Short) 
			{
				oc[i] = Short.TYPE;
			}
			else if (paramlist.get(i) instanceof Long) 
			{
				oc[i] = Long.TYPE;
			}
			else if (paramlist.get(i) instanceof Float) 
			{
				oc[i] = Float.TYPE;
			}
			else if (paramlist.get(i) instanceof Character) 
			{
				oc[i] = Character.TYPE;
			}			
		}		
		
		return oc;
	}

}
