package Model;

public class ParamFactory<T> {
	
	public ParamFactory() {}
	
	@SuppressWarnings("unchecked")
	public T getParameter(String ptype)
	{		
		T param = null;
		
		switch (ptype) {
			case "int":
				param = (T) new Integer(10);
				break;
			case "String":
				param = (T) new String("abcdef");
				break;
			case "double":
				param = (T) new Double(2.75);
				break;
			case "boolean":
				param = (T) new Boolean(true);
				break;
			default:
				break;
		}
		
		return param;		
	}
}
