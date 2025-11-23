@contact-us @regression
Feature:  Webdriver University Contact Us page

   Scenario: Validate Successful submission - Unique Data
     Given I access the webdriver university contact us page
     When I enter a unique First Name
     And I Enter a unique Last Name
     And I Enter a unique Email address
     And  I Enter a unique Comment
     And I Click on the submit button
     Then I Should be presented with a successful contact us submission message

