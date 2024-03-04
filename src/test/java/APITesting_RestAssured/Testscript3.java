package APITesting_RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class Testscript3 {

	//cookies and headers capture data single and multiple 
	@Test
	public void cookies()
	{
	    given()
		.when()
		    .get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
		.then()
		    .statusCode(200)
		    .log().cookies()
	        .log().headers();
         //.log().all();
		//Response body-
		/*[RemoteTestNG] detected TestNG version 7.8.0
		SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
		SLF4J: Defaulting to no-operation (NOP) logger implementation
		SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further detail
		s.
		orangehrm=14d9c7043875da984345e46841d9d0ca;Path=/web;Secure;HttpOnly;SameSite=La
		x
		PASSED: APITesting_RestAssured.Testscript3.cookies
		===============================================
		    Default test
		    Tests run: 1, Failures: 0, Skips: 0
		===============================================
		===============================================
		Default suite
		Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
		===============================================*/  
	}
}