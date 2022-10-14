package Utilities;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class BaseClass extends GenericMethods {
	
	public static WebDriver driver;
	public static Scenario scenario;
	String configFile=System.getProperty("user.dir")+"\\Resources\\config.properties";
	String driverPath=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	
	
	
	
	@SuppressWarnings({ "deprecation", "static-access" })
	public WebDriver initializeDriver() {
		String browserName=loadPropertyFileAndGetValue(configFile,"browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			this.driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}
	

	public void openAppUrl() throws InterruptedException {
		String app=loadPropertyFileAndGetValue(configFile,"appUrl");
		driver.get(app);
		driver.navigate().refresh();
		Thread.sleep(5000);
	}
	
	public void teardown() {
			driver.quit();
		}
	
    public void initializeScenario(Scenario scenario) {
        this.scenario = scenario;
    }
    
    public void setBaseUri() {
    	String base=loadPropertyFileAndGetValue(configFile,"baseUri");
    	RestAssured.baseURI=base;
    }
    
    

	


}
