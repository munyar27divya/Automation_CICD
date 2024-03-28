package rahulShettyAcadamy.abstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulShettyAcadamy.pageObject.myOrders;
import rahulShettyAcadamy.pageObject.submitPage;

public class abstractComponent {

	WebDriver driver;

	public abstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartIcon;

	@FindBy(xpath = "//button[@routerlink=\"/dashboard/myorders\"]")
	WebElement orders;

	public void waitToElementGetVisible(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait till items visible
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}

	public void waitToElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait till items visible
		wait.until(ExpectedConditions.visibilityOf(ele));
		;
	}

	public void waitToElementGetInVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait till items invisible
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public void clickToCart() {
		cartIcon.click();

	}

	public myOrders clickToOrders() {
		orders.click();
		myOrders myOrdersPg = new myOrders(driver);
		return myOrdersPg;
	}

	public void scrollDrown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}

	public void waitforElementClickable(By findby) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait till items visible
		wait.until(ExpectedConditions.elementToBeClickable(findby));
	}

}
