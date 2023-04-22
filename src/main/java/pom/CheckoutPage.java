package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	@FindBy(xpath="//input[@id='first-name']")private WebElement firstname;
	@FindBy(xpath="//input[@id='last-name']")private WebElement lastname;
	@FindBy(xpath="//input[@id='postal-code']")private WebElement zipcode;
	@FindBy(xpath="//h2[text()='Thank you for your order!']")private WebElement gettitle;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium cart_button']")private WebElement finish;
	@FindBy(xpath="//input[@class='submit-button btn btn_primary cart_button btn_action']")private WebElement continuebutton; 
	@FindBy(xpath="//button[@id='react-burger-menu-btn']")private WebElement optionmenu;
	@FindBy(xpath="//a[@id='logout_sidebar_link']")private WebElement logout;
	@FindBy(xpath="//div[text()='Swag Labs']")private WebElement gettitleonloginpage;

	public CheckoutPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
    public void EnterFirstName(String name) {
    	firstname.sendKeys(name);
    }
    public void EnterLastName(String name) {
    	lastname.sendKeys(name);
    }
    public void EnterZipCode(String name) {
    	zipcode.sendKeys(name);
    }
    public void ClickonContinueButton() {
    	continuebutton.click();
    }
    public void ClickonFinishButton() {
    	finish.click();
    }
    public String GetTitle() {
    	return gettitle.getText();
    }
    public void ClickonoptionmenuButton() {
    	optionmenu.click();
    }
    public void ClickonlogoutButton() {
    	logout.click();
    }
    public String GetTitleOnLoginPage() {
    	return gettitleonloginpage.getText();
    }
}
