package pages.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;
import pages.product.ProductMiniaturePage;

import java.util.ArrayList;
import java.util.List;

public class SearchResultListPage extends BasePage {
    public SearchResultListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#ui-id-1>li")
    private List<WebElement> searchResultRows;

    public List<SearchResultListElementPage> getSearchResultsRows() {
        List<SearchResultListElementPage> searchResultListElementPages = new ArrayList<>();

        for (WebElement element : searchResultRows) {
            searchResultListElementPages.add(new SearchResultListElementPage(driver, element));
        }
        return searchResultListElementPages;
    }
}