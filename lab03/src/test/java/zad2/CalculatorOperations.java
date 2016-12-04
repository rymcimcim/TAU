package zad2;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class CalculatorOperations {
	
	private static final double APPROX = 0.01;
	private Calculator calculator;
	
	@Given("a calculator")
	public void calculatorSetup() {
		calculator = new Calculator();
	}
	
	@When("set arguments to $a and $b")
	public void setArguments(double a, double b){
		calculator.setLeft(a);
		calculator.setRight(b);
	}
	
	@Then("addition should give $result")
	public void testAdd(double result){
	    assertEquals(result, calculator.add(), APPROX);
	}
	
	@Then("substraction should give $result")
	public void testSub(double result){
	    assertEquals(result, calculator.sub(), APPROX);
	}
	
	@Then("multiplication should give $result")
	public void testMulti(double result){
	    assertEquals(result, calculator.multi(), APPROX);
	}
	
	@Then("division should give $result")
	public void testDiv(double result){
	    assertEquals(result, calculator.div(), APPROX);
	}
	
	@Then("comparison should give $result")
	public void testGreater(boolean result){
	    assertEquals(result, calculator.greater());
	}
	
	@When("$x gets divided by ZERO")
	public void testByZeroDivision(double x) {
		calculator.setLeft(x);
		calculator.setRight(0);
	}

	@Then("the result is infinity")
	public void returnInfinity() {
		assertEquals(Double.POSITIVE_INFINITY, calculator.div(), APPROX);
	}
}
