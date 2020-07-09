Feature: Inspect login page elements

  Scenario: Confirm all page elements appear as expected
    Given user is on login page
    Then user should see test project logo
    And user should see bold title and introductory paragraph
    And user should see free sign up button
    And user should see watch demos label
    And user should see web button
    And user should see mobile button
    And user should see bold title in login form
    And user should see description text in login form
    And user should see password hint text in login form
    And user should see try test project label in footer
    And user should see support email address in footer
    And user should see twitter link in footer
    And user should see facebook link in footer
    And user should see free signup button in footer
    
Scenario: Confirm top signup button sends user to signup page 
    Given user is on login page
    When user clicks top signup button
    Then user lands on signup page
    
Scenario: Confirm footer signup button sends user to signup page
    Given user is on login page
    When user clicks footer signup button
    Then user lands on signup page