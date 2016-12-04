package zad3;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class LiczbaRzymskaOperations {
	
	private LiczbaRzymska liczba;


	@Given("liczba")
	public void liczbaSetup() {
		liczba = new LiczbaRzymska();
	}
	
	@When("set argument to $arabic")
	public void setArgument(int arabic){
		liczba.setNumber(arabic);
	}
	
	@Then("after conversion it should be $roman")
	public void convert(String roman){
		assertEquals(roman, liczba.toString());
	}
	
	@When("set argument $outOfRangeNumber")
	public void setOutOfRangeNumber(int arabic){
		liczba.setNumber(arabic);
	}
	
	@Then("illegal argument exception should be thrown")
	public void verifyException() {
		try {
			liczba.toString();
		} catch (Exception e){
		}
	}
	
}
