package test;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Catfile {
  @Test
  public void getCatMethods() {
	  RestAssured.baseURI="https://alexwohlbruck.github.io/cat-facts/";
	  RequestSpecification httpRequest=RestAssured.given();
	  Response response= httpRequest.get("");
	  System.out.println("Status line is "+response.statusLine());
	  //int statuscode=response.getStatusCode();
	  //System.out.println(statuscode);
	  //A/ssert.assertEquals(statuscode,200);
	  //System.out.println(response.timeIn(TimeUnit.MILLISECONDS)+"milliseconds");
  }
}
