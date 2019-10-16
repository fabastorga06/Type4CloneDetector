package Test;

public class FileTest {

	public int functionA(String param, int x, int y){
		return x+y;
	}
	
	public String functionB(){
	   int x = 1;
	   int y = x + 5;
	   return "hola soy un string " + y;
	}	

	public boolean functionC(int value, boolean flag){
	   return flag;
	}
	
	public boolean functionD(){
	   boolean flag = false;
	   return !flag;
	}
	
	public static int highestPower2(int x) {
	    int tmp = x;
	    int answer = 1;
	    while (tmp > 1) {
	        answer = 2 * answer;
	        tmp = tmp/2;
	    }
	    return answer;
	}
	
	public static int flp2(int x) {
	    x = x | (x >>> 1);
	    x = x | (x >>> 2);
	    x = x | (x >>> 4);
	    x = x | (x >>> 8);
	    x = x | (x >>> 16);
	    return (x - (x >>> 1)) & 0xff;
	}
}