$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ChangeManagement.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: mohith.khare@sainsburys.co.uk"
    },
    {
      "line": 2,
      "value": "#Keywords Summary : Change Management"
    },
    {
      "line": 3,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 4,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 5,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 6,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 7,
      "value": "#| (Data Tables)"
    },
    {
      "line": 8,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 9,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 10,
      "value": "#\"\""
    },
    {
      "line": 11,
      "value": "## (Comments)"
    },
    {
      "line": 12,
      "value": "#Change Management Scenarios"
    }
  ],
  "line": 14,
  "name": "Change Management",
  "description": "",
  "id": "change-management",
  "keyword": "Feature",
  "tags": [
    {
      "line": 13,
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "line": 17,
  "name": "Testing Successful Normal Change process",
  "description": "",
  "id": "change-management;testing-successful-normal-change-process",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 16,
      "name": "@tag15"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "Open \"\u003cBrowser\u003e\" and launch URL",
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Authenticate the user",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Impersonate as a different user",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Navigate to Change Management",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "Select Change type",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Create a Change",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Fill Risk assessment form",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "Submit Change for approval",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Approve the change request",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Implement and review the change request",
  "keyword": "And "
});
formatter.examples({
  "line": 29,
  "name": "",
  "description": "",
  "id": "change-management;testing-successful-normal-change-process;",
  "rows": [
    {
      "cells": [
        "Browser"
      ],
      "line": 30,
      "id": "change-management;testing-successful-normal-change-process;;1"
    },
    {
      "cells": [
        "chrome"
      ],
      "line": 31,
      "id": "change-management;testing-successful-normal-change-process;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 1320405107,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Testing Successful Normal Change process",
  "description": "",
  "id": "change-management;testing-successful-normal-change-process;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 13,
      "name": "@tag"
    },
    {
      "line": 16,
      "name": "@tag15"
    }
  ]
});
formatter.step({
  "line": 18,
  "name": "Open \"chrome\" and launch URL",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 19,
  "name": "Authenticate the user",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "Impersonate as a different user",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "Navigate to Change Management",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "Select Change type",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "Create a Change",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "Fill Risk assessment form",
  "keyword": "And "
});
formatter.step({
  "line": 25,
  "name": "Submit Change for approval",
  "keyword": "And "
});
formatter.step({
  "line": 26,
  "name": "Approve the change request",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Implement and review the change request",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "chrome",
      "offset": 6
    }
  ],
  "location": "StepMethod.open_and_launch_URL(String)"
});
formatter.write("Pass: \u0027chrome\u0027 browser launched successfull");
formatter.result({
  "duration": 10752583974,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.authenticate_the_user()"
});
formatter.write("Pass: Login successfull");
formatter.result({
  "duration": 5237527218,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.impersonate_as_a_different_user()"
});
formatter.write("Pass: Impersonate successfull");
formatter.result({
  "duration": 15442471367,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.navigate_to_Change_Management()"
});
formatter.write("Pass: Successfully Navigated to Change Management");
formatter.result({
  "duration": 3947383680,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.select_Change_type()"
});
formatter.write("Pass: Successfully Navigated to Normal Change");
formatter.result({
  "duration": 2854283308,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.create_a_Change()"
});
formatter.write("Pass: Successfully Create the Change:CHG0060431 for Approval");
formatter.result({
  "duration": 45687717231,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.fill_Risk_assessment_form()"
});
formatter.write("Pass: Successfully Submitted Risk Assessment");
formatter.result({
  "duration": 11521465864,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.submit_Change_for_approval()"
});
formatter.write("Pass: Successfully Submitted the for Approval");
formatter.result({
  "duration": 3736215676,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.approve_the_change_request()"
});
formatter.write("Pass: \u0027Change Request\u0027 approved successfully and ready for Implementation");
formatter.result({
  "duration": 88928812763,
  "status": "passed"
});
formatter.match({
  "location": "StepMethod.implement_and_review_the_change_request()"
});
formatter.write("Fail: Failed to move \u0027Change Request\u0027 to Review Status");
formatter.result({
  "duration": 26711124425,
  "status": "passed"
});
formatter.after({
  "duration": 696470086,
  "status": "passed"
});
});