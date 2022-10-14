package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

import io.cucumber.java.Scenario;
import io.cucumber.messages.types.TestCase;

public class GenericMethods extends CommonHelper {

	public void highlightElement(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",element);
			Thread.sleep(1000);
			js.executeScript("arguments[0].style.border=''", element, "");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterText(WebDriver driver, WebElement element, String text) {
		highlightElement(driver, element);
		element.sendKeys(text);
	}

	public void clickOnElement(WebDriver driver, WebElement element) {
		highlightElement(driver, element);
		element.click();
	}
	
	public void clickOnElementWithJsExecutor(WebDriver driver, WebElement element) {
		highlightElement(driver, element);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public boolean elementIsDisplayed(WebDriver driver, WebElement element) {
		try {
			highlightElement(driver, element);
			element.isDisplayed();
			return true;
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}
	
	public String getTextOfElement(WebDriver driver,WebElement element) {
		highlightElement(driver, element);
		return element.getText();
	}
	
	public void scrollIntoView(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void takeSnapShot(WebDriver webdriver,String pageName) {
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        String fileWithPath=System.getProperty("user.dir")+"\\Screenshots\\"+pageName+".png";
        File DestFile=new File(fileWithPath);
        try {
			Files.copy(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

    }



}


