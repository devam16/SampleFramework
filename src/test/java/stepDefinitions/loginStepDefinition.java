package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class loginStepDefinition {

	
	LoginPage loginpage=new LoginPage();
	HomePage homepage=new HomePage();
	CheckoutPage checkoutpage=new CheckoutPage();

	@Given("User is already on the application Login Page")
	public void user_is_already_on_the_application_login_page() {
		loginpage.validateUserIsOnApp();
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String userName, String pwd) {
		loginpage.enterUserName(userName);
		loginpage.enterPassword(pwd);
	}

	@When("User Clicks on the Login Button")
	public void user_clicks_on_the_login_button() {
		loginpage.clickLoginButton();
	}

	@Then("User should land on the HomePage")
	public void user_should_land_on_the_home_page() {
		Assert.assertTrue(homepage.validateProductsTabIsDisplayed());
	}
	
	@Then("User verifies the error Message {string}")
	public void user_verifies_the_error_message(String message) {
	    String errorMessage = loginpage.getTextOfElement();
	    Assert.assertEquals(errorMessage, message);
	}
	
	@Then("User adds {string} to the cart")
	public void user_adds_to_the_cart(String product) {
		homepage.addToCardProduct(product);
	    
	}
	
	@Then("User clicks on the Shopping Bag")
	public void user_clicks_on_the_shopping_bag() {
		homepage.clickOnShoppingBag();
	}
	

@Then("User validates the price of {string} is {string}")
public void user_validates_the_price_of_is(String product, String price) {
    String actPrice = checkoutpage.getPriceOfInventory(product);
    Assert.assertEquals(actPrice, price);
}


@Then("User Clicks on checkout option")
public void user_clicks_on_checkout_option() {
	checkoutpage.clickCheckoutButton();
}




	
	

}
