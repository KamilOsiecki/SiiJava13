import models.User;
import org.openqa.selenium.WebElement;
import pages.product.ProductMiniaturePage;
import providers.UserFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


//        User user = User.builder()
//                .firstName("Jan")
//                .lastName("Kowalski")
//                .email("Jan@Kowalski@gmail.com")
//                .password("12345")
//                .customerPrivacy(false)
//                .generalTerms(true)
//                .and()
//                .socialTitle("CHWDP")
//                .birthdate("24/02/2024")
//                .partnersOffers(true)
//                .newsletter(false)
//                .build();
//        System.out.println(user);

        UserFactory userFactory = new UserFactory();
        System.out.println(userFactory.getRandomUser());
        System.out.println("");
        System.out.println(userFactory.getAlreadyRegisteredUser());
    }
}
