package rahulShettyAcadamy.stepDefination;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulShettyAcadamy.baseComponents.baseTest;
import rahulShettyAcadamy.pageObject.checkoutpage;
import rahulShettyAcadamy.pageObject.landingPage;
import rahulShettyAcadamy.pageObject.productCatelog;
import rahulShettyAcadamy.pageObject.submitPage;

public class stepDefinationImpl extends baseTest {

	public landingPage landingPageobj;
	public productCatelog productCatelogPage;
	public submitPage submitpg;
	public checkoutpage checkoutpage;

	@Given("I landed on ecommerce website")
	public void I_landed_on_ecommerce_website() throws IOException {
		landingPageobj = launchApplication();
	}

	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_In_username_password(String username, String password) {
		productCatelogPage = landingPageobj.loginApplication(username, password);
	}

	@When("^I have added the product (.+) to cart$")
	public void I_have_added_product_cart(String product) {
		productCatelogPage.addProcutToCart(product);
	}

	@When("^checkout (.+) and submit the order$")
	public void checkout_submit_order(String product) throws InterruptedException {
		submitpg = productCatelogPage.goToCartPage();
		Boolean flag = submitpg.checkItemPresent(product);
		Assert.assertTrue(flag);
		checkoutpage = submitpg.clickCheckOut();
		checkoutpage.selectCountry("india");
		checkoutpage.submitOrder();
	}

	@Then("{string} message is displayed on confirmation page")
	public void message_displayed_confirmation_page(String string) {
		String confirmMessage = checkoutpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}

	@Then("{string} error message is displayed")
	public void error_message_displayed(String string) {
		String errorMsg = landingPageobj.getErrorMessage();
		Assert.assertEquals(errorMsg, string);
		driver.close();
	}

}
