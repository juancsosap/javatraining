package Fundaments;

import java.util.Scanner;

public class BasicConsole {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		
		System.out.println("Name : ");
		String name = console.nextLine();
		
		System.out.println("Surname : ");
		String surname = console.nextLine();
		
		System.out.println("Age : ");
		int age = console.nextInt();
		
		System.out.println("Name : " + name + " " + surname);
		System.out.println("You are " + age + " years old");
		
		console.close();
	}

}
