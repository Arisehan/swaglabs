package pom;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductCartPage {
	@FindBy(xpath="//button[@class='btn btn_secondary btn_small cart_button']")private List<WebElement> remove;
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium']")private WebElement continueshopping;
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button']")private WebElement checkout;
	@FindBy(xpath="//div[@class='cart_item']")private List<WebElement> qtyofproduct;

	public ProductCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void proceedtocheckout() {
		checkout.click();
	}
	public void clickonremove(int index) {
		remove.get(0).click();
	}
	public void clickoncontinueshoppingbutton() {
		continueshopping.click();
	}
	public int getcartitems() {
		int size=qtyofproduct.size();
    	return size;	
	}
}
