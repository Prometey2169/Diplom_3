package pageobject;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@AllArgsConstructor
public class ProfilePage {
    private final WebDriver driver;
    //Локатор описания страницы в разделе "Личный кабинет"
    private final By accountInfo = By.xpath(".//p[text() = 'В этом разделе вы можете изменить свои персональные данные']");

    //Локатор кнопки "Конструктор"
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //Локатор кнопки логотипа "Stellar Burgers"
    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");
    //Локатор кнопки "Выход"
    private final By logOutButton = By.xpath(".//button[text()='Выход']");


    @Step("Отображение описания страницы в разделе 'Личный кабинет'")
    public boolean isAccountTextShown() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountInfo));

        return driver.findElement(accountInfo).isDisplayed();
    }
    @Step("Клик по кнопке 'Выход'")
    public LoginPage clickLogOutButton() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutButton));

        driver.findElement(logOutButton).click();

        return new LoginPage(driver);
    }
    @Step("Клик по кнопке 'Конструктор'")
    public MainPage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return new MainPage(driver);
    }
    @Step("Клик по логотипу 'Stellar Burgers'")
    public MainPage clickLogoButton() {
        driver.findElement(logoButton).click();
        return new MainPage(driver);
    }
}
