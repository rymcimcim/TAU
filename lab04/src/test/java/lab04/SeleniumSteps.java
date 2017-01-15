package lab04;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;


public class SeleniumSteps {

	private static final String LOGOUT_PAGE_TITLE = "Wylogowany | Mezzanine";
	private static final String GALLERY_PAGE_TITLE = "Dodaj Galeria | Mezzanine";
	private static final String SUBPAGES_PAGE_TITLE = "Zaznacz Strona aby zmienić | Mezzanine";
	private static final String SIGNIN_PAGE_TITLE = "Zaloguj się | Mezzanine";
	private static final String ERROR_TEXT = "Wprowadź poprawne dane w polach \"użytkownik\" i \"hasło\" dla konta należącego do zespołu. Uwaga: wielkość liter może mieć znaczenie.";
	private static final String HOME_PAGE_TITLE = "Administracja stroną | Mezzanine";
	
	private SeleniumPages pages;

	public SeleniumSteps(SeleniumPages pages){
		this.pages = pages;
	}
	
	@Given("a SignInForm")
	public void goToSignInPage() {
		pages.signIn().open();
	}
	
	@Given("a $param Page")
	public void goToParam(String param) {
		if (param.equals("Logout")){
			pages.logout();	
		} else if (param.equals("Home")) {
			pages.home();
		}
	}
	
	@Given("a SidePanel")
	public void getSidePanel() {
		pages.sidePanel();
	}
	
	@When("set login and password to $a and $b")
	public void setLoginPassword(String a, String b){
		pages.signIn().loginAs(a, b);
	}
	
	@When("click on $param button")
	public void goTo(String param){
		if (param.equals("logout")) {
			pages.logoutComponent().logout();
		} else {
			pages.logout().getBackToSignIn();
		}
	}
	
	@When("click on $param link")
	public void goToLink(String param){
		if (param.equals("subpages")) {
			pages.sidePanel().goToSubPages();
		} else if (param.equals("selectAdd")) {
			pages.subpagesPage().goToCreateGallery();
		}
	}
	
	@Then("browser should give an authentication error")
	public void checkError(){
	    assert(pages.signIn().getErrorLoginText().equals(ERROR_TEXT));
	}
	
	@Then("should get $param title")
	public void checkLogout(String param){
		if (param.equals("logout")) {
		    assert(pages.logout().getTitle().equals(LOGOUT_PAGE_TITLE));
		} else if (param.equals("home")) {
			assert(pages.home().getTitle().equals(HOME_PAGE_TITLE));
		} else if (param.equals("subpages")) {
			assert(pages.subpagesPage().getTitle().equals(SUBPAGES_PAGE_TITLE));
		} else if (param.equals("gallery")) {
			assert(pages.subpagesPage().getTitle().equals(GALLERY_PAGE_TITLE));
		}
		else {
			assert(pages.signIn().getTitle().equals(SIGNIN_PAGE_TITLE));
		}
	}
}
