#Author: mohith.khare@sainsburys.co.uk
#Keywords Summary : Home page validations
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
Feature: QW Scenarios

  @tag1
  Scenario Outline: To test Welcome message
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Launch SelfService Portal
    Then Verify the Welcome message
    
     Examples: 
    | Browser |
    | firefox |
    | chrome  |
    
  @tag2
  Scenario Outline: To test Welcome message location change Link
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Launch SelfService Portal
    Then Verify the Welcome message popup text
    
     Examples: 
    | Browser |
    | firefox |
    | chrome  |
   
	@tag3
	Scenario Outline: To test Tab name of the Portal
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Launch SelfService Portal
    Then TabName verification
	
		Examples: 
    | Browser |
    | firefox |
    | chrome  |
    
  @tag4
	Scenario Outline: To test Category field for Change
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type 
    Then Verify Category field
    
    Examples: 
    | Browser |
    | firefox |
    | chrome  |

  @tag5
  Scenario Outline: To test Category field for Incidents
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Create new incident page
    Then Verify incident Category field
    
    Examples: 
    | Browser |
    | firefox |
    | chrome  |
    
  @tag6
  Scenario Outline: To test field Primary Assignment Group under application page
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Navigate to platform page
    Then Verify Primary Assignment Group field is renamed correctly 
    
    Examples: 
    | Browser |
    | chrome  |
    | firefox |
    
  @tag7
  Scenario Outline: To test field Service Delivery Lead under application page
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Navigate to platform page
    Then Verify Service Delivery Lead field
    
    Examples: 
    | Browser |
    | firefox |
    | chrome  |
    
	@tag8
  Scenario Outline: Verify ITIL role is inherited to ITIL_Argos role
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Navigate to platform page
    Then Verify inherited Roles
    
    Examples: 
    | Browser |
    | chrome  |
    | firefox |
    
  @tag9
  Scenario Outline: Verify ITIL role is inherited to ITIL_fujitsu role
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Navigate to platform page
    Then Verify inherited Roles
    
    Examples: 
    | Browser |
    | chrome  |
    | firefox |
    
  @tag10
  Scenario Outline: Verify ITIL role is inherited to ITIL_accenture role
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    When Navigate to platform page
    Then Verify inherited Roles
    
    Examples: 
    | Browser |
    | chrome  |
    | firefox |
    
  @tag11
	Scenario Outline: Test the Impacted Parties field for ITIL user 
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type