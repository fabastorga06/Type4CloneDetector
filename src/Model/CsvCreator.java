package Model;

import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvCreator implements Constants {
	
	public CsvCreator() {}
	
	public void generateCsvFile(List<List<String>> clones) 
	{
		try 
		{
			 PrintWriter pw= new PrintWriter(new File(CSV_PATH));
			 StringBuilder sb=new StringBuilder();
			 sb.append("Method Evaluated");
			 sb.append(",	");
			 sb.append("Method Cloned");
			 sb.append("\r\n");
			   
			 for (int i = 0; i < clones.size(); ++i) 
			 {
				 sb.append(clones.get(i).get(0));
				 sb.append(",	");
				 sb.append(clones.get(i).get(1));
				 sb.append("\r\n");
			 }
			 
			 pw.write(sb.toString());
 			 pw.close();
 			 
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
