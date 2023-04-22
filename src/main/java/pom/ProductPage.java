package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	@FindBy(xpath="//div[@class='inventory_item_description']")private List<WebElement> products;
	@FindBy(xpath="//div[@class='inventory_item_description']")private List<WebElement> addtocart;
	@FindBy(xpath="//button[@class='btn btn_secondary btn_small btn_inventory']")private List<WebElement> remove;
	@FindBy(xpath="//div[@class='inventory_item_name']")private List<WebElement> productsname;
	@FindBy(xpath="//a[@class='shopping_cart_link']")private WebElement shoppingcart;
	public ProductPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
	 public int getnumberofproductdisplyedonpage() {
		 int size =products.size();
		 return size;
	 }
	public void selectproduct(int index) {
		products.get(index).click();
	}
	 public void getproductname(int index1) {
		 productsname.get(index1).click();
	 }
		public void clickonaddtocart(int index) {
			addtocart.get(index).click();
		}
		public void clickonshoppingcart() {
			shoppingcart.click();
		}
		public void clickonremove(int index) {
			remove.get(index).click();
		}
}
