package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class OpenLibrary {
  @Test
  public void responseBody() {
	  RestAssured.baseURI="http://openlibrary.org/";
	  RequestSpecification httpRequest=RestAssured.given();
	  Response response= httpRequest.post("/search");
	 // System.out.println("response Body is "+response.body());
	  ResponseBody body=response.getBody();
	  System.out.println(body.asString());
  }
}
