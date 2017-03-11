package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileParser {
	// declare array list for the file contents and buffered reader/ writer and scanner
	List<String> FileContents = new ArrayList<String>();

	BufferedReader br = null;
	BufferedWriter bw = null;

	public static Scanner console = new Scanner(System.in);

	// method parse 
	public void parse() {
		// enter try catch for reading the  file
		try{
			System.out.println("Enter File you wish to Parse (.txt): ");
			String BookParse = console.next();
		
			br = new BufferedReader(new InputStreamReader(
					new FileInputStream(BookParse)));
		}
		catch(FileNotFoundException e){
			System.out.println("File is not found, try again.");
			parse();
		}
		
		// enter another try catch for filling up the fileContents array list
		try{
			String s = null;
			while((s = br.readLine()) != null){

				String[] str = s.split("\\s+");
				// add to a list
				FileContents.addAll(Arrays.asList(str));
			}
			br.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}	//parse

}
