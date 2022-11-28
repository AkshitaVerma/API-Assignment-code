package ibm.sdet;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Test;
import org.testng.annotations.*;

public class ReadingDatafromJson {

	@Test(enabled = true)
	public void POST() {

		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.given().log().all().body(new File("./Data.json"))
				// Giving header details are important
				.header("Content-Type", "application/json").when().post("/Worker");
		Response resp2 = RestAssured.get("http://localhost:3000/Worker");
		System.out.println(resp2.asString());
	}
}
