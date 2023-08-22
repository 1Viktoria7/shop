package com.example.shop.apiTests.testObjects;

import com.example.shop.apiTests.ShopApplicationApiBaseTests;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiUtil extends ShopApplicationApiBaseTests {
    private final static String baseUrl = MAIN_URL;

    public static Object createOnlineShopByApi() throws IOException {
        OkHttpClient client = new OkHttpClient();

        final String name = "New custom online shop";

        final Long id = 12345L;

        final Boolean status = true;

        FormBody formBody = new FormBody(
                List.of("New custom online shop",
                        "12345L",
                        "true"),
                List.of(name
                ));

        Request postRequest = new Request.Builder()
                .url(MAIN_URL + "/api/createOnlineShop")
                .post(formBody)
                .build();

        Call call = client.newCall(postRequest);

        Response r = call.execute();
        assertTrue(r.isSuccessful());

        return new JSONObject()
                .put("New custom online shop", name)
                .put("123L", id)
                .put("true", status);
    }
}