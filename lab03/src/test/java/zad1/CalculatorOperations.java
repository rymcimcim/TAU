package zad1;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class CalculatorOperations {
	
	private Calculator calculator;
	
	@Given("a calculator")
	public void calculatorSetup() {
		calculator = new Calculator();
	}
	
	@When("set arguments to $a and $b")
	public void setArguments(int a, int b){
		calculator.setLeft(a);
		calculator.setRight(b);
	}
	
	@Then("addition should give $result")
	public void testAdd(int result){
	    assertEquals(result, calculator.add());
	}
	
	@Then("substraction should give $result")
	public void testSub(int result){
	    assertEquals(result, calculator.sub());
	}
	
	@Then("multiplication should give $result")
	public void testMulti(int result){
	    assertEquals(result, calculator.multi());
	}
	
	@Then("division should give $result")
	public void testDiv(int result){
	    assertEquals(result, calculator.div());
	}
	
	@Then("comparison should give $result")
	public void testGreater(boolean result){
	    assertEquals(result, calculator.greater());
	}
	
}
