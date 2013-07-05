Feature: Non-functional requirements

  Scenario: response size validation
    When "admin" user requests his sites
    Then response size is not larger than "500"KB