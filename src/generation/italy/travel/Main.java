package generation.italy.travel;

import java.math.BigDecimal;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("START");
		
		try {
			Biglietto b = new Biglietto(10, 10);			
			String res = b.toString();
			System.out.println(res);
			System.out.println("Sconto over 65: " + b.DISCOUNT_OVER_65);
			System.out.println("Prezzo biglietto: " + b.calcolaPrezzo());
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		
		System.out.println("THE END");
	}
}
