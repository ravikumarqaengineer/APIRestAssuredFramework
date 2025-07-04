Feature: Validate Place API's
@AddPlace  @Regression
Scenario Outline: Verify if place is being succesfully added using AddPlaceAPI
	Given Add Place payload with "<name>" "<language>" "<address>"
	When user calls "AddPlaceAPI" with "Post" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And Verify place_ID created maps to "<name>" using "getPlaceAPI" 
	

	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with "Post" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	
	
Examples:
	| name    | language | address  		  |
	| AAhouse | English  | World cross center |
	| BBhouse | Spanish  | Sea cross center   |
	| CChouse | French   | Mountain center    |


