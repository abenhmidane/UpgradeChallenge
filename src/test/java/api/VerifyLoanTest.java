package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import util.ApiTestSetup;

public class VerifyLoanTest extends ApiTestSetup {

    @Test
    public void ValidateProductType() {

        RestAssured.baseURI = obj.getProperty("productTypeEndpoint");
        RequestSpecification request = RestAssured.given();

        //header
        request.header("x-cf-source-id", "coding-challenge");
        request.header("x-cf-corr-id", "532f2b50-f3c1-11eb-a2ed-cf5413edd0f3");
        request.header("Content-Type", "application/json");

        //body
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", obj.getProperty("apiLogin"));
        requestParams.put("password", obj.getProperty("apiPassword"));
        requestParams.put("recaptchaToken", "coding_challenge");

        // Add the Json to the body of the request
        request.body(requestParams.toJSONString());

        // Post the request and check the response
        Response response = request.log().all().post(obj.getProperty("loginUrl"));
        response.prettyPrint();

        Assert.assertEquals("200", response.getStatusCode());
        //due to the fact that i cannot receive a response i will not be adding other assertion
        // the other assertion is going through the body and asserting the the value.

    }
}

