package apphooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class ApplicationHooks {
	@Before
	public void setup() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 3000;
	}
}
