$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/Cucumber/Features/Task_2.feature");
formatter.feature({
  "line": 1,
  "name": "New Order",
  "description": "",
  "id": "new-order",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 2,
  "name": "Create and delete New Address",
  "description": "",
  "id": "new-order;create-and-delete-new-address",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "An open browser with https://prod-kurs.coderslab.pl",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Logged in user",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Search a product",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Check Discount",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Choose Size \u003cSize\u003e and count \u003cCount\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Add to Cart",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Go to checkout",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Set Delivery Conditions",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Take a screenshot",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Order has status Awaiting check Payment and values are valid",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "tearDown",
  "keyword": "And "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "new-order;create-and-delete-new-address;",
  "rows": [
    {
      "cells": [
        "Size",
        "Count"
      ],
      "line": 21,
      "id": "new-order;create-and-delete-new-address;;1"
    },
    {
      "cells": [
        "L",
        "5"
      ],
      "line": 22,
      "id": "new-order;create-and-delete-new-address;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 22,
  "name": "Create and delete New Address",
  "description": "",
  "id": "new-order;create-and-delete-new-address;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "An open browser with https://prod-kurs.coderslab.pl",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Logged in user",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Search a product",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Check Discount",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Choose Size L and count 5",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "Add to Cart",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "Go to checkout",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "Set Delivery Conditions",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "Take a screenshot",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Order has status Awaiting check Payment and values are valid",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "tearDown",
  "keyword": "And "
});
formatter.match({
  "location": "Task_2.SetUp()"
});
formatter.result({
  "duration": 3767092182,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.Log_in()"
});
formatter.result({
  "duration": 1250991255,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.Searching()"
});
formatter.result({
  "duration": 1375060663,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.CheckingDiscount()"
});
formatter.result({
  "duration": 44108016,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "L",
      "offset": 12
    },
    {
      "val": "5",
      "offset": 24
    }
  ],
  "location": "Task_2.SetValues(String,String)"
});
formatter.result({
  "duration": 821397400,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.AddToCart()"
});
formatter.result({
  "duration": 1518220628,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.Checkout()"
});
formatter.result({
  "duration": 599714726,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.SetDelivery()"
});
formatter.result({
  "duration": 4211156212,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.TakeAScreenShot()"
});
formatter.result({
  "duration": 690398966,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.CheckValues()"
});
formatter.result({
  "duration": 2198124416,
  "status": "passed"
});
formatter.match({
  "location": "Task_2.tearDown()"
});
formatter.result({
  "duration": 73466230,
  "status": "passed"
});
});