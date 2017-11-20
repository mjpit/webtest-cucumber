Feature: Activeren
  Activeren van een registratie

@dev
  Scenario: Succesvolle Activatie
    Given i am on the activeer page voor user barry
    When I enter username barry
    And I enter the activation code secret-barry
    And I submit the activation
    Then I should arrive at the Account page



   