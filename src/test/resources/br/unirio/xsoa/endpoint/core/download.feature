Feature: Sites download

  AS admin user
  I WANT to download the sites assigned to me
  SO THAT I'm able to assess the work produced in those sites

  Scenario: admin user is able to assess two sites
    Given two sites, both assigned to admin user and one of them assigned to backup user
    When "admin" user requests the download of his sites
    Then "2" sites are downloaded, namely "BACKUP SITE" and "CENTRAL SITE", in this order
    And "CENTRAL SITE" has been configured with "4" activities
    And "CENTRAL SITE" has been configured with "2" scenarios
    And "BACKUP SITE" has "2" activities
    And "BACKUP SITE" has "2" scenarios
    And "BACKUP SITE" activities are called "CLEAN" and "NAIL" in this order

  Scenario: backup user is able to assess one site
    Given two sites, both assigned to admin user and one of them assigned to backup user
    When "backup" user requests the download of his sites
    Then "1" site is downloaded, namely "BACKUP SITE"
    And "BACKUP SITE" has "2" activities
    And "BACKUP SITE" has "2" scenarios
    And "BACKUP SITE" activities are "CLEAN" and "NAIL" in this order