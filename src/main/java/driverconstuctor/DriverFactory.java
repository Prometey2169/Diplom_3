package driverconstuctor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static utils.URLs.MAIN_PAGE_URL;

public class DriverFactory {
    public static WebDriver getWebDriver(String browserName) {


        switch (browserName) {

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                return driver;


            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe");
                driver = new ChromeDriver();
                return driver;

            default: throw new RuntimeException("Browser " + browserName + " not supported");

        }
    }
}
