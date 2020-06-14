package com.compare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Conversion  {

	public static File convertToText(String fileName) throws Exception {
		PDDocument document = null;
		File genFile = null;
		try {
			//Loading an existing document 
			File file = new File(fileName);
			document = PDDocument.load(file);

			//Instantiate PDFTextStripper class 
			PDFTextStripper pdfStripper = new PDFTextStripper();

			//Retrieving text from PDF document 
			String text = pdfStripper.getText(document); 
			System.out.println(text);
			genFile = new File(fileName+".txt");

			@SuppressWarnings("resource")
			FileWriter wr = new FileWriter(genFile); 
			wr.write(text);
			wr.flush();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			//Closing the document 
			document.close();
		}
		System.out.println(genFile);
		return genFile;

	}

	public static void compareTextFile(File textFileOne, File textFileTwo) throws Exception {
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		reader1 = new BufferedReader(new FileReader(textFileOne));
		reader2 = new BufferedReader(new FileReader(textFileTwo));

		String line1 = reader1.readLine(); 
		String line2 = reader2.readLine(); 
		boolean areEqual = true; 
		int lineNum = 1;
		String output = null;
		System.out.println("-------------------------COMPARE OUTPUT-----------------------------");
		while (line1 != null || line2 != null) { 
			if (line1 == null || line2 == null) { 
				areEqual = false; 
				break; 
			} else if (!line1.equalsIgnoreCase(line2)) { 
				output = "File1 has "+line1.trim()+" and File2 has "+line2.trim()+" at line "+lineNum;
				System.out.println("Two files have different content. They differ at line "+lineNum);
				System.out.println(output);
			} else if (line1.equalsIgnoreCase(line2)) {
				output = "Two files have same content.";
				System.out.println(output);
			}
			line1 = reader1.readLine(); 
			line2 = reader2.readLine(); 
			lineNum++; 
		} 

		reader1.close(); 
		reader2.close(); 
	}	
}
