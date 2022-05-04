import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
public class UserData extends base
{
    public String user_id;
    public JsonPath js;
    public UserData() throws IOException {
        super();
    }
    @Test(priority = 1)
    public void getList()
    {
        Response res= given()
                .header("app-id","6272137329f68e7c2c22bac2")
                .get(obj.getProperty("url")+"user");
        String responseBody=res.asString();
        System.out.println(responseBody);
        Assert.assertEquals(res.statusCode(),200);
        js=new JsonPath(responseBody);
        user_id=js.getString("data[0].id");
        System.out.println(user_id);
    }
    @Test(priority = 2)
    public void getUserById()
    {
        Response res= given()
                .header("app-id","6272137329f68e7c2c22bac2")
                .get(obj.getProperty("url")+"user/"+user_id);
        String responseBody=res.asString();
        System.out.println(responseBody);
        Assert.assertEquals(res.statusCode(),200);

    }
    @Test(priority = 3)
    public void createUser()
    {
        CreateUserRequestBody requestBody=CreateUserRequestBody.builder().firstName("Test").lastName("Testing").email("testingname10@gmail.com").build();
        Response res=given()
                .contentType(ContentType.JSON)
                .header("app-id","6272137329f68e7c2c22bac2")
                .body(requestBody)
                .post(obj.getProperty("url")+"user/create");
        String responseBody=res.asString();
        System.out.println(responseBody);
        Assert.assertEquals(res.statusCode(),200);
        js=new JsonPath(responseBody);
        user_id=js.getString("id");
        System.out.println(user_id);
    }
    @Test(priority = 4)
    public void updateUser()
    {
        CreateUserRequestBody requestBody=CreateUserRequestBody.builder().firstName("Thanisha").lastName("M").build();
        Response res=given()
                .header("app-id","6272137329f68e7c2c22bac2")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put(obj.getProperty("url")+"user/"+user_id);
        String responseBody=res.asString();
        System.out.println(responseBody);
        Assert.assertEquals(res.statusCode(),200);
    }
}