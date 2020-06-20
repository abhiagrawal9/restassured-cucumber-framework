package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenatio() throws Exception {
		PlaceValidations pv = new PlaceValidations();
		if (PlaceValidations.placeId==null) {
			pv.add_place_payload_with("Abhishek", "English", "Hyderabad");
			pv.user_calls_with_post_http_request("AddPlaceAPI", "POST");
			pv.verify_that_created_maps_to_using("place_id", "Abhishek", "GetPlaceAPI");			
		}
	}
}
