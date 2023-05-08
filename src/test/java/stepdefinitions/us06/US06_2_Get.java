package stepdefinitions.us06;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.US06PojoKayit;
import pojos.US06PojoKayitEnUst;
import utils.ObjectMapperUtils;

import static base_urls.ManagementOnSchoolBaseUrlForDean.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.us06.US06_1_Post.*;
import static org.junit.Assert.assertEquals;

public class US06_2_Get {

    Response response;

    US06PojoKayitEnUst actualData;
    US06PojoKayit expectedData;

    @Given("send get request to get vice dean")
    public void send_get_request_to_get_vice_dean() {

        spec.pathParams("first","vicedean","second","getViceDeanById","third",idNumber);

        expectedData =new US06PojoKayit("1997-03-03",country,"MALE",firstName,password,telefon,ssn,lastName,username);

        response = given(spec).contentType(ContentType.JSON).get("{first}/{second}/{third}");
        response.prettyPrint();

        actualData =ObjectMapperUtils.convertJsonToJava(response.asString(),US06PojoKayitEnUst.class);

        System.out.println(actualData);


    }
    @Then("validate viceDean")
    public void validate_vice_dean() {

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getBirthDay(),actualData.getObject().getBirthDay());
        assertEquals(expectedData.getBirthPlace(),actualData.getObject().getBirthPlace());
        assertEquals(expectedData.getGender(),actualData.getObject().getGender());
        assertEquals(expectedData.getName(),actualData.getObject().getName());
        assertEquals(expectedData.getPhoneNumber(),actualData.getObject().getPhoneNumber());
        assertEquals(expectedData.getSsn(),actualData.getObject().getSsn());
        assertEquals(expectedData.getSurname(),actualData.getObject().getSurname());
        assertEquals(expectedData.getUsername(),actualData.getObject().getUsername());


    }
}
