$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Westmarine.feature");
formatter.feature({
  "line": 1,
  "name": "Search feature",
  "description": "",
  "id": "search-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Verify it\u0027s able to select any item from the search results",
  "description": "",
  "id": "search-feature;verify-it\u0027s-able-to-select-any-item-from-the-search-results",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@sitenavigation"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I am on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I enter an item \"Flip flops\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "I click on the search icon",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should able to see the search results",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I am able to select one",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "selected item is the same displayed",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});