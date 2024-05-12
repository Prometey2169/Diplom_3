import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход в профиль через кнопку 'Личный кабинет'")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Личный кабинет'")
    public void singInWithProfileButtonTest() {
        userClient.createUser(user);

        Boolean actual = new MainPage(driver)
                .clickAccountButton()
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .isAccountTextShown();


        assertTrue("На вкладке 'Личный кабинет' нет описания страницы", actual);
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти в аккаунт' на главной странице")
    @Description("Проверка на возможность войти в аккаунт через кнопку 'Войти в аккаунт' на главной странице")
    public void singInFromMainPageTest() {
        userClient.createUser(user);

        Boolean actual = new MainPage(driver)
                .clickSignInMainPageButton()
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .isAccountTextShown();


        assertTrue("На вкладке 'Личный кабинет' нет описания страницы", actual);
    }


    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме регистрации")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInFromRegisterPageTest() {
        userClient.createUser(user);

        Boolean actual = new MainPage(driver)
                .clickAccountButton()
                .clickRegisterButton()
                .clickSignInButton()
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .isAccountTextShown();

        assertTrue("На вкладке 'Личный кабинет' нет описания страницы", actual);
    }

    @Test
    @DisplayName("Вход в профиль через кнопку 'Войти' в форме восстановления пароля")
    @Description("Проверка, что можно войти в аккаунт через кнопку 'Войти' в форме регистрации")
    public void singInFromPassForgotPageTest() {
        userClient.createUser(user);

        Boolean actual = new MainPage(driver)
                .clickAccountButton()
                .clickPassForgotButton()
                .clickSignInButton()
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .isAccountTextShown();

        assertTrue("На вкладке 'Личный кабинет' нет описания страницы", actual);
    }
}
