Feature: Validating Place API's

Scenario: Verify user is able to add place using Add Place API
Given Add place payload
When User calls "AddPlaceAPI" with post http request
Then Api should get success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"


