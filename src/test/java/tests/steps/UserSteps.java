package tests.steps;

import models.Order;
import org.assertj.core.api.Assertions;
import pages.checkout.CheckoutAddressPage;
import pages.menu.TopMenuPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductGridPage;
import pages.user.CreateAccountPage;
import pages.user.LoginPage;
import base.TestBase;
import pages.user.UserAccountPage;
import providers.UrlProvider;

import java.util.Random;

public class UserSteps extends TestBase {

    public void loginUser(String email, String password) {

        at(TopMenuPage.class)
                .goToSignInPage();

        at(LoginPage.class)
                .setEmail(email)
                .setPassword(password)
                .sigIn();

        Assertions.assertThat(at(UserAccountPage.class).isMyAccountLabelDisplayed()).isTrue();
        Assertions.assertThat(at(TopMenuPage.class).isLogoutButtonDisplayed()).isTrue();
    }

    public void createNewUserAccount() {
        at(TopMenuPage.class)
                .goToSignInPage();

        at(LoginPage.class)
                .goToUserAccountCreation();

        at(CreateAccountPage.class)
                .registerNewUser(userFactory.getRandomUser());
        //jakas asercja by sie przydala
    }

    public void addInvoiceAddress(){
        at(CheckoutAddressPage.class)
                .addInvoiceAddress(invoiceFactory.getRandomInvoiceData());
    }

    public void addProductToBasket(int numberOfProducts){
        Order expectedOrder = new Order();

        for (int i=0; i<numberOfProducts; i++){
            driver.get(UrlProvider.baseUrl);

            at(ProductGridPage.class)
                    .openRandomProduct();

            at(ProductDetailsPage.class)
                    .setQuantity(new Random().nextInt(5)+1);

            expectedOrder.addProduct(at(ProductDetailsPage.class).getProductDetails());

            at(ProductDetailsPage.class).addToCart();

            //wywal to
            System.out.println(expectedOrder.getProductsSize());

            //dodaj continue shopping
        }
    }
}