package Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportCreator {
	
	private Document _document;
	private Font _font;

	public ReportCreator() 
	{
		_document = new Document();
		_font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
	}
	
	/* SINGLETON */
	
	/* generates PDF file with clones information */	
	public void writeInfoReport(String info) throws DocumentException, FileNotFoundException 
	{		
		PdfWriter.getInstance(_document, new FileOutputStream("type-4_clones_report.pdf"));
		_document.open();
		Chunk chunk = new Chunk(info, _font);		 
		_document.add(chunk);
		_document.close();
	}
}