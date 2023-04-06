package pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class SearchResultListElementPage extends BasePage {

    public SearchResultListElementPage(WebDriver driver, WebElement parent) {
        super(driver, parent);
    }

    @FindBy(css = "li .product")
    private WebElement productName;

    public String getProductName() {
        return productName.getText();
    }
}