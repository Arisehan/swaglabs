package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@id='user-name']")private WebElement username;
	@FindBy(xpath="//input[@id='password']")private WebElement password;
	@FindBy(xpath="//input[@class='submit-button btn_action']")private WebElement submitbutton; 
    public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
    public void EnterUsername(String name) {
        username.sendKeys(name);
    }
    public void EnterPassword(String pass) {
    	password.sendKeys(pass);
    }
    public void ClickonSubmitButton() {
    	submitbutton.click();
    }
}
