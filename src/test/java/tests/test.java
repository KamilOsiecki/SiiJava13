package tests;

import base.TestBase;
import org.junit.jupiter.api.Test;

public class test extends TestBase {

    @Test
    public void shouldAddProductToBasketAndCheckOrderDetails(){
        userSteps.addProductToBasket(5);
    }
}