package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileParser {
	// declare array list for the file contents and buffered reader/ writer and scanner
	private static List<String> FileContents = new ArrayList<String>();

	private static BufferedReader br = null;
	private static BufferedWriter bw = null;

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

				String str = s.replaceAll("[^a-zA-Z0-9]+"," ");

				// add to a list
				FileContents.addAll(Arrays.asList(str));
			}
			br.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}	//parse

	
	public void printAll() {
		System.out.println("Do you want to print to console(1) or to a new file(2)?: ");
		int printChoice = console.nextInt();

		if(printChoice == 1)
		{
			try{
				bw = new BufferedWriter(new FileWriter(
						new File("BookOut.txt")));


				int i= 0;
				while(i < FileContents.size()){
					System.out.println(FileContents.get(i));
					i++;
				}
			}
			catch(IOException e){
				e.printStackTrace();
			}	
		} // if
		else if(printChoice == 2)
		{
			try{
				bw = new BufferedWriter(new FileWriter(
						new File("BookOut.txt")));


				int i= 0;
				while(i < FileContents.size()){
					bw.write(FileContents.get(i));
					i++;
				}
				System.out.println("done");

				bw.flush();
				bw.close();
			}
			catch(IOException e){
				e.printStackTrace();
			} // catch
		} // else if
	} // printAll

	public String filetoString()
	{
		StringBuilder sb = new StringBuilder();
		for (String s : FileContents)
		{
		    sb.append(s);
		    sb.append("\n");
		}
		return sb.toString();
		
	}
	
	public int length() {
		return FileContents.size();
	}
}
