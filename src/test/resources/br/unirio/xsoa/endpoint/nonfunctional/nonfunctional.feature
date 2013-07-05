Feature: Sites download

  AS admin user
  I WANT to download the sites assigned to me
  SO THAT I'm able to assess the work produced in those sites

  Scenario: response size validation
    When "admin" user requests his sites
    Then response size is not larger than "500"KB