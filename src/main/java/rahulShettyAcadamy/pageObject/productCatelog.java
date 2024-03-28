package rahulShettyAcadamy.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcadamy.abstractComponent.abstractComponent;

public class productCatelog extends abstractComponent {
	WebDriver driver;

	public productCatelog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page factory method
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsList = By.cssSelector(".mb-3");
	By productsNameBy = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {
		waitToElementGetVisible(productsList);
		return products;
	}

	public WebElement getProductName(String productName) {
		WebElement product = products.stream()
				.filter(products -> products.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return product;
	}

	public void addProcutToCart(String productName) {
		WebElement prod = getProductName(productName);
		prod.findElement(productsNameBy).click();
		waitToElementGetVisible(toastMsg);
		waitToElementGetInVisible(spinner);
	}

	public submitPage goToCartPage() {
		clickToCart();
		submitPage submitpg = new submitPage(driver);
		return submitpg;
	}

}
