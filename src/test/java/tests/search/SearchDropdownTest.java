package tests.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.search.SearchPage;
import testBase.TestBase;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;

public class SearchDropdownTest extends TestBase {

    @Test
    @DisplayName("Search dropdown test")
    @Tag("Search")
    public void shouldVerifyIfDropdownContainsValue() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        at(SearchPage.class)
                .provideProductName("HUMMINGBIRD"); // podmien na element


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = driver.findElement(By.cssSelector("#ui-id-1"));
        wait.until(ExpectedConditions.visibilityOf(element));
        List<WebElement> productRows = driver.findElements(By.cssSelector("#ui-id-1>li"));
        for (WebElement productRow : productRows) {

            String text = productRow.getText();
            System.out.println(text);
            //assert that...
        }
    }
}