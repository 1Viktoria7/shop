package com.example.shop.unitTests;

import com.example.shop.models.ShopDto;
import com.example.shop.models.ShopPojo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.shop.ShopHandler;
import com.example.shop.controllers.ShopController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UnitTestShopController {
    //Variables
    @Mock
    public ShopHandler shopHandler;
    @InjectMocks
    public ShopController shopController;

    //Methods
    @Test
    @DisplayName("Добавление магазина, с названием содержащим более 6 символов и начинающихся с верхнего регистра")
    void shouldAddShopWithCorrectName() {
        ShopDto dto = new ShopDto(1L, "ShopController№1", true);
        ResponseEntity<String> response = shopController.addShop(dto);
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    @DisplayName("Негативный тест. Добавление магазина, с названием начинающимся не с верхнего регистра")
    void shouldAddShopNameWithoutCapitalLetter() {
        ShopDto dto = new ShopDto(1L, "shopController№2", true);

        ResponseEntity<String> response = shopController.addShop(dto);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Name should begin with a capital letter", response.getBody());

    }

    @Test
    @DisplayName("Отрицательный тест. Добавление магазина с названием содержащим 6 символов")
    void shouldAddShortShopName() {
        ShopDto dto = new ShopDto(1L, "Shop№3", true);

        ResponseEntity<String> response = shopController.addShop(dto);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Name should be more than 6 letters", response.getBody());
    }

    @Test
    @DisplayName("Добавление магазина, в названием которого входят любые символы и начинатся с верхнего регистра")
    void shouldAddShopNameWithAllSymbols() {
        ShopDto dto = new ShopDto(1L, "ShopController?!#@$%&№~*^`'/|(_)[]{}-+=.,:;<>", true);

        ResponseEntity<String> response = shopController.addShop(dto);
        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Добавление магазина, с названием содержащим 256 символов")
    void shouldAddShopNameLong() {
        ShopDto dto = new ShopDto(1L,"?!#@$%&№~*^`'/|(_)[]{}-+=.,:;<>LongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlineShopNameLongOnlin", true);

        ResponseEntity<String> response = shopController.addShop(dto);
        assertThat(response).isNotNull();
    }

    @Test
    @DisplayName("Получение существующего магазина")
    void shouldGetExistShop() {
        final ResponseEntity<ShopPojo> result = shopController.getShop(15);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}