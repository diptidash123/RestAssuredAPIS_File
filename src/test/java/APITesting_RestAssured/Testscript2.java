package APITesting_RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
public class Testscript2 {
	
	/*//post request api using payload in different approaches
	1.hashmap
	2.org.json(JSONObject)
	3.pojo class
	4.external json file*/
	//post request API testing
		//https://reqres.in/api/users RC-201
		/*{
		    "name": "morpheus",
		    "job": "leader"
		}*/ 
	//HashMap Scenario
	//@Test(priority = 1,enabled = true)
	public void scenario1()
	{
		HashMap data=new HashMap();
		data.put("name","dipti");
		data.put("job","testengineer");
		
		given()
		  .contentType("application/json")
		  .body(data)
		  
		.when()
		  .post("https://reqres.in/api/users")
		  
		.then()
		  .statusCode(201)
		  .body("name",equalTo("dipti"))
		  .body("job",equalTo("testengineer"))
		  .log().all();
	}
	
	//org.json JSONObject
  //@Test(priority = 2,enabled = true)
  public void scenario2()
  {
	  JSONObject obj=new JSONObject();
	  obj.put("name","diptiranjandash");
	  obj.put("job","Automation Engineer");
	  
	  given()
	    .contentType("application/json")
	    .body(obj.toString())
	    
	  .when()
	    .post("https://reqres.in/api/users")
	    
	  .then()
	     .statusCode(201)
	     .body("name",equalTo("diptiranjandash"))
	     .body("job",equalTo("Automation Engineer"))
	     .log().all();
  }
  
  //External JSON file
  @Test(priority = 4,enabled = true)
  public void scenario4() throws FileNotFoundException
  {
	  File f=new File("D:\\RestAssuredAPI\\RestAssuredSessionTestProject\\JsonInputData.json");
	  FileReader fr=new FileReader(f);
	  JSONTokener js=new JSONTokener(fr);	  
	  JSONObject obj=new JSONObject(js);
	  
	  given()
	    .contentType("application/json")
	    .body(obj.toString())
	    
	  .when()
	    .post("https://reqres.in/api/users")
	    
	  .then()
	     .statusCode(201)
	     .body("name",equalTo("diptiranjandash"))
	     .body("job",equalTo("Automation Engineer"))
	     .log().all();
  }
}