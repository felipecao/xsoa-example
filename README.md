xsoa-example
=============

This project is a sample implementation of services according to the proposal depicted in "A Method for Service Agile Construction" article, submitted to SBSI 2014 by Felipe Carvalho, Leonardo Guerreiro Azevedo and Gleison Santos.

Scenario
--------

SmartBrick company has developed a product to assess a construction site's productivity according to the productive
hours of workers when working on a building, house or any other civil engineering activity.

This product is made of a mobile app that allows any smartphone to act as a PDA, enabling a field inspector to track and register
the activities performed by workers in a given construction site along the day. Later, this information will be uploaded to a database,
enabling data analysts to extract productivity indices from that data.

The information available for users to download is based on roles. Admin users are able to register activities for
any site. Other users are only able to log information regarding the sites they were assigned to.

An important non-functional restriction is that, due to performance and bandwith constraints, any message exchanged between
app and server (for either upload or downloading data) cannot exceed 500 KB.

User Stories
------------
1- A user should be able to download the configurations of the construction sites assigned to her
2- A user should be able to upload the data collected along the day

Acceptance Criteria for Story #1
-------------------
- admin users can download any sites information.
- non-admin users can only download sites they have been assigned to.
- messages size cannot exceed 500 KB.

Acceptance Tests
-------------------

### Feature: Sites download  
  
  AS admin user  
  I WANT to download the configuration of the construction sites assigned to me
  SO THAT I'm able to track the work produced in those sites

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
  
  
### Feature: Sites download (non-functional requirements)
  
  Scenario: response size validation  
    When "admin" user requests his sites  
    Then response size is not larger than "500"KB  

BENEFITS
========
1. Acceptance criteria are automated and guaranteed by tests suite
2. If response size exceeds threshold instant feedback is provided by tests
3. Errors are not left for a separate phase, product is deployed with all features tested
4. The best practices pointed in our proposal directed to different request / response objects, 
using primitive types, which is better for interoperability.