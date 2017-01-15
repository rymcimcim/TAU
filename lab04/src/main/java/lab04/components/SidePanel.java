package lab04.components;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import lab04.pages.BasePage;

public class SidePanel extends BasePage {
	
	private static final By SUBPAGES_LINK = By.linkText("Podstrony");
	
	public SidePanel(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public void goToSubPages() {
		findElement(SUBPAGES_LINK).click();
	}

}
