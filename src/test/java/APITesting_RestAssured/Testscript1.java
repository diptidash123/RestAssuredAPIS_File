package APITesting_RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import org.testng.annotations.Test;

public class Testscript1 
{
	int id;
   //get request API testing
   //https://reqres.in/api/users/2 RC-200
	
	//@Test(priority = 1)
	public void GetRequestAPI()
	{
		given()
		
		.when()
		  .get("https://reqres.in/api/users/2")
		  
		.then()
		  .statusCode(200)
		  //System.out.println("The status code is validated successfully");
		  //..log().cookies()
		  //.log().headers();
		  .log().all();
	}
	
	//post request API testing
	//https://reqres.in/api/users RC-201
	/*{
	    "name": "morpheus",
	    "job": "leader"
	}*/ 
	
	//@Test(priority = 2)
	public void PostRequestAPI()
	{
		HashMap data=new HashMap();
		data.put("name","diptiranjandash");
		data.put("job","softwareengineer");
		
		given()
		     .contentType("application/json")
		     .body(data)
		.when()
		    .post("https://reqres.in/api/users")
		.then()
		    .statusCode(201)
		    .body("name",equalTo("diptiranjandash"))
		    .body("job", equalTo("softwareengineer"))
		    .log().all();	  
	}
	
	@Test(priority = 3)
	public void PostRequestAPI_IDcapture()
	{
		HashMap data=new HashMap();
		data.put("name","diptiranjandash");
		data.put("job","softwareengineer");
		
		 id=given()
		     .contentType("application/json")
		     .body(data)
		.when()
		    .post("https://reqres.in/api/users")
		    .jsonPath().getInt("id");
		   //.then()
		   // .statusCode(201)
		    //.body("name",equalTo("diptiranjandash"))
		    //.body("job", equalTo("softwareengineer"))
		    //.log().all();	  
	}
	
       //Response body
	   /*{
	    "name": "diptiranjandash",
	    "job": "softwareengineer",
	    "id": "346",
	    "createdAt": "2024-02-21T05:48:05.469Z"
	   }
	   PASSED: APITesting_RestAssured.Testscript1.PostRequestAPI*/

	
	//put request API testing
	//https://reqres.in/api/users/2 RC-200
	/*{
	    "name": "morpheus",
	    "job": "zion resident"
	}*/
	
	@Test(priority = 4, dependsOnMethods = {"PostRequestAPI_IDcapture"})
	public void PutRequestAPI()
	{
		HashMap data=new HashMap();
		data.put("name","dipti ranjan");
		data.put("job","test engineer");
		given()
		  .contentType("application/json")
		  .body(data)
		.when()
		  .put("https://reqres.in/api/users/"+id)
		.then()
		  .statusCode(200)
		  .body("name", equalTo("dipti ranjan"))
		  .body("job",equalTo("test engineer"))
		  .log().all();
		  
	}
	//delete request API testing
	//https://reqres.in/api/users/2 RC-204
	
	@Test(priority = 5,dependsOnMethods = {"PutRequestAPI"})
	public void DeleteRequestAPI()
	{
		given()
		.when()
		  .delete("https://reqres.in/api/users/"+id)
		.then()
		 .statusCode(204)
		 .log().all();
	}
}


//Output response
//------------------
/*HTTP/1.1 200 OK
Date: Wed, 21 Feb 2024 06:13:25 GMT
Content-Type: application/json; charset=utf-8
Transfer-Encoding: chunked
Connection: keep-alive
Report-To: {"group":"heroku-nel","max_age":3600,"endpoints":[{"url":"https://nel
.heroku.com/reports?ts=1708496005&sid=c4c9725f-1ab0-44d8-820f-430df2718e11&s=Zyg
xcfXj7VrSNhmbeUM4a4gR8nnUx%2FF1aWem8DSnEKk%3D"}]}
Reporting-Endpoints: heroku-nel=https://nel.heroku.com/reports?ts=1708496005&sid
=c4c9725f-1ab0-44d8-820f-430df2718e11&s=ZygxcfXj7VrSNhmbeUM4a4gR8nnUx%2FF1aWem8D
SnEKk%3D
Nel: {"report_to":"heroku-nel","max_age":3600,"success_fraction":0.005,"failure_
fraction":0.05,"response_headers":["Via"]}
X-Powered-By: Express
Access-Control-Allow-Origin: *
Etag: W/"54-FdWiravys+z1hKjfJQwqhhSyszM"
Via: 1.1 vegur
CF-Cache-Status: DYNAMIC
Vary: Accept-Encoding
Server: cloudflare
CF-RAY: 858cd7e1cbb45507-DEL
Content-Encoding: gzip

{
    "name": "dipti ranjan",
    "job": "test engineer",
    "updatedAt": "2024-02-21T06:13:25.659Z"
}
HTTP/1.1 204 No Content
Date: Wed, 21 Feb 2024 06:13:26 GMT
Content-Length: 0
Connection: keep-alive
Report-To: {"group":"heroku-nel","max_age":3600,"endpoints":[{"url":"https://nel
.heroku.com/reports?ts=1708496006&sid=c4c9725f-1ab0-44d8-820f-430df2718e11&s=FI8
NxLoMJ%2FkFJEpJPnuVZ1Fot%2FQrKZwXOQUCNyX4jDY%3D"}]}
Reporting-Endpoints: heroku-nel=https://nel.heroku.com/reports?ts=1708496006&sid
=c4c9725f-1ab0-44d8-820f-430df2718e11&s=FI8NxLoMJ%2FkFJEpJPnuVZ1Fot%2FQrKZwXOQUC
NyX4jDY%3D
Nel: {"report_to":"heroku-nel","max_age":3600,"success_fraction":0.005,"failure_
fraction":0.05,"response_headers":["Via"]}
X-Powered-By: Express
Access-Control-Allow-Origin: *
Etag: W/"2-vyGp6PvFo4RvsFtPoIWeCReyIC8"
Via: 1.1 vegur
CF-Cache-Status: DYNAMIC
Server: cloudflare
CF-RAY: 858cd7e75fd9597c-DEL
PASSED: APITesting_RestAssured.Testscript1.PutRequestAPI
PASSED: APITesting_RestAssured.Testscript1.PostRequestAPI_IDcapture
PASSED: APITesting_RestAssured.Testscript1.DeleteRequestAPI

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================
===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================*/