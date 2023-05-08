package stepdefinitions.us06;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.US06PojoDelete;
import utils.ObjectMapperUtils;

import static base_urls.ManagementOnSchoolBaseUrlForDean.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.us06.US06_1_Post.idNumber;
import static org.junit.Assert.assertEquals;

public class US06_4_Delete {

    Response response;
    US06PojoDelete expectedData;
    US06PojoDelete actualData;

    @Given("olusturulan datayi silme")
    public void olusturulan_datayi_silme() {

        spec.pathParams("first","vicedean","second","delete","third",idNumber);
        expectedData= new US06PojoDelete("Vice dean Deleted","OK");

        response = given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();

        actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),US06PojoDelete.class);
        System.out.println(actualData);
    }
    @Then("silindigini kontrol etme")
    public void silindigini_kontrol_etme() {

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getMessage(),actualData.getMessage());
        assertEquals(expectedData.getHttpStatus(),actualData.getHttpStatus());


    }
}
