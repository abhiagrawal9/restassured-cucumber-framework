package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
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
import resources.Swagger;

@RunWith(Cucumber.class)
public class PlaceValidations extends Helper {
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	Response response;
	TestData data = new TestData();

	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String lang, String address) throws Exception {
		reqSpec = given().spec(requestSpecification()).body(data.getAddPlacePayload(name, lang, address));
	}

	@When("User calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String api, String method) {

		Swagger sw = Swagger.valueOf(api);
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();

		if (method.equalsIgnoreCase("post"))
			response = reqSpec.when().post(sw.getAPI());
		else if(method.equalsIgnoreCase("get"))
			response = reqSpec.when().get(sw.getAPI());
		else if(method.equalsIgnoreCase("delete"))
			response = reqSpec.when().delete(sw.getAPI());
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