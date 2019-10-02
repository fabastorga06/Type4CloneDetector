package Model;

import java.util.ArrayList;

public class ParameterClasses {
	
	public ParameterClasses() { }

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
			if (paramlist.get(i) instanceof Boolean) 
			{
				oc[i] = Boolean.TYPE;
			}
			if (paramlist.get(i) instanceof Double) 
			{
				oc[i] = Double.TYPE;
			}
		}		
		
		return oc;
	}

}
