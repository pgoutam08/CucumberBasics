Feature: EnterCarDetals
  This feature deals with entering the car details and saving the details in the User profile.

  Scenario: Enter the car details
    Given I navigate to the Car details page
    When I enter the car details
    Then I should be able to see the entered details

  
  Scenario: Upload pro-forma invoice
    Given I navigate to the Car details page
    When I select a file to upload
    And I click on upload button
    Then the document should be uploaded

   
