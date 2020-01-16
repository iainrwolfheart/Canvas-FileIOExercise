package Starter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Questionnaire {

	public static void main(String[] args) throws IOException {
		
		String fileName = "Results.txt";
		
		String directoryPath = "../08_Working_With_Files/src/Resources/";
		
		String fullFileName = directoryPath + fileName;
		
		String newFileName = fullFileName.substring(0, fullFileName.length()-3) + "dat";

		//retrieveData(fullFileName);
		retrieveAndCopyData(fullFileName, newFileName);
		}
	
	public static void retrieveData (String fullFileName) throws IOException {
	
		String name, questionnaireDate, answers;
		BufferedReader bfr = new BufferedReader(new FileReader(fullFileName));
		
	
			name = bfr.readLine();
			
			while (name != null) {
				questionnaireDate = bfr.readLine();
				answers = bfr.readLine();
				
		System.out.println(name + " sat test on " + questionnaireDate + 
				" and gave the following responses: " + answers);
		
		name = bfr.readLine();
			}
	}
	
	public static void retrieveAndCopyData (String fullFileName, String newFileName) 
										throws IOException {
		
		BufferedReader bfr = new BufferedReader(new FileReader(fullFileName));
		BufferedWriter wtr = new BufferedWriter(new FileWriter(newFileName));
		
		String name, questionnaireDate, answers;
		
		name = bfr.readLine();
		
		while (name!= null) {
			questionnaireDate = bfr.readLine();
			answers = bfr.readLine();
			wtr.write(name + "\n");
			wtr.write(questionnaireDate + "\n");
			wtr.write(answers + "\n");
			
			System.out.printf("%s sat the test on %s and gave the following responses: "
					+ "%s\n", name, questionnaireDate, answers);
			
			name = bfr.readLine();
		}
		bfr.close();
		wtr.close();
		System.out.println(newFileName);
	}
	
}
