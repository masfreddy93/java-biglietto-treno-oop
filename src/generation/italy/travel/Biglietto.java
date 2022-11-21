package generation.italy.travel;

import java.math.BigDecimal;

public class Biglietto {

	
	static final BigDecimal EURO_PER_KM = new BigDecimal(0.21);
//	static final BigDecimal EURO_PER_KM = 0.21;
//	static final BigDecimal DISCOUNT_OVER_65 = 40;
	static final BigDecimal DISCOUNT_OVER_65 = new BigDecimal(40);
//	static final BigDecimal DISCOUNT_UNDER_18 = 20;
	static final BigDecimal DISCOUNT_UNDER_18 = new BigDecimal(20);
	private int km;
	private int age;
	
	
	public Biglietto(int km, int age) throws Exception {
		
		isValidKm(km);
		isValidAge(age);
	}
	
	public int getKm() {
		return this.km;
	}
	public void setKm(int km) {
		this.km = km;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	public void isValidKm(int km) throws Exception {
		
//		BigDecimal comp = new BigDecimal(0);
		if(km <= 0)
			throw new Exception("Km must be bigger than 0!");
		
		this.km = km;
	}
	
	public void isValidAge(int age) throws Exception {
		
		if(age < 0 || age > 115)
			throw new Exception("Age must be a valid age!");
		
		this.age = age;
	}
	
	
	public BigDecimal calcolaPrezzo() {
		
		BigDecimal kmToBigDecimal = new BigDecimal(km);
		BigDecimal finalPrice = new BigDecimal(0);
		finalPrice = EURO_PER_KM.multiply(kmToBigDecimal);
		finalPrice = finalPrice.subtract(calcolaSconto());
		
		return finalPrice;
		
	}
	
	private BigDecimal calcolaSconto() {
		
		BigDecimal sconto = new BigDecimal(0);
		BigDecimal kmToBigDecimal = new BigDecimal(km);
		BigDecimal price = EURO_PER_KM.multiply(kmToBigDecimal);
		BigDecimal num1ToBigDecimal = new BigDecimal(20);
		BigDecimal num2ToBigDecimal = new BigDecimal(40);
		BigDecimal denToBigDecimal = new BigDecimal(100);
		
		if(getAge() < 18) {
			sconto = price.multiply(num1ToBigDecimal);
			sconto = sconto.divide(denToBigDecimal);			
		} else if(getAge() >= 65) {
			sconto = price.multiply(num2ToBigDecimal);
			sconto = sconto.divide(denToBigDecimal);
		}
		
		return sconto;
	}
	
	
	
	@Override
	public String toString() {
		
		return 
				"Km: " +getKm()
				+ "\nAge: " +getAge()
				+ "\nPrezzo biglietto: " + calcolaPrezzo();
	}
}
