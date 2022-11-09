package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BikeWise {
  @Test
  public void headersStatuscode() {
	  RestAssured.baseURI="https://bikewise.org:443/api/v2/incidents?page=1&proximity_square=100";
	  RequestSpecification request=RestAssured.given();
	  request.header("Content-Type","application/json");
	  Response response= request.get("");
	  int statuscode=response.getStatusCode();
	  System.out.println("The status code is"+statuscode);
	  System.out.println("The header is :"+response.getHeaders());
	  
  }
}
