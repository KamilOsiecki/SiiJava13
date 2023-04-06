package pages.base;

import configuration.FileHandler;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@Slf4j
public class BasePage {

    public BasePage(WebDriver driver) {
        initDriver(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, WebElement parent) {
        initDriver(driver);
        PageFactory.initElements(new DefaultElementLocatorFactory(parent), this);
    }

    private void initDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(System.getProperty("web_element_timeout"))));
        actions = new Actions(driver);
    }

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    Properties data = FileHandler.getBasePageData();
    public <T> T getRandomElement(List<T> elements){
        return elements.get(new Random().nextInt(elements.size()));
    }

    public BigDecimal getPrice(WebElement element){
        //ogarnij tutaj ten BigDecimal $ na plik na ten moment świadomie popełniony grzech śmiertelny!
        return new BigDecimal(element.getText().replace(data.getProperty("currency"), ""));
    }

    public void waitToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean IsDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click(WebElement element){
//        waitToBeClickable(element);
        element.click();
        log.info("Clicking on " + element);
    }
    public void sendKeys(WebElement element, String text){
        element.sendKeys(text);
        log.info("Typing: " + text);
    }

    public void sendKeysAndClear(WebElement element, String text){
        element.clear();

        if(!element.getText().isEmpty()){
            element.sendKeys(Keys.CONTROL + "a" + Keys.BACK_SPACE);
        }
        sendKeys(element, text);
    }
}