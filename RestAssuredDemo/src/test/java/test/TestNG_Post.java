package test;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class TestNG_Post {
  @Test
  public void postReqresUser() {
	  RestAssured.baseURI="https://reqres.in/api";
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
	  //System.out.println(body.asString());
	  jsonResponse ResponseBody= body.as(jsonResponse.class);
	  System.out.println("The response received is "+ResponseBody.createdAt);	
	  System.out.println("The response received is "+ResponseBody.id);
	  System.out.println("The response received is "+ResponseBody.job);
	  System.out.println("The response received is "+ResponseBody.name);
			  
  }
 
}
