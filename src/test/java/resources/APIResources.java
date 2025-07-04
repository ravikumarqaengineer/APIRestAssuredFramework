package resources;

// enum is a special class in java which has collection of constants or methods
public enum APIResources {

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
	private String resources;
	
	//constructor with same argument how you want to define.
	APIResources(String resources)                         
	{
		this.resources=resources;
	}
	
	public String getResources() 
	{
		return resources;
	}
	
}
