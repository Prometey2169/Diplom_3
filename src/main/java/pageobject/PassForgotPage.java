package pageobject;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@AllArgsConstructor
public class PassForgotPage {

    //Локатор кнопки "Войти"
    private final By signInButton = By.xpath(".//a[text()='Войти']");

    private final WebDriver driver;
    @Step("Клик по кнопке 'Войти'")
    public LoginPage clickSignInButton() {
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }
}
