package com.example.shop.apiTests.testObjects;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeAll;

public class SupportingClass {


    public static Faker faker = new Faker();
    public static AddShopClass generateNewShop() {
        String shopName = faker.name().username();
        Boolean shopPublic = faker.random().nextBoolean();
        return new AddShopClass();
    }

    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeAll
    public static void setBaseUri() {
        RestAssured.baseURI = "http://localhost:4000/";
    }
}