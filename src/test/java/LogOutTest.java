import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class LogOutTest extends BaseTest {
    @Test
    @DisplayName("Выход из аккаунта авторизованного пользователя")
    @Description("Проверка на возможность выхода из аккаунта авторизованного пользователя")
    public void LogoutTest() {

        userClient.createUser(user);

        Boolean actual = new MainPage(driver)
                .clickAccountButton()
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .clickLogOutButton()
                .isSignInButtonShown();

        assertTrue("Пользователь все еще авторизован!",actual);
    }
}
