package rahulShettyAcadamy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulShettyAcadamy.abstractComponent.abstractComponent;
import rahulShettyAcadamy.baseComponents.baseTest;
import rahulShettyAcadamy.pageObject.checkoutpage;
import rahulShettyAcadamy.pageObject.landingPage;
import rahulShettyAcadamy.pageObject.myOrders;
import rahulShettyAcadamy.pageObject.productCatelog;
import rahulShettyAcadamy.pageObject.submitPage;

public class submitOrderTest extends baseTest {

	// String productName = "ZARA COAT 3";
	String countryName = "india";

	@Test(groups = { "errorHandling" }, dataProvider = "getdata")
	public void SubmitOrder(HashMap<String, String> Input) throws IOException, InterruptedException {

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productCatelog productCatelogPage = landingPageobj.loginApplication(Input.get("emailId"),
				Input.get("password"));
		productCatelogPage.addProcutToCart(Input.get("productName"));
		submitPage submitpg = productCatelogPage.goToCartPage();
		Boolean flag = submitpg.checkItemPresent(Input.get("productName"));
		Assert.assertTrue(flag);
		checkoutpage checkoutpage = submitpg.clickCheckOut();
		checkoutpage.selectCountry(countryName);
		checkoutpage.submitOrder();
		String confirmMessage = checkoutpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@Test(dependsOnMethods = { "SubmitOrder" })
	public void checkOrderIsPlaced() throws IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productCatelog productCatelogPage = landingPageobj.loginApplication("testsel@gmail.com", "Test@123");
		myOrders myOrdersPg = productCatelogPage.clickToOrders();
		Assert.assertTrue(myOrdersPg.checkOrderIsPresent("ZARA COAT 3"));

	}

	@DataProvider
	public Object[][] getdata() throws IOException {
		// return new Object [] [] {{"testsel@gmail.com", "Test@123","ZARA COAT
		// 3"},{"testD@gmail.com","Test@123","ADIDAS ORIGINAL"}};

		/*
		 * HashMap<String, String> map = new HashMap<String, String>();
		 * map.put("emailId", "testsel@gmail.com"); map.put("password", "Test@123");
		 * map.put("productName", "ZARA COAT 3");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String, String>();
		 * map1.put("emailId", "testD@gmail.com"); map1.put("password", "Test@123");
		 * map1.put("productName", "ADIDAS ORIGINAL"); return new Object[][] { { map },
		 * { map1 } };
		 */

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "\\src\\test\\java\\rahulShettyAcadamy\\data\\purchaseOrder.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}