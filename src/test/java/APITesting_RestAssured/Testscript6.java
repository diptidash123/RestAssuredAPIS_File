package APITesting_RestAssured;
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Testscript6 {
	
	//https://jsonformatter.org/json-to-jsonschema
	//convert JSON to JSONSCHEMA validation
	//@Test
	public void jsonschemavalidation()
	{
		given()
		
		.when()
		  .get("https://reqres.in/api/users?page=2")
		  
		.then()
		   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Jsonschemavalidation.json"));
	}
	
	//https://www.convertsimple.com/convert-xml-to-xsd-xml-schema/
	//convert XML to XSD schema validation
	@Test
	public void xmlschemavalidation()
	{
		given()
		.when()
		   .get("http://restapi.adequateshop.com/api/Traveler")
		.then()
		 .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("NewXMLSchema.xsd"));
		
	}

}
