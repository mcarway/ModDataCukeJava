Feature: Test login security control functionality

  Scenario Outline: Check valid login functionality
    Given browser is open
    And user is on login page
    When user enters '<username>' and '<password>'
    And user clicks login
    Then user is directed to the home page

    Examples: 
      | username   | password |
      | Mark Smith |    12345 |

  Scenario Outline: Check invalid password functionality
    Given browser is open
    And user is on login page
    When user enters '<username>' and '<password>'
    And password is invalid
    And user clicks login
    Then user remains on login page
    And user receives proper error messages

    Examples: 
      | username   | password |
      | Cindy Jones |    12335 |

  Scenario Outline: Check invalid username functionality
    Given browser is open
    And user is on login page
    When user enters '<username>' and '<password>'
    And username is invalid
    And user clicks login
    Then user remains on login page
    And user receives proper error messages

    Examples: 
      | username   | password |
      |  |    12345 |


 # Scenario Outline: Check login error messages function as expected
 #   Given browser is open
 #   And user is on login page
 #   When invalid '<username>' and '<password> are entered'
 #   Then user remains on login page
 #   And user receives proper error messages

 #   Examples: 
 #     | username   | password |
 #     | Mike | 23 |
 #     | Cindy | 1234 |

