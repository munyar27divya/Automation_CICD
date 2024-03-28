package rahulShettyAcadamy.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulShettyAcadamy.abstractComponent.abstractComponent;

public class myOrders extends abstractComponent {
	WebDriver driver;

	public myOrders(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page factory method
	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover ng-star-inserted\"]/tbody/tr/td[2]")
	List<WebElement> myOrders;

	public boolean checkOrderIsPresent(String OrderName) {
		boolean match = myOrders.stream().anyMatch(ordername -> ordername.getText().equalsIgnoreCase(OrderName));
		return match;
	}

}
