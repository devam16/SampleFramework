package stepDefinitions;


import Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	BaseClass bc =new BaseClass();
	Scenario scenario;
	
	@Before
	public void setup() throws InterruptedException {
		bc.initializeDriver();
		bc.openAppUrl();
		bc.setBaseUri();
	}
	
	@After
	public void stop() {
		bc.teardown();
	}
	
	
	
}
