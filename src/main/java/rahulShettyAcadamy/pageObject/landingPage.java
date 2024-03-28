package rahulShettyAcadamy.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcadamy.abstractComponent.abstractComponent;

public class landingPage extends abstractComponent {
	WebDriver driver;

	public landingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmailId = driver.findElement(By.id("userEmail"));

	// page factory method
	@FindBy(id = "userEmail")
	WebElement userEmailId;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;

	@FindBy(xpath = "//div[contains(@class,'toast-message')]")
	WebElement errorMesaage;

	public productCatelog loginApplication(String emailId, String pwd) {
		userEmailId.sendKeys(emailId);
		userPassword.sendKeys(pwd);
		login.click();
		// productCatelog productCatelogPage = new productCatelog(driver);
		// return productCatelogPage;
		productCatelog productCatelogPage = new productCatelog(driver);
		return productCatelogPage;
	}

	public void gotoApplication() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		waitToElementToAppear(errorMesaage);
		return errorMesaage.getText();
	}
}
