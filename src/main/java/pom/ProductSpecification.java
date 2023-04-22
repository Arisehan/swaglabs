package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSpecification {
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")private WebElement addtocart;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement shoppingcart;
	public ProductSpecification(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickonaddtocart() {
		addtocart.click();
	}
	public void clickonshoppingcart() {
		shoppingcart.click();
	}
}
