package com.pdfconversion;

import java.io.*;
import au.com.bytecode.opencsv.CSVReader;

import java.util.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;

public class CSV2PDF {

	public static void main(String[] args) throws DocumentException, IOException {
		 /* Step -1 : Read input CSV file in Java */
		String inputFile = "C:\\Users\\smore\\Downloads\\csv_to_pdf.csv";
		 	CSVReader reader = new CSVReader(new FileReader(inputFile));
		 	String [] nextLine;
		 	int lnNum = 0;
		 	
		 	/* Step-2: Initialize PDF documents - logical objects */
		 	Document my_pdf_data = new Document();
		 	PdfWriter.getInstance(my_pdf_data, new FileOutputStream("C:\\Users\\smore\\Downloads\\converted_PDF_File.pdf"));
		 	my_pdf_data.open();
		 	PdfPTable my_first_table = new PdfPTable(2);
		 	PdfPCell table_cell;
		 	 /* Step -3: Loop through CSV file and populate data to PDF table */
		 	while((nextLine = reader.readNext()) !=null) {
		 		lnNum++;
		 		table_cell = new PdfPCell(new Phrase(nextLine[0]));
		 		my_first_table.addCell(table_cell);
		 		table_cell 	= new PdfPCell(new Phrase(new Phrase(nextLine[1])));
		 		my_first_table.addCell(table_cell);
		 	}
		 	 /* Step -4: Attach table to PDF and close the document */
		 	my_pdf_data.add(my_first_table);
		 	my_pdf_data.close();
	}

}
