package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utils.generateToken.generateTokenAdmins;


public class ManagementOnSchoolBaseUrlForAdmin {

    public static RequestSpecification spec;

    public static void setUpAdmin(){

        spec= new RequestSpecBuilder().setAccept(ContentType.JSON).addHeader("Authorization",generateTokenAdmins()).setBaseUri("http://164.92.252.42:8080").build();
    }
}
