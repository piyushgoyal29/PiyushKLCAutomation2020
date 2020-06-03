package utils;

import java.io.IOException;

import de.redsix.pdfcompare.PdfComparator;

public class ReadPdfFile{

	public static void comparePdfsAndGenerateResultPdf(String pdfPath1, String pdfPath2, String comparedResultPdfPath) throws IOException
	{
		boolean flag = new PdfComparator(pdfPath1, pdfPath2).compare().writeTo(comparedResultPdfPath);
		System.out.println(flag);
	}
	
}
