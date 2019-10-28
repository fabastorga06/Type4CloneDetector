/**
 * Class that makes a PDF report with the detection information
 * @author: Fabian Astorga Cerdas
 */

package Model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class ReportCreator implements Constants {
	
	private Document _document;
	private Font _font;
	private static int _cols = 2;

	/**
	 * Class constructor
	 */
	public ReportCreator() 
	{
		_document = new Document();
		_font = FontFactory.getFont(FontFactory.COURIER, 20, BaseColor.BLACK);
	}
	
	/**
	 * Writes detected clones line by line inside a table
	 * @param Matrix with the detected clones
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	public void writeInfoReport(List<List<String>> clones) throws DocumentException, FileNotFoundException 
	{		
		PdfWriter.getInstance(_document, new FileOutputStream(PDF_FILE));
		_document.open();		
		_document.add(new Paragraph(PDF_TITLE, _font));
		_document.add(new Paragraph(new Date().toString()));
		_document.add(new Paragraph("  "));
		
		PdfPTable clones_table = new PdfPTable(_cols);				
		addTableHeader(clones_table);
		addRows(clones_table, clones);		
		_document.add(clones_table);		
		_document.close();
	}
		
	/**
	 * Creates the header of the table
	 * @param table clones table
	 */
	private void addTableHeader(PdfPTable table) 
	{
	    Stream.of("Method Evaluated", "Method Cloned")
	      .forEach(columnTitle -> {
	        PdfPCell header = new PdfPCell();
	        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	        header.setBorderWidth(1);
	        header.setPhrase(new Phrase(columnTitle));
	        table.addCell(header);
	    });
	}
	
	/**
	 * Add rows with the detected clones in the table
	 * @param table clones table
	 * @param clones Matrix with the clones
	 */
	private void addRows(PdfPTable table, List<List<String>> clones)
	{
		for (int i = 0; i < clones.size(); ++i) 
		{
			for (int j = 0; j < _cols; ++j) 
			{
				 table.addCell(clones.get(i).get(j));
			}
		}
	}
}