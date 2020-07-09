Feature: Test homepage form entry functionality

  Scenario Outline: Confirm user can save homepage form data.
    Given user is logged in and on homepage
    When subscriber inputs '<country>' '<address>' '<email>' and '<phone>' in all address fields
    And user clicks save button
    Then the saved message appears

    Examples: 
      | country       | address      | email             | phone        |
      | United States | 122 Main St. | mcarway@gmail.com | 889-999-0987 |
     