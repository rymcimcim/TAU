package lab01.zad1;



import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	
	Calculator calculator = new Calculator();
	
	@Test
	public void addTest(){
		assertEquals("Not equal!", calculator.add(1, 2), 3);
	}
	
	@Test
	public void subTest(){
		assertEquals("Subtraction not equal!", calculator.sub(1, 2), -1);
	}
	
	@Test
	public void multiTest(){
		assertEquals("Multiply fails!", calculator.multi(1, 2), 2);
	}
	
	@Test
	public void divTest(){
		assertEquals("Division fails!", calculator.div(4, 2), 2);
	}
	
	@Test
	public void greaterTest(){
		assertTrue("First number less than second!", calculator.greater(5, 4));
	}
	
	@Test(expected = ArithmeticException.class)
	public void divExceptionTest(){
		assertEquals("ArithmeticException was not thrown!", calculator.div(2, 0), 2);
	}
}
