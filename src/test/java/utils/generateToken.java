package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class generateToken {

    public static String generateTokenAdmins(){

        String idSifre="{\n" +
                "  \"password\": \"12345678\",\n" +
                "  \"username\": \"AdminB103\"\n" +
                "}";

       Response response = given().contentType(ContentType.JSON).body(idSifre).post("http://164.92.252.42:8080/auth/login");

       return response.jsonPath().getString("token");
    }
    public static String generateTokenDeans(){

        String idSifre="{\n" +
                "  \"password\": \"12345678\",\n" +
                "  \"username\": \"deanB103\"\n" +
                "}";

        Response response = given().contentType(ContentType.JSON).body(idSifre).post("http://164.92.252.42:8080/auth/login");

        return response.jsonPath().getString("token");
    }
}
