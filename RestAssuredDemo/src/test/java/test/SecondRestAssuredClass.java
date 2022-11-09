package test;

import static io.restassured.RestAssured.given;

public class SecondRestAssuredClass {
	//static String url="https://reqres.in/api/users/2";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getResponseBody();
		getResponseStatus();

	}
	public static void getResponseBody() {
		//given().when().get(url).then().log().all();
		given().when().get("https://reqres.in/api/users/52").then().log().body();
		//given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD","1234!").queryParam("Account_No", "1").when().get("https://demo.guru99.com/V4/sinkministatement.php").then().log().body();
		
		
	}
	public static void getResponseStatus() {
		int statusCode=given().when().get("https://reqres.in/api/users/52").getStatusCode();
		System.out.println(statusCode);
	}
}
