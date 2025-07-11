package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	public AddPlace addPlacePayload(String name, String language, String address) 
	{
		AddPlace p= new AddPlace();
		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 983 893 3937");
		p.setWebsite("http://google.com");
		p.setName(name);

		List <String> myList = new ArrayList <String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
	

		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l);
		
		return p;
	}
	
	public String deletePlacePayload(String placeID) 
	{
		return "{\r\n    \"place_id\":\""+placeID+"\"\r\n}";
	}
}
