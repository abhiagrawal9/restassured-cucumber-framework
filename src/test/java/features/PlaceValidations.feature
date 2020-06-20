Feature: Validating Place API's

Scenario Outline: Verify user is able to add place using Add Place API
Given Add place payload with "<name>" "<language>" "<address>"
When User calls "AddPlaceAPI" with "POST" http request
Then Api should get success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"

Examples:
|   name  |  language   |    address     |
|Abhishek | English     | silicon valley |
#|Aastha   | German     | paulo street	 |

 

