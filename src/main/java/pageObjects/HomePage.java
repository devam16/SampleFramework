package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.BaseClass;

public class HomePage extends BaseClass {
	private String addToCartLocator="//div[text()='ProductSelected']/parent::a/parent::div/following-sibling::div//button[contains(@id,'add-to-cart')]";
	
	private By productTabLogo=By.xpath("//span[text()='Products']");
	private By shoppingBag=By.xpath("//a[@class='shopping_cart_link']");
	
	
	public boolean validateProductsTabIsDisplayed() {
		WebElement element=driver.findElement(productTabLogo);
		return elementIsDisplayed(driver, element);
	}
	
	public void addToCardProduct(String productName) {
		String addProdToCartLocator=addToCartLocator.replace("ProductSelected", productName);
		WebElement element=driver.findElement(By.xpath(addProdToCartLocator));
		scrollIntoView(driver, element);
		clickOnElement(driver, element);
	}
	
	public void clickOnShoppingBag(){
		WebElement element=driver.findElement(shoppingBag);
		scrollIntoView(driver, element);
		clickOnElement(driver, element);
	}

}
