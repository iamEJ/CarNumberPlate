import static org.junit.Assert.assertEquals;


import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CarPlateNumberTest {
	private CarNumberPricingCalculator carnp;
	
	@Before
	public void before() {
		carnp = new CarNumberPricingCalculator();
	}
	
	@Test
	public void testAllNumbersAndLettersAreTheSameCost5000() {
		assertEquals("AAA111 must cost 5000",new BigDecimal("5000"), carnp.calculatePrice("AAA111"));
		assertEquals("LLL333 must cost 5000",new BigDecimal("5000"), carnp.calculatePrice("LLL333"));
		assertEquals("FFF000 must cost 5000",new BigDecimal("5000"), carnp.calculatePrice("FFF000"));
	}
	
	@Test
	public void testAllNumbersOrLettersAreTheSameCost1000() {
		assertEquals("BBB123 must cost 1000",new BigDecimal("1000"), carnp.calculatePrice("BBB123"));
		assertEquals("UUU383 must cost 1000",new BigDecimal("1000"), carnp.calculatePrice("UUU383"));
		assertEquals("OOO987 must cost 1000",new BigDecimal("1000"), carnp.calculatePrice("OOO987"));
		assertEquals("ATR222 must cost 1000",new BigDecimal("1000"), carnp.calculatePrice("ATR222"));
		assertEquals("GYT777 must cost 1000",new BigDecimal("1000"), carnp.calculatePrice("GYT777"));
		assertEquals("TOD666 must cost 1000",new BigDecimal("1000"), carnp.calculatePrice("TOD666"));
	}
	
	@Test
	public void testContainsCertainLettersCost2000() {
		assertEquals("BOS123 must cost 2000",new BigDecimal("2000"), carnp.calculatePrice("BOS123"));
		assertEquals("KLR383 must cost 2000",new BigDecimal("2000"), carnp.calculatePrice("KLR383"));
		assertEquals("GOD987 must cost 2000",new BigDecimal("2000"), carnp.calculatePrice("GOD987"));
	}
	
	@Test
	public void testCertainLettersAndThreeSameNumbersCost7000() {
		assertEquals("BOS111 must cost 7000",new BigDecimal("7000"), carnp.calculatePrice("BOS111"));
		assertEquals("KLR666 must cost 7000",new BigDecimal("7000"), carnp.calculatePrice("KLR666"));
		assertEquals("GOD777 must cost 7000",new BigDecimal("7000"), carnp.calculatePrice("GOD777"));
	}
	
	@Test
	public void testNominalPlateNumberCost10000() {
		assertEquals("BOSS01 must cost 10000",new BigDecimal("10000"), carnp.calculatePrice("BOSS01"));
		assertEquals("KILLER must cost 10000",new BigDecimal("10000"), carnp.calculatePrice("KILLER"));
		assertEquals("GOD must cost 10000",new BigDecimal("10000"), carnp.calculatePrice("GOD"));
		assertEquals("EVIL must cost 10000",new BigDecimal("10000"), carnp.calculatePrice("EVIL"));
		assertEquals("DEVIL must cost 10000",new BigDecimal("10000"), carnp.calculatePrice("DEVIL"));
	}
	
	@Test
	public void testOtherPlateNumbersCost100() {
		assertEquals("SET456 must cost 100",new BigDecimal("100"), carnp.calculatePrice("SET456"));
		assertEquals("GIP764 must cost 100",new BigDecimal("100"), carnp.calculatePrice("GIP764"));
		assertEquals("JIS456 must cost 100",new BigDecimal("100"), carnp.calculatePrice("JIS456"));
		assertEquals("MAN344 must cost 100",new BigDecimal("100"), carnp.calculatePrice("MAN344"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPlateNumberLenght1to6() throws IllegalArgumentException {
		CarNumberPricingCalculator carnp = new CarNumberPricingCalculator();
		carnp.calculatePrice("aaaaaaaaa");
		
	}


}
