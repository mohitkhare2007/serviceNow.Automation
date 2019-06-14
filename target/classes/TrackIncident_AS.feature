#Author: mohith.khare@sainsburys.co.uk
#Keywords Summary : Change Management
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: TrackIncident_AS

  @tag1
	Scenario Outline: To test Category field for change
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Launch SelfService Portal
    Then Verify Resolution Notes
   
    Examples: 
    | Browser |
    | firefox |
    | chrome  |
