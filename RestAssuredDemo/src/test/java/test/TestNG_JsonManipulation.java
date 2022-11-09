package test;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestNG_JsonManipulation {
  @Test
  public void JsonManipulation() {
	  RestAssured.baseURI="https://gorest.co.in/public/v2/users/";
	  RequestSpecification spec=RestAssured.given();
	  Response response=spec.get("");
	  JsonPath eval=response.jsonPath();
	  List<String> AllUsers=eval.getList("name");
	  for(String user:AllUsers) {
		  System.out.println(user);
		  
	  }
  }
}
