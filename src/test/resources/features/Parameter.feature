@parameter
Feature:  Testing parameters

Scenario: Validate Successful submissions - Unique Data
Given I access the webdriver universitys contact us page
When I enter a unique First Names tester
And I Enter a unique Last Names blogs
And I Enter a unique Email addresss testblogs@email.com
And  I Enter a unique Comments "how are you"
And I Click on the submits button
Then I Should be presented with a successful contact us submission messages