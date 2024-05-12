import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.MainPage;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {
    @Test
    @DisplayName("Клик по разделу 'Булки'")
    @Description("Проверка на возможность перейти в раздел 'Булки' ")
    public void openBunsTest() {
        Boolean actual = new MainPage(driver)
                .clickSaucesButton()
                .clickBunsButton()
                .isBunsDisplayed();

        assertTrue("Раздел 'Булки' не отображается!",actual);
    }

    @Test
    @DisplayName("Клик по разделу 'Соусы'")
    @Description("Проверка на возможность перейти в раздел 'Соусы' ")
    public void openSaucesTest() {
        Boolean actual = new MainPage(driver)
                .clickSaucesButton()
                .isSaucesDisplayed();

        assertTrue("Раздел 'Соусы' не отображается!",actual);
    }

    @Test
    @DisplayName("Клик по разделу 'Начинки'")
    @Description("Проверка на возможность перейти в раздел 'Начинки' ")
    public void openFillingsTest() {
        Boolean actual = new MainPage(driver)
                .clickFillingsButton()
                .isFillingsDisplayed();

        assertTrue("Раздел 'Начинки' не отображается!",actual);
    }

}
