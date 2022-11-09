package test;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

public class ThirdResAs {


		static String url="https://reqres.in/api/unknown";
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			getResponseBody();
			getResponseStatus();
			getResponseHeaders();
			getResponseTime();

		}
		public static void getResponseBody() {
			//given().when().get(url).then().log().all();
			given().when().get("https://reqres.in/api/unknown").then().log().body();
			//given().queryParam("CUSTOMER_ID", "68195").queryParam("PASSWORD","1234!").queryParam("Account_No", "1").when().get("https://demo.guru99.com/V4/sinkministatement.php").then().log().body();
			
			
		}
		public static void getResponseStatus() {
			int statusCode=given().when().get("https://reqres.in/api/unknown").getStatusCode();
			System.out.println(statusCode);
		}
		public static void getResponseHeaders() {
			//int statusCode=given().when().get("https://reqres.in/#support-heading").getStatusCode();
			//System.out.println("The headers from the response are :"+given().when().get(url).then().extract().headers());
			System.out.println("The headers from the response are :"+given().when().get(url).then().extract().contentType());
		}
		public static void getResponseTime() {
			System.out.println("The time taken to fetch response is :"+given().when().get(url).timeIn(TimeUnit.MILLISECONDS)+"milliseconds");
			
			
			
			
		}

	}


