package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestData {

	public AddPlace getAddPlacePayload() {
		AddPlace addPlace = new AddPlace();

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.232333);
		addPlace.setLocation(l);

		addPlace.setAccuracy(50);
		addPlace.setName("Abhishek Agrawal House");
		addPlace.setPhone_number("+9876543210");
		addPlace.setAddress("29, side layout, cohen 09");

		List<String> types = new ArrayList<String>();
		types.add("beautiful home");
		types.add("home");
		addPlace.setTypes(types);

		addPlace.setWebsite("https://www.google.com");
		addPlace.setLanguage("English");

		return addPlace;
	}
}
