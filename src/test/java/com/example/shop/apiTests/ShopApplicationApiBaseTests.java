package com.example.shop.apiTests;

import com.example.shop.apiTests.testObjects.SupportingClass;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;

public class ShopApplicationApiBaseTests extends SupportingClass {
    RequestSpecification requestSpec;
    ResponseSpecification responseGetShopClass;
    ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
    static Faker faker = new Faker();

    @BeforeEach
    public void setBase() {
        RestAssured.baseURI = MAIN_URL;
        faker = new Faker();
    }

    public final static String MAIN_URL = "http://localhost:4000/";
    public final static String PATH_SHOPS = "shops/";
    public final static String PATH_GET_ADD_SHOPS = "shops/add";
    public final static String PATH_GET_ALL_SHOPS = "shops/all";
    public final static String PATH_GET_SHOP_ID = "shops/";
    public final static String PATH_DELETE_SHOP_ID = "delete/";

    @BeforeEach
    public void setup() {
        RequestSpecification requestSpecification = new RequestSpecBuilder().build();
    }
}