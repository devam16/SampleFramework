package stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import DTO.AddPetDto;
import DTO.Category;
import DTO.Tags;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiStepDef {
	
	public static RequestSpecification req;
	public final String endPointResource="/v2/pet";
	public static Response res;
	
	@SuppressWarnings("unchecked")
	public static AddPetDto createPojo() {
		Category cat =new Category();
		cat.setId(12);
		cat.setName("lol");
		Tags tagg=new Tags();
		tagg.setId(13);
		tagg.setName("sss");
		List<Tags> listtag=new ArrayList();
		listtag.add(tagg);
		List<String> listPhoto=new ArrayList();
		listPhoto.add("lol1");
		listPhoto.add("lol2");
		AddPetDto dto=new AddPetDto();
		dto.setId(11);
		dto.setName("Devam");
		dto.setStatus("available");
		dto.setCategory(cat);
		dto.setPhotoUrls(listPhoto);
		dto.setTag(listtag);
		
		return dto;
	}
	
	@Given("User creates the payload with {string} body")
	public void user_creates_the_payload_with_body(String body) {
	    req = RestAssured.given().header("Accept","application/json").
	    		header("Content-Type", "application/json")
	    		.body(apiStepDef.createPojo()).log().all();
	}
	@When("User send a {string} request to server")
	public void user_send_a_request_to_server(String httpMethod) {
		if(httpMethod.equals("GET")) {
			res=req.when().get(endPointResource);
		}
		else if(httpMethod.equals("POST")) {
			res=req.when().post(endPointResource);
		}
		else if(httpMethod.equals("PUT")) {
			res=req.when().put(endPointResource);
		}
		else if(httpMethod.equals("DELETE")) {
			res=req.when().delete(endPointResource);
		}
	}
	
	@When("User verifies the value in the field {string} in the response to be {string}")
	public void user_verifies_the_value_in_the_field_in_the_response_to_be(String field, String expValue) {
		JsonPath jsp=new JsonPath(res.asString());
		Assert.assertEquals(jsp.getString(field), expValue);
	}



}
