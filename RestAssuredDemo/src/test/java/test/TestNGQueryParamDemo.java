package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestNGQueryParamDemo {
  @Test
  public void GetReqresUserList() {
	  RestAssured.baseURI="https://reqres.in/api";
	  RequestSpecification httpRequest=RestAssured.given();
	  Response response=httpRequest.queryParam("page","2").get("/user");
	  int statuscode=response.getStatusCode();
	  System.out.println(statuscode);
	  Assert.assertEquals(statuscode,200);
	  System.out.println(response.timeIn(TimeUnit.MILLISECONDS)+"milliseconds");
  }
}
