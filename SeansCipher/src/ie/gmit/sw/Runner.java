package ie.gmit.sw;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * Porta Cipher uses a polyalphabetic  substitution cipher. It uses uses 13 alphabets, 
 * and which are reciprocal, thus enciphering becomes the same as deciphering.
 */
public class Runner {
	private static Scanner console = new Scanner(System.in);
	private static FileParser fp = new FileParser();
	//private static URLParser up = new URLParser();
	
	public static void main(String[] args) {
		int option = 0;

		
        try{
    		menu();
    		option = console.nextInt();
        }catch (InputMismatchException ex) {
        	System.out.println("incorrect");
        	
        }
        
		while(option != -1)
		{
			switch (option) {
			case 1:
				encryptText();
				break;
			case 2:
				encryptFile();
				break;
			case 3:
				encryptURL();
				break;
			default:
				break;
			}
			
			menu();
			option = console.nextInt();
		}	
		console.close();
	}

	private static void encryptURL() {
		System.out.println("ULR YAH");		
	}

	private static void encryptFile() {
		System.out.println("FILE YAH");	

		fp.parse();
		fp.printAll();
		String fileKey = null;
		String file = null;
		
		
		
		System.out.println("Please Enter Key to Encrypt with: ");
		fileKey = console.next();
		
		file = fp.filetoString();
		Porta f = new Porta();
		
		System.out.println(file+ " and: " + fileKey);
		
		System.out.println("C: " +f.encode(file, fileKey));
		
		System.out.println("--Decrypt--");
		
		Porta f2 = new Porta();

		f2.encode(file, fileKey);
		System.out.println("C: " +f2.encode(file, fileKey));

	}

	private static void encryptText() {
		Porta b = new Porta();
		
		String key = null;
		String text = null;

		System.out.println("Enter the Key");
		key = console.next();
		
		System.out.println("Enter the text");
		text = console.next();
		System.out.println("K: "+ key +"\nP: "+ text);
		System.out.println("C: " +b.encode(text, key));
		
		System.out.println("--Decrypt--");
		
		b.encode(text, key);
		System.out.println("C: " +b.encode(text, key));
		
		
		Porta c = new Porta();

		String key2 = null;
		String text2 = null;
		
		System.out.println("Enter the Key");
		key2 = console.next();

		System.out.println("Enter the cipher text");
		text2 = console.next();
		
		System.out.println("K: "+key2 +"\nC: "+ text2 );
		c.encode(text2, key2);
		System.out.println("P: " + c.encode(text2, key2));
		
	}

	private static void menu() {
		System.out.println("Please Enter 1 for input text");
		System.out.println("Please Enter 2 for File Input");
		System.out.println("Please Enter 3 for URL Input");
		System.out.println("Please Enter -1 to Exit");

	}

}
