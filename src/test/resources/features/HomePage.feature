@krishna
Feature: Home Page Module Features
  Description: The purpose of this feature is to test Switch between tabs And Opportunities Near


  Background: SID Home Page Opened
    Given I launch the new Browser
    And I open SID Home Page

  @ReuseBrowser
  @Sanity@Regression@HomePageReg
  Scenario: Verify switch between skillcourses jobexchange and skill centres tab
    Given i navigate to Landing page
    Then I verify switch between skillcourses skillcentres and jobexchange

  @ReuseBrowser
  @Sanity@Regression@HomePageReg
  Scenario: Verify Learning Resources tab and Important links tab
#		Given i navigate to Landing page
#		Then I verify learning resources tab functionality
    Then I verify important links tab functionality
#		Then I verify all important links access functionality
  @ReuseBrowser
  @Sanity@Regression@HomePageReg
  Scenario: Verify About Us in Important links tab
#		Given i navigate to Landing page
    Then I verify all important links access functionality About US

  @Sanity@Regression@HomePageReg
  Scenario: Verify Sectors in Important links tab
#		Given i navigate to Landing page
    Then I verify all important links access functionality Sectors

