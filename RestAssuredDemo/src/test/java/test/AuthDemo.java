package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class AuthDemo {
  @Test
  public void Authentication() {
	  RestAssured.baseURI="https://postman-echo.com/basic-auth";
	 // RequestSpecification request=RestAssured.given().auth().basic("postman","password");
	  //RequestSpecification request=RestAssured.given().auth().preemptive().basic("postman", "password");
	  RequestSpecification request=RestAssured.given().auth().oauth2("577a840690fcc58a2fc2a1d3bbba5a0f5bee3c5b");
	  Response response=request.get();
	  ResponseBody body=response.getBody();
	  System.out.println(body.asString());
	  //Response response= httpRequest.get("");
	  int statuscode=response.getStatusCode();
	  System.out.println(statuscode);
	  
	  
  }
}
