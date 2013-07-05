xsoa-example
=============

This project is a sample implementation of a web service according to XSOA method proposed for SBCARS 2013.

Scenario
--------

SmartBrick company has developed a product to assess a construction site productivity according to the productive
hours or workers when working on a building, house or any other civil engineering activity.

This product is made of a mobile app that allows any smartphone to act as a PDA, enabling a field technician to register
the activities performed by workers in a given site along the day. Later, this information will be uploaded to a database,
enabling data analysts to extract productivity indices from those.

The information available for users to download is based on roles. Admin users are able to register activities for
any site. Other users are only able to see information regarding the sites they were assigned to.

An important non-function restriction is that, due to performance and bandwith constraints, any message exchanged between
app and server (for either upload or downloading data) cannot exceed 500 KB.

Acceptance Criteria
-------------------

### Feature: Sites download  
  
  AS admin user  
  I WANT to download the sites assigned to me  
  SO THAT I'm able to assess the work produced in those sites  

  Scenario: admin user is able to assess two sites  
    Given two sites, both assigned to admin user and one of them assigned to backup user  
    When "admin" user requests the download of his sites  
    Then "2" sites are downloaded, namely "BACKUP SITE" and "CENTRAL SITE", in this order  
    And "CENTRAL SITE" has "4" activities  
    And "CENTRAL SITE" has "2" scenarios  
    And "BACKUP SITE" has "2" activities  
    And "BACKUP SITE" has "2" scenarios  
    And "BACKUP SITE" activities are "CLEAN" and "NAIL" in this order  

  Scenario: backup user is able to assess one site  
    Given two sites, both assigned to admin user and one of them assigned to backup user  
    When "backup" user requests the download of his sites  
    Then "1" site is downloaded, namely "BACKUP SITE"  
    And "BACKUP SITE" has "2" activities  
    And "BACKUP SITE" has "2" scenarios  
    And "BACKUP SITE" activities are "CLEAN" and "NAIL" in this order  
  
  
### Feature: Non-functional requirements  
  
  Scenario: response size validation  
    When "admin" user requests his sites  
    Then response size is not larger than "500"KB  

BENEFITS
========
1. Acceptance criteria are automated and guaranteed by tests suite
2. If response size exceeds threshold instant feedback is provided by tests
3. Errors are not left for a separate phase, product is deployed with all features tested