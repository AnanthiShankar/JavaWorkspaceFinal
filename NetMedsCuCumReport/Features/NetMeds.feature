Feature: Netmeds Login
Description: This test is to check the login functionality of the NetmedsApp

Background:  Login Successful
Given User is on Netmeds homepage 
When user enters PhoneNUmber
And User clicks sendOtp
And user enters Otp and clicks on Verify
Then Login is Successful if Otp is correct

Scenario: Adding Products to cart and Reviewing
And user add Medicine to cart
And user adds beauty product to cart
And Order is placed
And User is on the cart page
And User clicks on Proceed button and navigates to cartpage
Then Removes Items in the cart and Logsout


