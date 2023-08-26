package com.example.shop.uiTests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class BaseShopApplicationsTestsUI {
    //Variables
    public SelenideElement onboarding = $("#greetings > h1");
    public SelenideElement mainPicture = $("html > body > header > img");
    public SelenideElement createShopLinkButton = $("#links > a:first-of-type");
    public SelenideElement allShopsLinkButton = $("#links > a:nth-of-type(2)");
    public SelenideElement deleteShopLinkButton = $("#links > a:nth-of-type(3)");
    public SelenideElement refreshButton = $("#shops_div > button");
    public SelenideElement createShopButton = $("#create > div > button");
    public SelenideElement checkbox = $("#public");
    public SelenideElement placeholderEnterShopName = $("#name");
    public SelenideElement deleteShopButton = $("#delete > div > button");
    public SelenideElement placeholderEnterShopId = $("#id");
    public SelenideElement createShopForm = $("#create > div > h2");
    public SelenideElement deleteShopForm = $("#delete > div > h2");
    public SelenideElement createdShopsForm = $("#shops_div > h2");
    public SelenideElement bodyTable = $("#response");

    //Methods
    public void checkMainPageByURL(){
        WebDriverRunner.url().equals("http://localhost:4000/");
    }

    public void checkOnboardingIsExist(){
        onboarding.shouldHave(Condition.text("Welcome to our shop constructor!"));
    }

    public void checkMainPageHeaderIsExist(){
        mainPicture.shouldBe(Condition.visible);
    }

    public void createShopButtonIsExist(){
        createShopLinkButton.shouldBe(Condition.visible);
    }

    public void allShopButtonIsExist(){
        allShopsLinkButton.shouldBe(Condition.visible);
    }

    public void deleteShopButtonIsExist(){
        deleteShopLinkButton.shouldBe(Condition.visible);
    }

    public void createShopButtonClick(){
        createShopLinkButton.click();
    }

    public void createShopFormIsVisible(){
        createShopForm.shouldBe(Condition.visible);
    }

    public void allShopsButtonClick(){
        allShopsLinkButton.click();
    }

    public void allShopsFormIsVisible(){
        createdShopsForm.shouldBe(Condition.visible);
    }

    public void deleteShopButtonClick(){
        deleteShopLinkButton.click();
    }
    public void deleteShopFormIsVisible(){
        deleteShopForm.shouldBe(Condition.visible);
    }

    public void enterShopNameSetValue(){
        placeholderEnterShopName.setValue("Create New Online shop№1");
    }
    public void checkboxClick(){
        checkbox.click();
    }

    public void createButtonClick(){
        createShopButton.click();
    }

    public void createdShopIsExist(){
        bodyTable.shouldHave(Condition.text("Create New Online shop№1"));
    }

    public void placeholderEnterShopIdSetValue(){
        placeholderEnterShopId.setValue("8752");
    }

    public void deleteButtonClick(){
        deleteShopButton.click();
    }

    public void refreshButtonClick(){
        refreshButton.click();
    }
}