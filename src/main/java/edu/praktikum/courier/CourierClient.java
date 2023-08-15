package edu.praktikum.courier;

import edu.praktikum.models.Courier;
import edu.praktikum.models.CourierCreds;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClient {

    private static final String BASE_URI = "https://qa-scooter.praktikum-services.ru";

    private static final String CREATE_URL = "api/v1/courier";
    private static final String LOGIN_URL = "api/v1/courier/login";

    public CourierClient() {
        RestAssured.baseURI = BASE_URI;
    }

    public Response create(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(CREATE_URL);
    }

    public Response login(CourierCreds creds) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(creds)
                .when()
                .post(LOGIN_URL);
    }

    public Response delete(String id) {
        return null; // нужно имплементировать ;)
        //return given().
    }
}
