package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FifthResAs {
  @Test
  public void getReqresSingleUser() {
	  RestAssured.baseURI="https://reqres.in/api/users/2";
	  RequestSpecification httpRequest=RestAssured.given();
	  Response response= httpRequest.get("");
	  int statuscode=response.getStatusCode();
	  System.out.println(statuscode);
	  Assert.assertEquals(statuscode,200);
	  System.out.println(response.timeIn(TimeUnit.MILLISECONDS)+"milliseconds");
  }
}
