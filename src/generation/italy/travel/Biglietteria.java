package generation.italy.travel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Biglietteria {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Quanti biglietti vuoi comprare?");
		int count = sc.nextInt();
		
		
		Biglietto[] biglietti = new Biglietto[count];
		
		int index = 0;
		while(index < count) {
			
			System.out.println("Biglietto n. " +(index+1));
			System.out.print("Inserire km: ");
			int km = sc.nextInt();
			System.out.print("\nInserire età: ");
			int age = sc.nextInt();
			
			try {
				Biglietto b = new Biglietto(km, age);
				biglietti[index++] = b;
//				String res = b.toString();   
//				System.out.println(res);   //stampa singolo oggetto
			}catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		
		sc.close();
		
		FileWriter myWriter = null;
		
		try {
			
			myWriter = new FileWriter("./biglietti.txt", true);
			
			for(int i = 0; i < biglietti.length; i++) {
				
				Biglietto b = biglietti[i];
				myWriter.write(b.toString() + "\n");
//				myWriter.append(b.toString() + "\n"); //is the same of above line??
			}
		} catch (Exception e) {
//			
			System.err.println(e.getMessage());
		} 
		finally {
			
			try {
				
				myWriter.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("START");  //inizio esecuzione
		
		System.out.println(Arrays.toString(biglietti)); //stampa array
					
		System.out.println("THE END"); //fine esecuzione
	}
}
