package lab04.pages;

import org.jbehave.web.selenium.WebDriverProvider;

public class HomePage extends BasePage{
	
	private static final String HOME_PAGE_URL = "http://mezzanine.jupo.org/pl/admin/";
	
	public HomePage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public HomePage open() {
		get(HOME_PAGE_URL);
		return this;
	}
	
}
