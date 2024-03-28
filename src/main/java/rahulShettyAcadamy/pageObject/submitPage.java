package rahulShettyAcadamy.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcadamy.abstractComponent.abstractComponent;

public class submitPage extends abstractComponent {
	WebDriver driver;

	public submitPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// List<WebElement> cartProducts =
	// driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
	// page factory method
	@FindBy(xpath = "//div[@class='cartSection']/h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[@type='button'][text()='Checkout']")
	WebElement checkout;

	By checkOutBy = By.xpath("//button[@type='button'][text()='Checkout']");

	public Boolean checkItemPresent(String productName) {
		Boolean match = cartProducts.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	public checkoutpage clickCheckOut() {
		scrollDrown();
		waitforElementClickable(checkOutBy);
		checkout.click();
		checkoutpage checkoutpage = new checkoutpage(driver);
		return checkoutpage;
	}

}
