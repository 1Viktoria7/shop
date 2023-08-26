package com.example.shop.uiTests;

import org.openqa.selenium.Keys;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.open;

public class ShopApplicationsTestsUI {
    //Variables
    BaseShopApplicationsTestsUI baseShopApplicationsTestsUI = new BaseShopApplicationsTestsUI();

    //Methods
    @BeforeEach
    public void setSelenide() throws InterruptedException {
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");
        open("http://localhost:4000/");
        Thread.sleep(5000);
    }

    @Test
    @DisplayName("Проверка корректности отображения главной страницы")
    @Feature("Меню")
    @Story("Главная страница")
    public void shouldExistMainPage() {
        step("Проверить главную страницу по URL", () -> {
            baseShopApplicationsTestsUI.checkMainPageByURL();
        });
        step("Онбординг и наличие заголовка в header", () -> {
            baseShopApplicationsTestsUI.checkOnboardingIsExist();
            baseShopApplicationsTestsUI.checkMainPageHeaderIsExist();
        });
    }

    @Test
    @DisplayName("Проверка наличия ссылок в верхней части главной страницы")
    @Feature("Меню")
    @Story("Главная страница")
    public void shouldExistButtonsInHeader() {
        step("Проверить наличие кнопок в header", () -> {
            baseShopApplicationsTestsUI.createShopButtonIsExist();
            baseShopApplicationsTestsUI.allShopButtonIsExist();
            baseShopApplicationsTestsUI.deleteShopButtonIsExist();
        });
    }

    @Test
    @DisplayName("Проверка работы основных кнопок в header'е")
    @Feature("Меню")
    @Story("Главная страница")
    public void shouldClickButtonsInHeader() {
        step("Проверить кликабельность кнопок: Create shop, All shops, Delete shop", () -> {
            baseShopApplicationsTestsUI.createShopButtonClick();
            baseShopApplicationsTestsUI.createShopFormIsVisible();
            baseShopApplicationsTestsUI.allShopsButtonClick();
            baseShopApplicationsTestsUI.allShopsFormIsVisible();
            baseShopApplicationsTestsUI.deleteShopButtonClick();
            baseShopApplicationsTestsUI.deleteShopFormIsVisible();
        });
    }

    @Test
    @DisplayName("Проверка кнопки Create shop")
    @Feature("Меню")
    @Story("Главная страница")
    public void shouldClickRefreshButtonClick() {
        step("Ввести название магазина, поставить галочку публичный, нажать кнопку" +
                "Create shop", () -> {
            baseShopApplicationsTestsUI.enterShopNameSetValue();
            baseShopApplicationsTestsUI.checkboxClick();
            baseShopApplicationsTestsUI.createButtonClick();
            actions().keyDown(Keys.ENTER).click();
        });
        step("Подтвердить действие на странице, проверить созданного магазина", () -> {
            actions().keyDown(Keys.ENTER).click();
            baseShopApplicationsTestsUI.createdShopIsExist();
        });

    }

    @Test
    @DisplayName("Проверка кнопки All shops")
    @Feature("Меню")
    @Story("Главная страница")
    public void shouldCickAllShopsButton() {
        step("Проверить переход по кнопке, к списку магазинов", () -> {
            baseShopApplicationsTestsUI.allShopsButtonClick();
            baseShopApplicationsTestsUI.allShopsFormIsVisible();
        });
    }

    @Test
    @DisplayName("Проверка кнопки Delete shop")
    @Feature("Меню")
    @Story("Главная страница")
    public void shouldClickDeleteButton() {
        step("Ввести id магазина, нажать кнопку Delete shop", () -> {
            baseShopApplicationsTestsUI.placeholderEnterShopIdSetValue();
            baseShopApplicationsTestsUI.deleteButtonClick();
        });
        step("Подтвердить действие на странице", () -> {
            actions().keyDown(Keys.ENTER).click();
        });
    }

    @Test
    @DisplayName("Проверка кнопки refresh")
    @Feature("Меню")
    @Story("Главная страница")
    public void shouldClickRefreshButton() {
        step("Проверить кликабельность кнопки Refresh", () -> {
            baseShopApplicationsTestsUI.refreshButtonClick();
            baseShopApplicationsTestsUI.checkMainPageByURL();
            baseShopApplicationsTestsUI.checkOnboardingIsExist();
            baseShopApplicationsTestsUI.checkMainPageHeaderIsExist();
        });
    }
}
