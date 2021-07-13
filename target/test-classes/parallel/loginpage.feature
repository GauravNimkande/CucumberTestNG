Feature: Login Page Feature

Scenario: Login Page Title
Given user is on login page
When user get the title of the page title should be "Login - My Store"

Scenario: forget password link
When user is on login page
Then forget password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters user name as "noreply.gttservice@gmail.com"
And user enters password is "abc@123"
And user clicks on login button
Then user get the title of the page
And account page title should be "My account - My Store"