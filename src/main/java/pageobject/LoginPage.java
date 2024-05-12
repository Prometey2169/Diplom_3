package pageobject;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@AllArgsConstructor
public class LoginPage {

    private final WebDriver driver;

    //Локатор кнопки "Войти"
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    //Локатор поля Email
    private final By emailField = By.xpath("//label[contains(text(),'Email')]/../input");
    //Локатор поля Пароль
    private final By passwordField = By.xpath("//label[contains(text(),'Пароль')]/../input");
    //Локатор кнопки "Зарегистрироваться"
    private final By loginRegisterButton = By.xpath(".//*[text()='Зарегистрироваться']");
    //Локатор информации о некорректном пароле
    private final By errorPassMessage = By.xpath(".//p[text() = 'Некорректный пароль']");
    //Локатор кнопки "Восстановить пароль"
    private final By passForgotButton = By.xpath(".//*[text()='Восстановить пароль']");
    //Локатор кнопки "Личный кабинет"
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']/parent::*");
    //Локатор кнопки конструктора
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    @Step("Заполнение поля Email")
    public void setEmail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
    }
    @Step("Заполнение поля Пароль")
    public void setPassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
    }
    @Step("Клик на кнопку 'Конструктор'")
    public MainPage clickConstructorButton() {
        driver.findElement(constructorButton).click();
        return new MainPage(driver);
    }
    @Step("Клик на кнопку 'Зарегистрироваться'")
    public RegisterPage clickRegisterButton() {
        driver.findElement(loginRegisterButton).click();
        return new RegisterPage(driver);
    }
    @Step("Клик на кнопку 'Войти'")
    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return this;
    }
    @Step("Клик на кнопку 'Личный кабинет'")
    public void clickAccountButton() {
        driver.findElement(accountButton).click();
    }
    @Step("Клик на кнопку 'Восстановить пароль'")
    public PassForgotPage clickPassForgotButton() {

        WebElement element = driver.findElement(passForgotButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        driver.findElement(passForgotButton).click();

        return new PassForgotPage(driver);
    }
    @Step("Заполнение полей 'Email' и 'Пароль'")
    public MainPage signInUser(String userEmail, String userPassword){

        clickAccountButton();
        setEmail(userEmail);
        setPassword(userPassword);
        clickSignInButton();

        return new MainPage(driver);
    }
    @Step("Заполнение полей 'Email' и 'Пароль' с неверным значением поля 'Пароль'")
    public LoginPage signInUserWithWrongPassword(String userEmail, String userPassword){

        clickAccountButton();
        setEmail(userEmail);
        setPassword(userPassword);
        clickSignInButton();

        return new LoginPage(driver);
    }
    @Step("Получение сообщения о неверном пароле")
    public boolean isErrorAboutPassMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorPassMessage));

        return driver.findElement(errorPassMessage).isDisplayed();
    }
    @Step("Отображение кнопки 'Войти'")
    public boolean isSignInButtonShown() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButton));

        return driver.findElement(signInButton).isDisplayed();
    }
}
