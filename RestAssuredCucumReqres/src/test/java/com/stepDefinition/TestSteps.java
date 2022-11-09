package com.stepDefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import test.jsonResponse;
import test.userdetails;



public class TestSteps {
	String baseUrl="https://reqres.in"; // this is the base url
	@Given("List of Users are available")
	public void list_of_users_are_available() { //In this method getting the list f users printed from the page "api/users?page=2"
		RestAssured.baseURI=baseUrl;
		 RequestSpecification spec=RestAssured.given();
		  Response response=spec.get("api/users?page=2");
		  
		  System.out.println(response.getBody().asString());
		  System.out.println("Printing the status code for the successful response"+response.getStatusCode());
	}

	@When("I get a unsuccessful reponse")
	public void i_get_a_unsuccessful_reponse() { //In this method getting the unsuccessful message printed in console for the login functionality
		RestAssured.baseURI=baseUrl;
		  RequestSpecification request=RestAssured.given();
		  JSONObject requestparams=new JSONObject();
		  requestparams.put("email","ananthi.shan@gmail.com");
		  request.header("Content-Type","application/json");
		  request.body(requestparams.toJSONString());
		  Response response=request.post("/api/login");
		  System.out.println("The response received is "+response.statusLine());
		  ResponseBody body=response.getBody();
		  System.out.println(body.asString());
		  System.out.println("Printing the status code for unsuccesful response"+response.getStatusCode());
	}

	@When("I get a successful reponse")
	public void i_get_a_successful_reponse() { //in this method posting the details using post 

		  RequestSpecification request1=RestAssured.given();
		  JSONObject requestparams1=new JSONObject();
		  requestparams1.put("id",33);
		  requestparams1.put("email","ana.shan@gmail.com");
		  requestparams1.put("first_name","Ana");
		  requestparams1.put("last_name","Shan");
		  request1.header("Content-Type","application/json");
		  request1.body(requestparams1.toJSONString());
		  Response response1=request1.post("api/users?page=2");
		  System.out.println(response1.timeIn(TimeUnit.MILLISECONDS)+"milliseconds");
		  System.out.println("The response received is "+response1.statusLine());
		  ResponseBody body1=response1.getBody();
		  System.out.println(body1.asString());
		  System.out.println("Printing the status code for Post Method"+response1.getStatusCode());
			  
		 
	}

	@Then("Adding new user")
	public void adding_new_user() { //in this method using put statement adding the name and jon and using put creating it and printing in console 
		RestAssured.baseURI=baseUrl;
		  RequestSpecification request=RestAssured.given();
		  JSONObject requestparams=new JSONObject();
		  requestparams.put("name","Ananthi");
		  requestparams.put("job","Manager");
		  request.header("Content-Type","application/json");
		  request.body(requestparams.toJSONString());
		  Response response=request.put("/api/users/2");
		  System.out.println(response.timeIn(TimeUnit.MILLISECONDS)+"milliseconds");
		  System.out.println("The response received is "+response.statusLine());
		  ResponseBody body=response.getBody();
		  System.out.println(body.asString());
		  jsonResponse ResponseBody= body.as(jsonResponse.class);
		  System.out.println("The response received is "+ResponseBody.updatedAt);	
		  System.out.println("The response received is "+ResponseBody.id);
		  System.out.println("The response received is "+ResponseBody.job);
		  System.out.println("The response received is "+ResponseBody.name);
		  System.out.println("Printing the status code for Put Method"+response.getStatusCode());
	}

	@Then("getting delayed reponse")
	public void getting_delayed_reponse()  { //in this method getting the reponse of delay and displaying it in console
		 RestAssured.baseURI=baseUrl;
		  RequestSpecification spec=RestAssured.given();
		 // Response response=spec.get("");
		  Response response=spec.get("api/users?delay=3");
		  
		  ResponseBody body=response.getBody();
		  System.out.println("Printing the status code for delayed response"+response.getStatusCode());
		  System.out.println(body.asString());
		  
		  
		  //To delete the created id
		  Response response3=spec.get("api/users/33");
		  
		  ResponseBody body4=response3.getBody();
		  System.out.println(body4.asString());
		  Response res= spec.delete("api/users/33");
		  System.out.println("Printing the status code for delete"+res.statusCode());

	}
}
