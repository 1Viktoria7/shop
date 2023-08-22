package com.example.shop.apiTests.testObjects;

public class AddShopClass extends SupportingClass {

    public String shopName;

    public Boolean shopPublic;

    public AddShopClass() {
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public AddShopClass(String shopName, boolean shopPublic) {

        this.shopName = shopName;
        this.shopPublic = shopPublic;
    }
}