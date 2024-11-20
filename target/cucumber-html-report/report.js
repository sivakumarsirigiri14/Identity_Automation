$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("featureFiles/GetCarRegFromInputFileAndValidate.feature");
formatter.feature({
  "line": 2,
  "name": "Validate Car Registration numbers",
  "description": "",
  "id": "validate-car-registration-numbers",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@vehicleregistration"
    }
  ]
});
formatter.scenarioOutline({
  "line": 4,
  "name": ": verify to input extracted car Registration numbers from Input file and search in car valuation page and compare output registration, make or model against car out file data",
  "description": "",
  "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-against-car-out-file-data",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "I am on car valuation home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I extract vehicle registration numbers from \u003cInputfile\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "It should display car registration and make/model on entering car reg no and start valuation",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I compare output returned from application with given \u003cOutputFile\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-against-car-out-file-data;",
  "rows": [
    {
      "cells": [
        "Inputfile",
        "OutputFile"
      ],
      "line": 12,
      "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-against-car-out-file-data;;1"
    },
    {
      "cells": [
        "\"car_input.txt\"",
        "\"car_output.txt\""
      ],
      "line": 13,
      "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-against-car-out-file-data;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4788847102,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": ": verify to input extracted car Registration numbers from Input file and search in car valuation page and compare output registration, make or model against car out file data",
  "description": "",
  "id": "validate-car-registration-numbers;:-verify-to-input-extracted-car-registration-numbers-from-input-file-and-search-in-car-valuation-page-and-compare-output-registration,-make-or-model-against-car-out-file-data;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@vehicleregistration"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on car valuation home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I extract vehicle registration numbers from \"car_input.txt\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "It should display car registration and make/model on entering car reg no and start valuation",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I compare output returned from application with given \"car_output.txt\"",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ValueMyCarAndAboutMyCarSteps.i_am_on_car_valuation_home_page()"
});
formatter.result({
  "duration": 3146582931,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "car_input.txt",
      "offset": 45
    }
  ],
  "location": "ValueMyCarAndAboutMyCarSteps.i_extract_vehicle_registration_numbers_from(String)"
});
formatter.result({
  "duration": 37474079,
  "status": "passed"
});
formatter.match({
  "location": "ValueMyCarAndAboutMyCarSteps.itShouldDisplayCarRegistrationAndMakeModelOnEnteringCarRegNoAndStartValuation()"
});
formatter.result({
  "duration": 71347669357,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "car_output.txt",
      "offset": 55
    }
  ],
  "location": "ValueMyCarAndAboutMyCarSteps.i_compare_output_returned_from_application_with_given(String)"
});
formatter.result({
  "duration": 283093641,
  "status": "passed"
});
formatter.after({
  "duration": 504447191,
  "status": "passed"
});
});