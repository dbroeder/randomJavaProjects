package finalProjects;

import java.util.Random;
import java.util.Scanner;

public class Playground {

	public static void main(String[] args) {
		Random rando=new Random();
		System.out.println("Tests:");
		for(int x = 0; x<4;x++){
			System.out.println(rando.nextInt(40)+60);
		}
		System.out.println("Quizzes:");
		for(int x = 0; x<3;x++){
			System.out.println(rando.nextInt(40)+60);
		}
		System.out.println("Homework:");
		for(int x = 0; x<10;x++){
			System.out.println(rando.nextInt(40)+60);
		}
	}
	
	public static String oddOrEven(int num){
		if(num%2==0)
		{
			return "even";
		}
		else{
			return "odd";
		}
	}

}
