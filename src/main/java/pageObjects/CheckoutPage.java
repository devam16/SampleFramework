package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.BaseClass;

public class CheckoutPage extends BaseClass {
	private String productxpath="//div[text()='Product']/parent::a/parent::div//div[@class='inventory_item_price']";
	private By checkoutBttn=By.id("checkout");
	
	
	public String getPriceOfInventory(String product) {
		String addedproductxpath=productxpath.replaceAll("Product", product);
		WebElement element=driver.findElement(By.xpath(addedproductxpath));
		highlightElement(driver, element);
		takeSnapShot(driver,this.getClass().getSimpleName());
		return element.getText();
	}
	
	public void clickCheckoutButton() {
		WebElement element=driver.findElement(checkoutBttn);
		clickOnElementWithJsExecutor(driver, element);
		takeSnapShot(driver,this.getClass().getSimpleName());
		
	}
}
