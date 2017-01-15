package lab04.pages;

import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class SubpagesPage extends BasePage {

	private static final By SELECT_ID = By.xpath("//*[@id=\"addlist-primary\"]/select");
	
	public SubpagesPage(WebDriverProvider driverProvider) {
		super(driverProvider);
	}
	
	public void goToCreateGallery(){
		Select select = new Select(findElement(SELECT_ID));
		select.selectByVisibleText("Galeria");
	}
	
	public void addSubsize() {
		findElement(By.id("id_title")).sendKeys("1234");
		findElement(By.id("id_status_0")).click();
		findElement(By.name("_save")).click();
	}

}
