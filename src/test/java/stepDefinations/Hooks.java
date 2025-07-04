package stepDefinations;
import java.io.IOException;
import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException
	{
		//write a code that will give you a place id
		//execute this code only when place id is null
		
		StepDefination m= new StepDefination();
		//static variable classname.varableName
		if(StepDefination.place_id==null)
		{
			m.add_Place_payload_with("RAVIKUMAR", "ENGLISH", "BANGALORE");
			m.user_calls_with_http_request("AddPlaceAPI", "Post");
			m.verify_place_ID_created_maps_to_using("RAVIKUMAR", "getPlaceAPI");
		}
		
	}
	
	
}
