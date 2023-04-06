package testBase;

import configuration.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import providers.DriverFactory;

import java.lang.reflect.InvocationTargetException;

@Slf4j
public class TestBase {
    protected static WebDriver driver;
    private static DriverFactory driverFactory;
    private static AppProperties appProperties;

    @BeforeAll
    static void setup() {
        appProperties = AppProperties.getInstance();
        driverFactory = new DriverFactory();
    }

    @BeforeEach
    void setupDriver() {
        driver = driverFactory.getDriver();
        driver.get(System.getProperty("app_url"));
    }

    @AfterEach
    void tearDown() {
        try {
            driver.quit();
            log.info("WebDriver closed successfully");
        } catch (Exception e) {
            log.error("WebDriver was not closed.");
        }
    }

    //Klasa generyczna - ta metoda pozwala na sprytne wykonywanie testów - styl kodowania testów
    public <T extends BasePage> T at(Class<T> pageType) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        log.info("Creating PageObject: " + pageType.getName());
        return pageType.getDeclaredConstructor(WebDriver.class).newInstance(driver);
    }
}