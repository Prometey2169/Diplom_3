package utils;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pojo.User;


import static io.restassured.RestAssured.given;

public class UserClient {
    @Step("Создание пользователя")
    public ValidatableResponse createUser(User user) {
        return given()
                .spec(URLs.specification())
                .and()
                .body(user)
                .when()
                .post(URLs.CREATE_USER_API)
                .then();
    }

    @Step("Авторизация пользователя для получения токена")
    public ValidatableResponse loginUser(User user) {
        return given()
                .spec(URLs.specification())
                .and()
                .body(user)
                .when()
                .post(URLs.LOGIN_USER_API)
                .then();
    }

    @Step("Удаление пользователя")
    public ValidatableResponse deleteUser(String bearerToken) {
        return given()
                .spec(URLs.specification())
                .headers("Authorization", bearerToken)
                .delete(URLs.DELETE_USER_API)
                .then();
    }
}
