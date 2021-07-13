Feature: Account Page Feature

Background:
Given user has already login into the application
| username | password |
| noreply.gttservice@gmail.com | abc@123 |

Scenario: account page title
Given user is on account page
When user get the title of the page
Then account page title should be "My account - My Store"

Scenario: account section count 
Given user is on account page
Then user gets account section
| Order history and details |
| My credit slips |
| My addresses |
| My personal information |
| My wishlists | 
And account section count should be 5

