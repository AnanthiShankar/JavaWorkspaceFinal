package test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredwithAssert {
	static String url="https://reqres.in/api/unknown";
	int statuscode;
  @Test
  public void GetReqresUsers() {
	//given().when().get(url).then().log().all();
		given().when().get("https://reqres.in/api/unknown").then().log().body();
	  int statusCode=given().when().get("https://reqres.in/api/unknown").getStatusCode();
		System.out.println(statusCode);
	  //getResponseTitle();
	  Assert.assertEquals(statusCode,200);
  }
  
	
}
