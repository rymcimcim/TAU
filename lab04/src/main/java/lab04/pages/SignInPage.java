package lab04.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

public class SignInPage extends BasePage {
	
	private static final String LOGIN_PAGE_URL = "http://mezzanine.jupo.org/pl/admin/login/?next=/pl/admin/";
	private static final By USERNAME_INPUT = By.name("username");
	private static final By PASSWORD_INPUT = By.name("password");
	private static final By SIGN_IN_BUTTON = By.cssSelector("input[type='submit'");
	private static final By ERROR_LOGIN_NODE = By.className("errornote");

	public SignInPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public SignInPage open() {
		get(LOGIN_PAGE_URL);
		return this;
	}
	
	public void loginAs(String username, String password) {
		findElement(USERNAME_INPUT).sendKeys(username);
		findElement(PASSWORD_INPUT).sendKeys(password);
		findElement(SIGN_IN_BUTTON).click();
	}

	public String getErrorLoginText(){
		return findElement(ERROR_LOGIN_NODE).getText();
	}
	
}
