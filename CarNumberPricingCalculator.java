import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CarNumberPricingCalculator {

	Scanner input = new Scanner(System.in);
	
	
	public void addingPlateNumber() {
		System.out.println("Enter number to check cost. Example:ABC123");
		
		String plateNumber = input.nextLine();
		
		plateNumber = plateNumber.toUpperCase();
		
		if(plateNumber.length() > 6) {
			System.out.println("Number plate is too long.");
		}

		
		Matcher m = Pattern.compile("[a-zA-Z]{3}\\d{3}").matcher(plateNumber);
		if (m.find() && plateNumber.length() == 6) {
		    System.out.println(plateNumber + " is a valid number plate");
		    System.out.println("Number plate cost " + calculatePrice(plateNumber) + "€");
		    
		    
		} else {
			if(plateNumber.length() < 7) {				
				System.out.println(plateNumber + " is a nominal number plate.");
				System.out.println("Number plate cost " + calculatePrice(plateNumber) + "€");
			} 
		}
	
	}
	
	public BigDecimal calculatePrice(String number) {
		Pattern p = Pattern.compile("([A-Z])\\1{2}");
		Pattern n = Pattern.compile("([0-9])\\1{2}");
		Pattern ten = Pattern.compile("[a-zA-Z]{3}\\d{3}");
		Matcher m = p.matcher(number);
		Matcher m2 = n.matcher(number);
		Matcher ma = p.matcher(number);
		Matcher ms = n.matcher(number);
		Matcher mten = ten.matcher(number);
		
		if(number.length() > 6) {
			throw new IllegalArgumentException("Incorrect plate number format. Must be 1-6 symbols\r\n" + 
					"	 * latin letters and number combination");
		}

		
		if(m.find() && m2.find()) {
			return new BigDecimal("5000");
		} else if((number.contains("GOD") || number.contains("KLR") || number.contains("BOS")) && m2.find()) { 
			return new BigDecimal("7000");
		} else if((number.contains("GOD") || number.contains("KLR") || number.contains("BOS")) && number.length() == 6 && mten.find()){
			return new BigDecimal("2000");
		}else if(ma.find() || ms.find() || number.contains("001") || number.contains("666")) {
			return  new BigDecimal("1000");
		} else if(!mten.matches() || number.length() < 6){
			return  new BigDecimal("10000");
		}	else {
			return  new BigDecimal("100");
		}
	}

	/**
	 * Naudojam TDD
	 * Kursime programÄ… Regitrai, kuri turi paskaiÄ�iuoti kainÄ… pagal
	 * pageidautinÄ… automobilio numerÄ¯. KainÄ… politika yra tokia: Jeigu visos
	 * trys raidÄ—s yra vienodos, arba jeigu visi trys skaiÄ�iai vienodi arba
	 * "001","666" - numerio kaina 1000 eur. Jeigu trys raidÄ—s vienodos IR trys
	 * skaiÄ�iai vienodi - numerio kaina 5000 EUR. Jeigu raidÅ¾iÅ³ rinkinys yra
	 * vienas iÅ¡ "GOD", "KLR", "BOS" numerio kaina 2000 EUR. Jeigu prie aukÅ¡Ä�iau
	 * minÄ—to raidÅ¾iÅ³ rinkinio pridÄ—sime tris vienodus skaiÄ�ius - 7000 EUR.
	 * Jeigu numeris yra ne iÅ¡ trijÅ³ simboliÅ³ ir trijÅ³ skaiÄ�iÅ³ (1-6 simboliai)
	 * jis yra vardinis - kaina 10 000 EUR. 
	 * Jei skaiÄ�iuoklei paduodamas blogo formato numeris - turi mesti 
	 * IllegalArgumentException su praneÅ¡imu - "Incorrect plate number format. Must be 1-6 symbols
	 * latin letters and number combination" 
	 * maÅ¾osiomis ir d P.S. NIEKADA realiose sistemose nenaudokite float/double
	 * pinigÅ³ ir kitoms tikslioms operacijoms tam naudokite BigDecimal tipÄ…!
	 */
	 
	//testo metodo pvz.:
	//@Test
	// public void testAllNumbersAndLettersAreTheSameCost5000() {
	//	assertEquals(new Double(5000.0), priceCalc.calculatePrice("AAA111"));
	//}
	 
	 
	 
	
}