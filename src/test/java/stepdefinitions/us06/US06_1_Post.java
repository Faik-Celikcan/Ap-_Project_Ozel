package stepdefinitions.us06;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.US06PojoKayit;
import pojos.US06PojoKayitEnUst;
import utils.ObjectMapperUtils;

import static base_urls.ManagementOnSchoolBaseUrlForDean.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US06_1_Post {

    Response response;
    US06PojoKayit us06PojoKayit;

    US06PojoKayitEnUst actualData;

    static String country ;
    static String firstName ;
    static String password ;
    static String lastName ;
    static String username ;

    static String ssn ;

    static String telefon ;

    static int idNumber;

    Faker faker=new Faker();
    @Given("send post request")
    public void send_post_request() {

        System.out.println("------------------------------------------");
        spec.pathParams("first","vicedean","second","save");


        Integer pn_1=faker.number().numberBetween(100,999);
        Integer pn_2=faker.number().numberBetween(100,999);
        Integer pn_3=faker.number().numberBetween(1000,9999);
        String pn1=pn_1.toString();
        String pn2=pn_2.toString();
        String pn3=pn_3.toString();

        telefon=pn1+"-"+pn2+"-"+pn3;

        Integer sn_1=faker.number().numberBetween(100,899);
        Integer sn_2=faker.number().numberBetween(10,99);
        Integer sn_3=faker.number().numberBetween(1000,9999);
        String sn1=sn_1.toString();
        String sn2=sn_2.toString();
        String sn3=sn_3.toString();

        ssn=sn1+"-"+sn2+"-"+sn3;

        country =faker.country().name();
        firstName =faker.name().firstName();
        password =faker.internet().password();
        lastName =faker.name().lastName();
        username =faker.name().username();


        System.out.println("------------------------------------------");
        us06PojoKayit =new US06PojoKayit("1997-03-03",country,"MALE",firstName,password,telefon,ssn,lastName,username);


        System.out.println("------------------------------------------");
        response=given(spec).contentType(ContentType.JSON).body(us06PojoKayit).post("{first}/{second}");
        response.prettyPrint();
        actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), US06PojoKayitEnUst.class);
        System.out.println(actualData);




        idNumber = actualData.getObject().getUserId();
    }


    @Then("validate post")
    public void validate_post() {

        assertEquals(200,response.statusCode());
        assertEquals(us06PojoKayit.getBirthDay(),actualData.getObject().getBirthDay());
        assertEquals(us06PojoKayit.getBirthPlace(),actualData.getObject().getBirthPlace());
        assertEquals(us06PojoKayit.getGender(),actualData.getObject().getGender());
        assertEquals(us06PojoKayit.getName(),actualData.getObject().getName());
        assertEquals(us06PojoKayit.getPhoneNumber(),actualData.getObject().getPhoneNumber());
        assertEquals(us06PojoKayit.getSsn(),actualData.getObject().getSsn());
        assertEquals(us06PojoKayit.getSurname(),actualData.getObject().getSurname());
        assertEquals(us06PojoKayit.getUsername(),actualData.getObject().getUsername());

    }
}
