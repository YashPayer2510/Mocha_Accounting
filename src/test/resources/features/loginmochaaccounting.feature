Feature: Test the login flow for Mocha Accounting system
 @Loginflow
  Scenario: Check the Login flow
   	Given Browser is open
    And User is on the login page
    When User enters the "<emailID>" and "<password>"
    And User clicks on the Login button
    Then User should see "<expectedMessage>"
	 Examples: 
      | emailID   							| password 			|   expectedMessage   					 |
      | kayatix325@cgbird.com 	| Mocha@2024 		|  Dashboard              			 |
      | kayatix325@cgbird.com 	| Mocha@20241  	|  Invalid username or password	 |
			| kayatix325@cg.com	 			| Mocha@2024 		|	 Invalid username or password  |	   
