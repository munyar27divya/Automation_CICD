package rahulShettyAcadamy.tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulShettyAcadamy.baseComponents.baseTest;
import rahulShettyAcadamy.pageObject.productCatelog;
import rahulShettyAcadamy.pageObject.submitPage;

public class errorValidationTest extends baseTest {
	String productName = "ZARA COAT 3";

	@Test(retryAnalyzer = rahulShettyAcadamy.baseComponents.retry.class)
	public void loginErrorValidation() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		landingPageobj.loginApplication("testD@gmal.com", "Test@123");
		String errorMsg = landingPageobj.getErrorMessage();
		Assert.assertEquals(errorMsg, "Icorrect email or password.");
	}

	@Test
	public void productCatelogErrorValidation() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		productCatelog productCatelogPage = landingPageobj.loginApplication("testD@gmail.com", "Test@123");
		productCatelogPage.addProcutToCart(productName);
		submitPage submitpg = productCatelogPage.goToCartPage();
		Boolean flag = submitpg.checkItemPresent("Iphone");
		Assert.assertFalse(flag);
	}

}
