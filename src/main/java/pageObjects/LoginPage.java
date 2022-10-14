package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.BaseClass;

public class LoginPage extends BaseClass {
	private By userNameField=By.xpath("//input[@id='user-name']");	
	private By passwordField=By.xpath("//input[@id='password']");	
	private By loginButton=By.cssSelector("input[value='Login']");
	private By loginError=By.xpath("//h3[@data-test='error']");
			
	
	public String validateUserIsOnApp() {
		 return driver.getTitle();
	}
	
	public void enterUserName(String username) {
		WebElement element = driver.findElement(userNameField);
		enterText(driver, element, username);
	}
	
	public void enterPassword(String password) {
		WebElement element = driver.findElement(passwordField);
		enterText(driver, element, password);
	}
	
	public void clickLoginButton() {
		WebElement element=driver.findElement(loginButton);
		clickOnElement(driver, element);
	}
	
	public String getTextOfElement() {
		WebElement element = driver.findElement(loginError);
		takeSnapShot(driver, this.getClass().getSimpleName());
		return getTextOfElement(driver, element);
	}
	

}
