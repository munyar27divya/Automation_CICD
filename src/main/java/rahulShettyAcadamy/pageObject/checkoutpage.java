package rahulShettyAcadamy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulShettyAcadamy.abstractComponent.abstractComponent;

public class checkoutpage extends abstractComponent {

	WebDriver driver;

	public checkoutpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	private WebElement countryEditBox;

	@FindBy(xpath = "(//span[@class='ng-star-inserted'])[2]")
	private WebElement countrySelect;

	@FindBy(xpath = "//a[@class=\"btnn action__submit ng-star-inserted\"]")
	private WebElement submitBtn;

	@FindBy(css = ".hero-primary")
	private WebElement confirmationbtn;

	private By countryResult = By.cssSelector(".ta-results");
	private By placeOrderBtn = By.xpath("//a[@class=\"btnn action__submit ng-star-inserted\"]");

	public void selectCountry(String countryName) throws InterruptedException {
		Actions a = new Actions(driver);
		a.sendKeys(countryEditBox, countryName).build().perform();
		waitToElementGetVisible(countryResult);
		countrySelect.click();
		Thread.sleep(5000);
	}

	public void submitOrder() {
		scrollDrown();
		Actions a = new Actions(driver);
		a.moveToElement(submitBtn).build().perform();
		waitforElementClickable(placeOrderBtn);
		submitBtn.click();
	}

	public String getConfirmationMessage() {
		String confirmMessage = confirmationbtn.getText();
		return confirmMessage;
	}
}
