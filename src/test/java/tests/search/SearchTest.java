package tests.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.product.ProductGridPage;
import pages.search.SearchPage;
import pages.search.SearchResultPage;
import testBase.TestBase;

import java.lang.reflect.InvocationTargetException;

public class SearchTest extends TestBase {

    @Test
    @DisplayName("Search test")
    @Tag("Search")
    public void shouldVerifyNameOfSearchedProduct() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        String expectedValue =  at(ProductGridPage.class)
                .getRandomProductName();

        at(SearchPage.class)
                .provideProductName(expectedValue)
                .initSearch();

        String actualValue = at(SearchResultPage.class)
                .getProductTitle();

        Assertions.assertThat(expectedValue).isEqualTo(actualValue);
    }
}