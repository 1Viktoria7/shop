package com.example.shop.apiTests;

import com.example.shop.apiTests.testObjects.AddShopClass;
import com.example.shop.apiTests.testObjects.GetShopClass;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;
import static org.hamcrest.Matchers.equalTo;

public class ShopApplicationApiTests extends ShopApplicationApiBaseTests {
    //Methods
    @BeforeEach
    public void setUp() {
        requestSpec = given();
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder();
        responseGetShopClass = specBuilder.build();
    }

    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Добавление магазина")
    public void ShouldAddShop() {
        //RequestSpecification request = RestAssured.given();
        AddShopClass data = generateNewShop();
        given()
                .body(data)
                .when()
                .post(pathAddShops)
                .then();
    }

    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Получение всех магазинов")
    public void ShouldGetAllShopsCase2() {
        requestSpec = RestAssured.given();
        List<GetShopClass> response = requestSpec
                .param("shopPublic", "true")
                .get(pathAllShops)
                .as(new TypeRef<>() {});
        Assertions.assertThat(response)
                .extracting(
                        GetShopClass::getShopId,
                        GetShopClass::getShopName,
                        GetShopClass::isShopPublic
                )
                .contains(
                        tuple(16203L,
                                "ShopController№1",
                                true)
                );
    }

    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Получение названия магазина по Id")
    public void ShouldGetShopNameById() {
        requestSpec = RestAssured.given();
        requestSpec
                .get(pathGetShopById + 7952 )
                .then()
                .spec(responseGetShopClass)
                .body("shopName", equalTo("Online Store №1"));
    }

    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Получение всех магазинов")
    public void ShouldGetAllShops() {
        Response response1 = given().get(pathAllShops);
        Assertions.assertThat(response1)
                .extracting(
                        Response::getStatusCode,
                        Response::getStatusLine
                )
                .contains(
                        200,
                        "HTTP/1.1 200 "
                );
    }

    @Test
    @Feature("Онлайн Магазин")
    @DisplayName("Удаление магазина по id")
    public void ShouldDeleteShop() {
        when()
                .delete(pathDeleteShopById + 8752)
                .then();
    }
}