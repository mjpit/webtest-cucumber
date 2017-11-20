Feature: Registreren
  Registreren van nieuwe cursisten.

  Background:
    Given I have a browser open
    When there are no registered users
    When I navigate to the home page


  @HappyFlow
  Scenario: Succesvolle registratie

    And I enter the user name Test
    And I enter the email test@test.test
    And I submit the registration
    Then I should arrive at the page titled Activeer cursist

    @FoutFlow
    Scenario: Een lege registratie
    When I submit the registration
   	Then we are still at the page titled "Registreer cursist"
   	And I should get error message Ongeldige registratie
