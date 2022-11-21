package generation.italy.travel;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Biglietto {
	
	
	static final BigDecimal EURO_PER_KM = new BigDecimal(0.21);
	static final BigDecimal DISCOUNT_OVER_65 = new BigDecimal(40);
	static final BigDecimal DISCOUNT_UNDER_18 = new BigDecimal(20);
	static final int NORMAL_DURATION = 30;
	static final int FLEXIBLE_DURATION = 90;
	private int km;
	private int age;
	private LocalDate date;
	private boolean flessible;
	
	
	public Biglietto(int km, int age) throws Exception {
		
		isValidKm(km);
		isValidAge(age);
		date = LocalDate.of(2022, 10, 10);
		flessible = true;
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
		
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isFlessible() {
		return flessible;
	}
	public void setFlessible(boolean flessible) {
		this.flessible = flessible;
	}


	public void isValidKm(int km) throws Exception {
		
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
	
	
	
	public LocalDate calcolaDataScadenza() {
		
		LocalDate dataScadenza;
		if(isFlessible() == true) {
			dataScadenza = getDate().plusDays(NORMAL_DURATION);
		}else {
			dataScadenza = getDate().plusDays(FLEXIBLE_DURATION);
		}
		
		return dataScadenza;
	}
	
	
	@Override
	public String toString() {
		
		return 
				"\nKm: " +getKm()
				+ "\nAge: " +getAge()
				+ "\nPrezzo biglietto: " + calcolaPrezzo()
				+ "\nData biglietto: " + getDate()
				+ "\nFlessibile: " + isFlessible() 
				+ "\nData scadenza: " + calcolaDataScadenza();
	}
}
