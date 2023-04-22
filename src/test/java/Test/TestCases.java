package Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CheckoutPage;
import pom.LoginPage;
import pom.ProductCartPage;
import pom.ProductPage;
import pom.ProductSpecification;
import utility.Parametrization;

public class TestCases extends BaseTest {

	@BeforeMethod
	public void launchBrowser() {
		driver = Browser.launchBrowser("Chrome");
	}
	@Test(priority=1)
	public void VerifyCustomerIsAbleToAddProductOnCart() throws EncryptedDocumentException, IOException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterUsername(Parametrization.getExcelData(1, 0, "credential"));
		loginpage.EnterPassword(Parametrization.getExcelData(1, 1, "credential"));
		loginpage.ClickonSubmitButton();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.getproductname(0);
		
		ProductSpecification productspecification= new ProductSpecification(driver);
		productspecification.clickonaddtocart();
		productspecification.clickonshoppingcart();
		
		ProductCartPage productcarpage=new ProductCartPage(driver);
		Assert.assertEquals(productcarpage.getcartitems(), 1);
	}
	@Test(priority=2)
	public void RemoveSingleProductFromCart() throws EncryptedDocumentException, IOException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterUsername(Parametrization.getExcelData(1, 0, "credential"));
		loginpage.EnterPassword(Parametrization.getExcelData(1, 1, "credential"));
		loginpage.ClickonSubmitButton();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.getproductname(0);
		
		ProductSpecification productspecification= new ProductSpecification(driver);
		productspecification.clickonaddtocart();
		productspecification.clickonshoppingcart();
		
		ProductCartPage productcarpage=new ProductCartPage(driver);
		productcarpage.clickonremove(0);
		Assert.assertEquals(productcarpage.getcartitems(), 0);
	}
	@Test(priority=3)
	public void AddSingleProductOnCartByProductPage() throws EncryptedDocumentException, IOException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterUsername(Parametrization.getExcelData(1, 0, "credential"));
		loginpage.EnterPassword(Parametrization.getExcelData(1, 1, "credential"));
		loginpage.ClickonSubmitButton();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.clickonaddtocart(0);
		productpage.clickonshoppingcart();
		
		ProductCartPage productcarpage=new ProductCartPage(driver);
		productcarpage.proceedtocheckout();
		
	}
	@Test(priority=4)
	public void removeSingleProductOnCartByProductPage() throws EncryptedDocumentException, IOException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterUsername(Parametrization.getExcelData(1, 0, "credential"));
		loginpage.EnterPassword(Parametrization.getExcelData(1, 1, "credential"));
		loginpage.ClickonSubmitButton();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.clickonaddtocart(0);
		productpage.clickonremove(0);
  }
	@Test(priority=5)
	public void AddMultipleProductToCart() throws EncryptedDocumentException, IOException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterUsername(Parametrization.getExcelData(1, 0, "credential"));
		loginpage.EnterPassword(Parametrization.getExcelData(1, 1, "credential"));
		loginpage.ClickonSubmitButton();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.getproductname(0);
		ProductSpecification productspecification= new ProductSpecification(driver);
		productspecification.clickonaddtocart();
		productspecification.clickonshoppingcart();
		
		ProductCartPage productcarpage=new ProductCartPage(driver);
		productcarpage.clickoncontinueshoppingbutton();
		productpage.getproductname(1);
		productspecification.clickonaddtocart();
		productspecification.clickonshoppingcart();
		Assert.assertEquals(productcarpage.getcartitems(), 2);


	}
	@Test(priority=6)
	public void VerifyifaCustomerabletoplace() throws EncryptedDocumentException, IOException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterUsername(Parametrization.getExcelData(1, 0, "credential"));
		loginpage.EnterPassword(Parametrization.getExcelData(1, 1, "credential"));
		loginpage.ClickonSubmitButton();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.clickonaddtocart(0);
		productpage.clickonshoppingcart();
		
		ProductCartPage productcarpage=new ProductCartPage(driver);
		productcarpage.proceedtocheckout();
		
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.EnterFirstName(Parametrization.getExcelData(1, 0, "credential"));
		checkoutpage.EnterLastName(Parametrization.getExcelData(1, 0, "credential"));
		checkoutpage.EnterZipCode(Parametrization.getExcelData(1, 0, "credential"));
		checkoutpage.ClickonContinueButton();
		checkoutpage.ClickonFinishButton();
		Assert.assertEquals(checkoutpage.GetTitle(), "Thank you for your order!");
	}
	@Test(priority=7)
	public void VerifyLogoutFeature() throws EncryptedDocumentException, IOException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.EnterUsername(Parametrization.getExcelData(1, 0, "credential"));
		loginpage.EnterPassword(Parametrization.getExcelData(1, 1, "credential"));
		loginpage.ClickonSubmitButton();
		
		ProductPage productpage=new ProductPage(driver);
		productpage.clickonaddtocart(0);
		productpage.clickonshoppingcart();
		
		ProductCartPage productcarpage=new ProductCartPage(driver);
		productcarpage.proceedtocheckout();
		
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.EnterFirstName(Parametrization.getExcelData(1, 0, "credential"));
		checkoutpage.EnterLastName(Parametrization.getExcelData(1, 0, "credential"));
		checkoutpage.EnterZipCode(Parametrization.getExcelData(1, 0, "credential"));
		checkoutpage.ClickonContinueButton();
		checkoutpage.ClickonFinishButton();
		checkoutpage.ClickonoptionmenuButton();
		checkoutpage.ClickonlogoutButton();
		Assert.assertEquals(checkoutpage.GetTitleOnLoginPage(), "Swag Labs");
		
	}
}
