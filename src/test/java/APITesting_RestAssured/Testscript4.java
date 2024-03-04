package APITesting_RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Testscript4 {

	//parsing response body JSON data's
	//Approach1
	//@Test(priority = 1)
	public void approach1()
	{
		given()
		  .contentType(ContentType.JSON)
		.when()
		   .get("https://fakestoreapi.com/products")
		.then()
		    .statusCode(200)
		    //headers //cookies //response body //status code
		    .header("Content-Type","application/json; charset=utf-8")
		    .log().all();
		    //.log().headers();
		   // .log().cookies();
	}


@Test(priority = 2)
public void approach2()
{
	 Response res=given()
	  .contentType(ContentType.JSON)
	.when()
	  .get("https://fakestoreapi.com/products");
	//.then();
	 Assert.assertEquals(res.getStatusCode() ,200);
	 Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
    //	 Assert.assertEquals(res.jsonPath().get("x[0][0].title").toString();
	// Assert.assertEquals(res.getCookies(), "null");
	 Assert.assertEquals(res.getTime(), 0);
}
}