package test;
import static io.restassured.RestAssured.*;


public class MyFirstRestAssuredClass {
	static String uRL="https://reqres.in/api/users?page=2";
			
	public static void main(String[] args) {
		getResponseBody();
		getResponseStatus();
	}
	public static void getResponseBody() {
		given().when().get(uRL).then().log().all();
		//given().queryParam("page","2").when().get("https://reqres.in/api/users.php").then().log().body();
		given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD","1234!").queryParam("Account_No", "1").when().get("https://demo.guru99.com/V4/sinkministatement.php").then().log().body();
		
		
	}
	public static void getResponseStatus() {
		int statusCode=given().queryParam("page","2").when().get("https://reqres.in/api/users.php").getStatusCode();
		System.out.println(statusCode);
	}
}
