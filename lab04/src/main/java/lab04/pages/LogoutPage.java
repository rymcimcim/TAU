package lab04.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class LogoutPage extends BasePage {
	
	private static final By RESIGNIN_LINK_TEXT = By.linkText("Zaloguj się ponownie");
	
	public LogoutPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public void getBackToSignIn() {
		findElement(RESIGNIN_LINK_TEXT).click();
	}
}
