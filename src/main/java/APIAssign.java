import io.restassured.RestAssured;
import io.restassured.response.Response;

//import static org.junit.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

//import junit.framework.Test;
import org.testng.annotations.*;

public class APIAssign {

	@Test(enabled = false)
	public void GET() {

		Response resp = RestAssured.get("http://localhost:3000/courses");
		System.out.println(resp.asString());
	}
	@Test(enabled = false)
	public void POST() {
		RestAssured.baseURI = "http://localhost:3000";
		String Body = "{\n"
				+ "        \"title\": \"Psychlogy\",\n"
				+ "        \"price\": 70,\n"
				+ "        \"copies\": 3\n"
				+ "    }";

//				// First fetch the response in the response container
		Response resp = RestAssured.given().log().all().body(Body)
//						// Giving header details are important
				.header("Content-Type", "application/json").post("courses");
		Response resp2 = RestAssured.get("http://localhost:3000/courses");
		System.out.println(resp2.asString());
//		
		// Extract the response code and response message and print it
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());
	}

	@Test(enabled = false)
	public void Delete() {
		// First fetch the response in the response container
		Response resp = RestAssured.given().header("Content-Type", "application/json").when()
				.delete("http://localhost:3000/courses/6");

		// Extract the response code and response message and print it
		System.out.println(resp.statusCode());
		System.out.println(resp.statusLine());
	}

	@Test(enabled = false)
	public void PUT() {
		// For PUT request , we always have to provide the ID fr which you wants to do
		// the changes
		String Body = "{\r\n" + "        \"title\": \"java\",\r\n" + "        \"price\": \"90\"\r\n"
				+ "         }";
		// First fetch the response in the response container
		Response resp = RestAssured.given().header("Content-Type", "application/json").body(Body).when()
				.put("http://localhost:3000/courses/3");

		// Extract the response code and response message and print it
		System.out.println("********************************************************************");
		System.out.println("The status Code is :" + resp.statusCode());
		System.out.println("The status response line s :" + resp.statusLine());
		System.out.println("********************************************************************");
		Response resp2 = RestAssured.get("http://localhost:3000/courses/4");
		System.out.println(resp2.asString());
	}
	
	@Test(enabled = false)
	public void Patch() {
		// For PUT request , we always have to provide the ID fr which you wants to do
		// the changes
		String Body = "{\n"
				+ "        \"title\": \"Cybersecurity\",\n"
				+ "        \n"
				+ "    }";
		// First fetch the response in the response container
		Response resp = RestAssured.given().header("Content-Type", "application/json").body(Body).when()
				.put("http://localhost:3000/school/courses/3");

		// Extract the response code and response message and print it
		System.out.println("********************************************************************");
		System.out.println("The status Code is :" + resp.statusCode());
		System.out.println("The status response line s :" + resp.statusLine());
		System.out.println("********************************************************************");
		Response resp2 = RestAssured.get("http://localhost:3000/courses/4");
		System.out.println(resp2.asString());
	}
	
	// Assertions 
    @Test(enabled = false)
    public void Assertions() {
        Response resp = RestAssured.given()
                .queryParam("copies", "4")
                .header("Content-Type", "application/json")
                .when()        
                .get("http://localhost:3000/courses");
                
        // Extract the response code and response message and print it
        System.out.println("********************************************************************");
        System.out.println("The status Code is :"+resp.statusCode());
        System.out.println("The status response line s :"+resp.statusLine());
        assertEquals(200, resp.statusCode());
        assertNotNull( resp.statusCode());
        System.out.println("********************************************************************");
        Response resp2 = RestAssured.get("http://localhost:3000/courses/3");
        System.out.println(resp2.asString());


}}


