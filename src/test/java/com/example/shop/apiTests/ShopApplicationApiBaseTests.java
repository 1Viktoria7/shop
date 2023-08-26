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
    //Variables
    RequestSpecification requestSpec;
    ResponseSpecification responseGetShopClass;
    ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
    static Faker faker = new Faker();
    public final static String mainUrl = "http://localhost:4000/";
    public final static String pathShops = "shops/";
    public final static String pathAddShops = "shops/add";
    public final static String pathAllShops = "shops/all";
    public final static String pathGetShopById = "shops/";
    public final static String pathDeleteShopById = "delete/";

    //Methods
    @BeforeEach
    public void setBase() {
        RestAssured.baseURI = mainUrl;
        faker = new Faker();
    }

    @BeforeEach
    public void setup() {
        RequestSpecification requestSpecification = new RequestSpecBuilder().build();
    }
}