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
#Change Management Scenarios
@tag
Feature: Change Management

  @tag15
	Scenario Outline: Testing Successful Normal Change process 
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Fill Risk assessment form
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    
    Examples: 
    | Browser |
    | chrome  |
#    | firefox |

	@tag2
	Scenario Outline: Testing Experienced Issue Normal Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Fill Risk assessment form
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    Then Close the change request
    
    Examples: 
    | Browser |
    | chrome  |
#    | firefox |

	@tag3
	Scenario Outline: Testing Successful Standard Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    
    Examples: 
    | Browser |
    | chrome  |
#    | firefox |

	@tag4
	Scenario Outline: Testing Experienced Issue Standard Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    Then Close the change request
    
    Examples: 
    | Browser |
    | chrome  |
#    | firefox |

	@tag5
	Scenario Outline: Testing Successful Emergency Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Fill Risk assessment form
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    
    Examples: 
    | Browser |
    | chrome  |
#    | firefox |

	@tag6
	Scenario Outline: Testing Experienced Issue Emergency Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Fill Risk assessment form
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    Then Close the change request
    
    Examples: 
    | Browser |
    | chrome  |
#    | firefox |

#	@tag7
#	Scenario Outline: Testing Successful Expedited Change process
#    Given Open "<Browser>" and launch URL
#    And Authenticate the user
#    Then Impersonate as a different user
#    When Navigate to Change Management
#    And Select Change type
#    Then Create a Change
#    And Fill Risk assessment form
#    And Submit Change for approval
#    Then Approve the change request
#    And Implement and review the change request
    
#    Examples: 
#   | Browser |
#    | chrome  |
#    | firefox |  

#	@tag8
#	Scenario Outline: Testing Experienced Issue Expedited Change process
#    Given Open "<Browser>" and launch URL
#    And Authenticate the user
#    Then Impersonate as a different user
#    When Navigate to Change Management
#    And Select Change type
#    Then Create a Change
#    And Fill Risk assessment form
#    And Submit Change for approval
#    Then Approve the change request
#    And Implement and review the change request
#    Then Close the change request
    
#    Examples: 
#    | Browser |
#    | chrome  |
#    | firefox |  

	@tag9
	Scenario Outline: Testing Latent Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Fill Risk assessment form
    And Submit Change for approval
    And Implement and review the change request
    Then Close the change request
    
    Examples: 
    | Browser |
    | chrome  |
#   | firefox |

  @tag10
	Scenario Outline: Testing Successful NoImpact Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    
    Examples: 
    | Browser |
    | chrome  |
#   | firefox |  

  @tag11
	Scenario Outline: Testing Experienced Issue NoImpact Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    Then Close the change request
    
    Examples: 
    | Browser |
    | chrome  |
#    | firefox |      

	@tag12
	Scenario Outline: Testing Bank Normal Change process
    Given Open "<Browser>" and launch URL
    And Authenticate the user
    Then Impersonate as a different user
    When Navigate to Change Management
    And Select Change type
    Then Create a Change
    And Fill Risk assessment form
    And Submit Change for approval
    Then Approve the change request
    And Implement and review the change request
    Then Close the change request
    
    Examples: 
    | Browser |
    | chrome  |
#    | firefox |
