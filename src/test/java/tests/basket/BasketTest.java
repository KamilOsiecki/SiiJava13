package tests.basket;

import base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import providers.UrlProvider;

public class BasketTest extends TestBase {

    @ParameterizedTest
    @MethodSource("tests.util_test.UtilTest#basketTestTestDataProvider")
    @DisplayName("Basket generic test")
    @Tag("Basket")
    public void shouldAddProductsAndCheckOrderDetails(int numberOfProductsToAdd){
        userSteps.addProductToBasket(numberOfProductsToAdd);
        driver.get(UrlProvider.basket);
    }
}
