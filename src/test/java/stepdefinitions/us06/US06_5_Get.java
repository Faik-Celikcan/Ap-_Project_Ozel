package stepdefinitions.us06;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.US06PojoHata;
import utils.ObjectMapperUtils;

import static base_urls.ManagementOnSchoolBaseUrlForDean.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.us06.US06_1_Post.idNumber;
import static org.junit.Assert.assertEquals;
public class US06_5_Get {

    Response response;
    US06PojoHata expectedData;
    US06PojoHata actualData;
    @Given("Olmayan Datayi Kontrol")
    public void olmayan_datayi_kontrol() {
        spec.pathParams("first","vicedean","second","getViceDeanById","third",idNumber);

        Integer a =idNumber;
        String b =a.toString();
        expectedData=new US06PojoHata("Error: User with SSN "+b+" not found",400,"/vicedean/getViceDeanById/232",1682886272215L);


        response=given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),US06PojoHata.class);
    }
    @Then("olmadigini dogrulama")
    public void olmadigini_dogrulama() {

        assertEquals(400,response.statusCode());
        assertEquals(expectedData.getMessage(),actualData.getMessage());

    }
}
