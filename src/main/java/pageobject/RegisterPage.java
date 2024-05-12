package pageobject;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class RegisterPage {

    private final WebDriver driver;

    //Локатор поля "Имя"
    private final By nameField = By.xpath("//label[contains(text(),'Имя')]/../input");
    //Локатор поля  "Email"
    private final By emailField = By.xpath("//label[contains(text(),'Email')]/../input");
    //Локатор поля "Пароль"
    private final By passwordField = By.xpath("//label[contains(text(),'Пароль')]/../input");
    //Локатор кнопки "Зарегистрироваться"
    private final By loginRegisterButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //Локатор кнопки "Войти"
    private final By signInButton = By.xpath("//a[text()='Войти']");
    @Step("Заполнение поля 'Имя'")
    public RegisterPage setName(String userName) {
        driver.findElement(nameField).sendKeys(userName);
        return this;
    }
    @Step("Заполнение поля 'Email'")
    public RegisterPage setEmail(String userEmail) {
        driver.findElement(emailField).sendKeys(userEmail);
        return this;
    }
    @Step("Заполнение поля 'Пароль'")
    public RegisterPage setPassword(String userPassword) {
        driver.findElement(passwordField).sendKeys(userPassword);
        return this;
    }
    @Step("Клик по кнопке 'Зарегистрироваться'")
    public void clickRegisterButton() {

        driver.findElement(loginRegisterButton).click();
    }
    @Step("Заполнение полей 'Email', 'Имя', 'Пароль'")
    public LoginPage registerUser(String name,String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
        return new LoginPage(driver);
    }
    @Step("Клик по кнопке 'Войти'")
    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

}
