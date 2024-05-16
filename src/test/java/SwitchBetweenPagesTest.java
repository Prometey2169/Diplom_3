import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class SwitchBetweenPagesTest extends BaseTest {
    @Test
    @DisplayName("Переход в 'Личный кабинет' неавторизованного пользователя")
    @Description("Проверка на возможность перехода в раздел 'Личный кабинет' неавторизованного пользователя")
    public void openProfilePageNonAuthUserTest() {
        Boolean actual = new MainPage(driver)
                .clickAccountButton()
                .isSignInButtonShown();

               assertTrue("Страница авторизации не открывается у неавторизованного пользователя!",actual);
    }

    @Test
    @DisplayName("Переход в 'Личный кабинет' авторизованного пользователя")
    @Description("Проверка на возможность перехода в раздел 'Личный кабинет' авторизованного пользователя")
    public void openProfilePageWithAuthUserTest() {
        userClient.createUser(user);

        Boolean actual = new MainPage(driver)
                .clickSignInMainPageButton()
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .isAccountTextShown();


        assertTrue("Раздел 'Личный кабинет' не открывается у авторизованного пользователя!",actual);
    }

    @Test
    @DisplayName("Переход из 'Личного кабинета' неавторизованного пользователя в 'Конструктор'")
    @Description("Проверка на возможность перехода в раздел 'Конструктор' неавторизованного пользователя")
    public void switchFromProfilePageNonAuthUserTest() {
        Boolean actual = new MainPage(driver)
                .clickSignInMainPageButton()
                .clickConstructorButton()
                .isBunsDisplayed();

        assertTrue("Раздел 'Конструктор' не открывается у неавторизованного пользователя!",actual);
    }

    @Test
    @DisplayName("Переход из 'Личного кабинета' авторизованного пользователя в 'Конструктор'")
    @Description("Проверка на возможность перехода в раздел 'Конструктор' авторизованного пользователя")
    public void switchFromProfilePageWithAuthUserTest() {
        userClient.createUser(user);

        Boolean actual = new MainPage(driver)
                .clickSignInMainPageButton()
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .clickConstructorButton()
                .isBunsDisplayed();

        assertTrue("Раздел Конструктор не открывается у авторизованного пользователя!", actual);
    }

    @Test
    @DisplayName("Переход из 'Личного кабинета' в раздел 'Конструктор' через клик по логотипу")
    @Description("Проверка, что открывается главная станица, когда авторизованный пользователь кликнул на логотип")
    public void switchFromProfilePageWithClickLogoTest() {
        userClient.createUser(user);

        Boolean actual = new MainPage(driver)
                .clickSignInMainPageButton()
                .signInUser(user.getEmail(),user.getPassword())
                .clickAccountButtonWithAuthorizedUser()
                .clickLogoButton()
                .isBunsDisplayed();

        assertTrue("Главная станица не открывается при клике на логотип!",actual);

    }
}
