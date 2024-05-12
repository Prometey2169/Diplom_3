package utils;

import pojo.User;

import static utils.Util.randomString;

public class UserGenerator {
    public static User createNewUser() {

        return new User()
                .setEmail(randomString(9) + "@yandex.ru")
                .setPassword(randomString(8))
                .setName(randomString(9));

    }

}
