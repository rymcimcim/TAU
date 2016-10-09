package lab01.zad2;


import static org.junit.Assert.*;
import org.junit.Test;
import java.lang.Double;

public class CalculatorTest {
	
	Calculator calculator = new Calculator();
	
	@Test
	public void addTest(){
		assertEquals(3, calculator.add(1, 2), 0.001);
	}
	
	@Test
	public void subTest(){
		assertEquals(-1, calculator.sub(1, 2), 0.001);
	}
	
	@Test
	public void multiTest(){
		assertEquals(2, calculator.multi(1, 2), 0.001);
	}
	
	@Test
	public void divTest(){
		assertEquals(2, calculator.div(4, 2), 0.001);
	}
	
	@Test
	public void greaterTest(){
		assertTrue("First number less than second!", calculator.greater(5, 4));
	}
	
//	@Test(expected = ArithmeticException.class)
	public void divExceptionTest(){
		assertEquals(Double.NaN, calculator.div(2, 0), 0.001);
	}
}
