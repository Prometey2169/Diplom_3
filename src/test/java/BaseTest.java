import driverconstuctor.DriverFactory;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pojo.User;
import utils.UserClient;

import static utils.URLs.MAIN_PAGE_URL;
import static utils.UserGenerator.createNewUser;

public class BaseTest {
    WebDriver driver;
    UserClient userClient;
    User user;
    private String bearerToken;

    @Before
    public void setUp() {

        driver = DriverFactory.getWebDriver("yandex");
        driver.manage().window().maximize();
        driver.navigate().to(MAIN_PAGE_URL);
        user = createNewUser();
        userClient = new UserClient();
    }

    @After
    public void tearDown() {
        driver.quit();
        if (user != null) {
            ValidatableResponse responseLogin = userClient.loginUser(user);
            bearerToken = responseLogin.extract().path("accessToken");
            if (bearerToken == null) {
                return;
            }
            userClient.deleteUser(bearerToken);
        }
    }
}
