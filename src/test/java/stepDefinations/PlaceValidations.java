package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.runner.RunWith;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestData;
import resources.Helper;

@RunWith(Cucumber.class)
public class PlaceValidations extends Helper {
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response response;
	TestData data = new TestData();

	@Given("Add place payload")
	public void add_place_payload() throws Exception {
		reqSpec = given().spec(requestSpecification()).body(data.getAddPlacePayload());
	}

	@When("User calls {string} with post http request")
	public void user_calls_with_post_http_request(String api) {
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		response = reqSpec.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();
	}

	@Then("Api should get success with status code {int}")
	public void api_should_success_with_status_code(Integer statusCode) {
		assertEquals((int) (statusCode), response.getStatusCode());
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is_OK(String key, String value) {
		String result = response.asString();
		JsonPath js = new JsonPath(result);
		assertEquals(value, js.get(key));
	}
}