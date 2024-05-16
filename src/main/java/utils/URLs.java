package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class URLs {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final String CREATE_USER_API = "api/auth/register";
    public static final String LOGIN_USER_API = "api/auth/login";
    public static final String DELETE_USER_API = "api/auth/user";
    public static RequestSpecification specification() {
        return new RequestSpecBuilder()
                .setBaseUri(MAIN_PAGE_URL)
                .setContentType(ContentType.JSON)
                .build();
    }
}
