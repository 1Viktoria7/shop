package com.example.shop.unitTests;

import com.example.shop.ShopHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTestShopHandler {
    @Test
    @DisplayName("Проверка количества букв в названии магазина")
    void shouldCheckShopNameLength() {
        String name = "ShopController";
        int count = 10;

        boolean result = ShopHandler.checkLength(name, count);

        assertTrue(result);
    }

    @Test
    @DisplayName("Негативный тест. Проверка количества букв в названии магазина")
    void shouldCheckShopNameLengthNegative() {
        String name = "OnlineShop";
        int count = 15;

        boolean result = ShopHandler.checkLength(name, count);

        assertFalse(result);
    }
}