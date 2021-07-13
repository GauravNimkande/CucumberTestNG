Feature: Contact us feature
Scenario Outline: Contact Us scenario with different set of data 
Given user is navigate to contact us page
When user fills the from given sheetname "<Sheetname>" and rownumber <RowNumber>
And user clicks on snnd button
Then it shows a successful message "Your message has been successfully sent to our team."

Examples: 
|SheetName|RowNumber|
|contactus|0|
|contactus|1|