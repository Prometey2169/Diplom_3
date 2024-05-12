import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;
import static utils.Util.randomString;

public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Регистрация пользователя с корректными данными")
    @Description("Проверка на возможность регистрации пользователя с корректными данными ")
    public void registerUserTest() {

        Boolean actual = new MainPage(driver)
                .clickAccountButton()
                .clickRegisterButton()
                .registerUser(user.getName(),user.getEmail(), user.getPassword())
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .isAccountTextShown();


        assertTrue("На вкладке 'Личный кабинет' нет описания страницы", actual);

    }
    @Test
    @DisplayName("Регистрация пользователя с корректными данными через API")
    @Description("Проверка на возможность регистрации пользователя с корректными данными через API")
    public void registerUserApiTest() {

        userClient.createUser(user);
        Boolean actual = new MainPage(driver)
                .clickAccountButton()
                .signInUser(user.getEmail(), user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .isAccountTextShown();
        assertTrue("На вкладке 'Личный кабинет' нет описания страницы", actual);
    }

    @Test
    @DisplayName("Регистрация пользователя с коротким паролем")
    @Description("Проверка на невозможность регистрации пользователя с паролем меньше 6 символов")
    public void registerUserWithShortPasswordTest() {

        user.setPassword(randomString(4));

        Boolean actual = new MainPage(driver)
                .clickAccountButton()
                .signInUserWithWrongPassword(user.getEmail(), user.getPassword())
                .isErrorAboutPassMessage();

        assertTrue("Текст об ошибке не отображается!",actual);
    }

}
