package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GoRestPut {
	String token="ce52c2e3476734b9d3cad24548a126c16371f378ebaea5dea113571c07e19a99";
  @Test
  public void goRestPut() {
	  RestAssured.baseURI="https://gorest.co.in/";
	  RequestSpecification spec=RestAssured.given().header("Authorization","Bearer "+token).header("Content-Type","application/json");
	  JSONObject requestparams=new JSONObject();
	  requestparams.put("name","Shankar1");
	  requestparams.put("id",4473);
	  requestparams.put("email","Manager.manager@xyz.com");
	  requestparams.put("gender","male");
	  requestparams.put("status","active");
	  //spec.header("Content-Type","application/json");
	  //spec.header("Authorization","bearer "+token);
	 // Response response=spec.put("/public/v2/users/4483");
	  spec.body(requestparams.toJSONString());
	  ResponseBody body=spec.put("/public/v2/users/4443");
	  System.out.println(body.asString());
	  //System.out.println(body1.asString());
	  spec.body(requestparams.toJSONString());
	  
	  
	  
	  
  }
}
