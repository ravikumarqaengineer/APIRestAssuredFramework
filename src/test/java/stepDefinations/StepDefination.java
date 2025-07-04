package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefination extends Utils {
	RequestSpecification res;
	Response response;
	static String place_id;
	TestDataBuild data = new TestDataBuild();
	
	
	@Given("Add Place payload with {string} {string} {string}")
	public void add_Place_payload_with(String name, String language, String address) throws IOException {
		
		res=given().spec(requestSpecification())
		.body(data.addPlacePayload(name,language,address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
		
		//constructor will be called with value of resource which you pass
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResources());
		
		if(method.equalsIgnoreCase("POST"))
		response = res.when().post(resourceAPI.getResources());
		else if(method.equalsIgnoreCase("GET"))
		response = res.when().get(resourceAPI.getResources());
	}

	@Then("the API call got success with status code {int}")
	public void the_API_call_got_success_with_status_code(int expectedCode) {
		int a= response.getStatusCode();
		int b= expectedCode;
		assertEquals(a,b);
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
	
		assertEquals(getJsonPath(response,keyValue).toString(),expectedValue);
	}
	
	@Then("Verify place_ID created maps to {string} using {string}")
	public void verify_place_ID_created_maps_to_using(String expectedName, String resource) throws IOException {
	    // Req spec
		 place_id = getJsonPath(response,"place_id"); 
		res=given().spec(requestSpecification()).queryParam("place_id",place_id);
		user_calls_with_http_request(resource,"GET");
		String actualName = getJsonPath(response,"name"); 
		assertEquals(actualName,expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void deleteplace_Payload() throws IOException {
	    res=given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	
	}


}
