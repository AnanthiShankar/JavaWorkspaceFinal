package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class JsonPlaceHolder {
  @Test
  public void HeaderBodyUserid() {
	  RestAssured.baseURI="https://jsonplaceholder.typicode.com";
	  RequestSpecification request=RestAssured.given();
	  Response response= request.post("/posts");
	  ResponseBody body=response.getBody();
	 
	  JSONObject requestparams=new JSONObject();
	  requestparams.put("userid","Shankar");
	  requestparams.put("title","Manager");
	  requestparams.put("body","Testing the user id and title");
	  request.header("Content-Type","application/json");
	  request.body(requestparams.toJSONString());
	  Response response1=request.post("/posts");
	  ResponseBody body1=response1.getBody();
	  System.out.println(body1.asString());
	  
  }
  
}
