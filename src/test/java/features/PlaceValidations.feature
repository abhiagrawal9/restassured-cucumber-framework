Feature: Validating Place API's

@AddPlace
Scenario Outline: Verify user is able to add place using Add Place API
Given Add place payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "POST" http request
Then Api should get success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And verify that "place_id" created maps to "<name>" using "GetPlaceAPI"

Examples:
|   name  |  language   |    address     |
| Sachin  |   Hindi     | Bombay         |
#|Aastha   | German     | paulo street	 |

 
 @DeletePlace
Scenario: Verify if delete place functionality is working
Given DeletePlace payload
When User calls "DeletePlaceAPI" with "POST" http request
Then Api should get success with status code 200
And "status" in response body is "OK"