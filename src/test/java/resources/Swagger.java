package resources;

public enum Swagger {

	AddPlaceAPI("/maps/api/place/add/json"), 
	GetPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	
	private String api;

	Swagger(String api) {
		this.api = api;
 	}
	
	public String getAPI() {
		return api;
	}

}
