package pages.cart;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".cart-products-count")
    private WebElement cartProductCounter;

    @FindBy(css = "a.btn-primary")
    private WebElement proceedToCheckoutBtn;

    public void goToCheckout(){
        click(proceedToCheckoutBtn);
    }
    public int getCartProductsNumber() {
        return Integer.parseInt(StringUtils.substring(getText(cartProductCounter), 1, getText(cartProductCounter).length() - 1));
    }
}