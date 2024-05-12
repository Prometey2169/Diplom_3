package pageobject;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class MainPage {
    private final WebDriver driver;

    //Локатор кнопки "Личный кабинет"
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']/parent::*");
    //Локатор кнопки "Войти" на главной странице
    private final By signInMainPageButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //Локатор вкладки "Булки"
    private final By bunsButton = By.xpath(".//span[text()='Булки']");
    //Локатор вкладки "Соусы"
    private final By saucesButton = By.xpath(".//span[text()='Соусы']");
    //Локатор вкладки "Начинки"
    private final By fillingsButton = By.xpath(".//span[text()='Начинки']");
    //Локатор булок
    private final By bun = By.xpath(".//div[contains(span/text(),'Булки') and contains(@class,'current')]");
    //Локатор соусов
    private final By sauces = By.xpath(".//div[contains(span/text(),'Соусы') and contains(@class,'current')]");
    //Локатор начинки
    private final By fillings = By.xpath(".//div[contains(span/text(),'Начинки') and contains(@class,'current')]");
    @Step("Переход в раздел 'Личный кабинет'")
    public LoginPage clickAccountButton(){
        driver.findElement(accountButton).click();
        return new LoginPage(driver);
    }
    @Step("Переход в раздел 'Личный кабинет' авторизованным пользователем")
    public ProfilePage clickAccountButtonWithAuthorizedUser(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        element.click();
        return new ProfilePage(driver);
    }
    @Step("Клик по кнопке 'Войти в аккаунт'")
    public LoginPage clickSignInMainPageButton() {
        driver.findElement(signInMainPageButton).click();
        return new LoginPage(driver);
    }
    @Step("Клик по разделу 'Булки'")
    public MainPage clickBunsButton() {
        driver.findElement(bunsButton).click();
        return new MainPage(driver);
    }
    @Step("Клик по разделу 'Соусы'")
    public MainPage clickSaucesButton() {
        driver.findElement(saucesButton).click();
        return new MainPage(driver);
    }
    @Step("Клик по разделу 'Начинки'")
    public MainPage clickFillingsButton() {
        driver.findElement(fillingsButton).click();
        return new MainPage(driver);
    }
    @Step("Отображение раздела 'Булки'")
    public boolean isBunsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bun));

        return driver.findElement(bun).isDisplayed();
    }
    @Step("Отображение раздела 'Соусы'")
    public boolean isSaucesDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sauces));

        return driver.findElement(sauces).isDisplayed();
    }
    @Step("Отображение раздела 'Начинки'")
    public boolean isFillingsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(fillings));

        return driver.findElement(fillings).isDisplayed();
    }
}
