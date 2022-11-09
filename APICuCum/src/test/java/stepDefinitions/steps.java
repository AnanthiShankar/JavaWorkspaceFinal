package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class steps {
	String baseUrl="https://reqres.in/api/";
	 
	@Given("List of Users are available")
	public void list_of_users_are_available() {
		RestAssured.baseURI=baseUrl;
		 RequestSpecification spec=RestAssured.given();
		  Response response=spec.get("/users?page=2");
		  
		  System.out.println(response.getBody().asString());
		  System.out.println(response.getStatusCode());
	}

	@When("I add a new user")
	public void i_add_a_new_user() {
		RestAssured.baseURI=baseUrl;
		  RequestSpecification request=RestAssured.given();
		  JSONObject requestparams=new JSONObject();
		  requestparams.put("name","Shankar");
		  requestparams.put("job","Manager");
		  request.header("Content-Type","application/json");
		  request.body(requestparams.toJSONString());
		  Response response=request.post("/users");
		  System.out.println(response.timeIn(TimeUnit.MILLISECONDS)+"milliseconds");
		  System.out.println("The response received is "+response.statusLine());
		  ResponseBody body=response.getBody();
		  System.out.println(body.asString());
	}

	@Then("New user is added")
	public void new_user_is_added() {
		
		RestAssured.baseURI=baseUrl;
		  RequestSpecification request=RestAssured.given();
		  Response spec=request.get("/users?page=2");
		  System.out.println(spec.getStatusCode());
	        System.out.println(spec.getBody().asString());
	}

}
