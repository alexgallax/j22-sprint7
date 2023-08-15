package edu.praktikum.courier;

import edu.praktikum.models.Courier;

import static edu.praktikum.utils.Utils.randomString;

public class CourierGenerator {

    public static Courier randomCourier() {
        return new Courier()
                .withLogin(randomString(8))
                .withPassword(randomString(12))
                .withFirstName(randomString(10));
    }

    public static Courier courierWithoutName() {
        return new Courier()
                .withLogin(randomString(8))
                .withPassword(randomString(12));
    }
}
