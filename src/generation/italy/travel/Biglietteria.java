package generation.italy.travel;

import java.util.Scanner;

public class Biglietteria {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserire km: ");
		int km = sc.nextInt();
		System.out.println("Inserire età: ");
		int age = sc.nextInt();
		
		sc.close();
		
		System.out.println("START");
		
		
		try {
			Biglietto b = new Biglietto(km, age);			
			String res = b.toString();
			System.out.println(res);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		
		System.out.println("THE END");
	}
}
