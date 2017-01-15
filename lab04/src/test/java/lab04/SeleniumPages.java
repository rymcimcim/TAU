package lab04;

import org.jbehave.web.selenium.*;

import lab04.components.LogoutComponent;
import lab04.pages.HomePage;
import lab04.pages.LogoutPage;
import lab04.pages.SignInPage;

public class SeleniumPages {

    private final WebDriverProvider driverProvider;
    private HomePage homePage;
    private LogoutPage logoutPage;
    private SignInPage signInPage;
    private LogoutComponent logoutComponent;

    public SeleniumPages(WebDriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    public HomePage home(){
        if (homePage == null){
            homePage = new HomePage(driverProvider);
        }
        return homePage;
    }

    public LogoutPage logout(){
        if (logoutPage == null){
        	logoutPage = new LogoutPage(driverProvider);
        }
        return logoutPage;
    }

    public SignInPage signIn(){
        if (signInPage == null){
        	signInPage = new SignInPage(driverProvider);
        }
        return signInPage;
    }
    
    public LogoutComponent logoutComponent() {
    	if (logoutComponent == null) {
    		logoutComponent = new LogoutComponent(driverProvider);
    	}
    	return logoutComponent;
    }
}
