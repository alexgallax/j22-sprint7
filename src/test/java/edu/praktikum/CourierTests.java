package edu.praktikum;

import edu.praktikum.courier.CourierClient;
import edu.praktikum.models.Courier;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static edu.praktikum.courier.CourierGenerator.randomCourier;
import static edu.praktikum.models.CourierCreds.credsFrom;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

public class CourierTests {

    private CourierClient courierClient;
    private String id;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    @Test
    public void createCourier() {
        Courier courier = randomCourier();

        Response response = courierClient.create(courier);
        id = response.path("id");

        assertEquals("Неверный статус код", SC_CREATED, response.statusCode());

        Response loginResponse = courierClient.login(credsFrom(courier));

        assertEquals("Курьер не залогинен", SC_OK, loginResponse.statusCode());
    }

    @After
    public void tearDown() {
        courierClient.delete(id);
    }
}
