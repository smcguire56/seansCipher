package ie.gmit.sw;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		Porta b=new Porta();
		
		String key = null;
		String text = null;
		
		System.out.println("Enter the Key");
		key = console.nextLine();
		
		System.out.println("Enter the text");
		text = console.nextLine();
		
		System.out.println(b.encode(text, key));
		
	}

}
