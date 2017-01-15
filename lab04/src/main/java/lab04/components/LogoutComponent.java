package lab04.components;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import lab04.pages.BasePage;
import lab04.pages.LogoutPage;

public class LogoutComponent extends BasePage {

	private static final By LOGOUT_LINK = By.linkText("Wyloguj");
	
	public LogoutComponent(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public LogoutPage logout() {
		findElement(LOGOUT_LINK).click();
		return new LogoutPage(getDriverProvider());
	}
}
