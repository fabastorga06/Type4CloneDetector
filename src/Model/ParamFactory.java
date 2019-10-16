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
				param = (T) new String("string de prueba");
				break;
			case "double":
				param = (T) new Double(2.75594039220);
				break;
			case "boolean":
				param = (T) new Boolean(true);
				break;
			case "byte":
				param = (T) new Byte((byte) 10);
				break;
			case "short":
				param = (T) new Short((short) 3500);
				break;
			case "long":
				param = (T) new Long(999999999);
				break;
			case "float":
				param = (T) new Float(807.65);
				break;
			case "char":
				param = (T) new Character('a');
				break;
			default:
				break;
		}
		
		return param;		
	}
}
