Feature: NetMeds 
Description: This test is to check the NetMeds functionality 

Background: user is logged in
Given User is on the NetMeds HomePage
When User enters the Phonenumber details
And User enters the OTP details
And User clicks the VerifyButton
Then Login is successful

Scenario: Medicine Item added to cart
Given User is on Homepage
When User selects medicines
And User selects Product and Add to cart
Then Item is added to cart successfully

Scenario: Beauty product
Given User is on HomePage
When User Selects Beauty
And User Selects HairProducts and added to cart
Then Item is added to cart successfully

Scenario: CartPage
Given User is on the cart page
When User clicks on Proceed button and navigates to cartpage
Then Removes Items in the cart and Logsout