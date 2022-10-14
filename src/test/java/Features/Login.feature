Feature: free Login Action

Scenario: Test Login Page for testAutomation

Given User is already on the application Login Page
When User enters "standard_user" and "secret_sauce"
And User Clicks on the Login Button
Then User should land on the HomePage
Then User adds "Sauce Labs Onesie" to the cart
And User clicks on the Shopping Bag
Then User validates the price of "Sauce Labs Onesie" is "$7.99"
And User Clicks on checkout option


Scenario: Test Login Page for InvalidLogin
Given User is already on the application Login Page
When User enters "locked_out_user" and "secret_sauce"
And User Clicks on the Login Button
Then User verifies the error Message "Epic sadface: Sorry, this user has been locked out."

Scenario: Test For Api
Given User creates the payload with "bla" body
When User send a "POST" request to server
And User verifies the value in the field "name" in the response to be "Devam"