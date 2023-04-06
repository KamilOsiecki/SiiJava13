package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ProductGridPage extends BasePage {
    public ProductGridPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product-miniature")
    private List<WebElement> productMiniatures;

/*
    public ProductDetailsPage openProductWithName(String productName){
        return new ProductDetailsPage(driver);
    }
*/

    public List<ProductMiniaturePage> getProducts(){
        List<ProductMiniaturePage> productMiniaturePages = new ArrayList<>();

        for (WebElement element : productMiniatures){
            productMiniaturePages.add(new ProductMiniaturePage(driver, element));
        }
        return productMiniaturePages;
    }

    //        public List<E> E getProducts(){
//        List<E> generic = new ArrayList<E>();
//
//        for (WebElement element : productMiniatures){
//            generic.add(new E(driver, element));
//        }
//        return generic;
//    }
    public String getRandomProductName(){
        ProductMiniaturePage product = new ProductMiniaturePage(driver, getRandomElement(productMiniatures));
        return product.getTitle();
    }






//    public String getProductName(){
//        ProductMiniaturePage product = new ProductMiniaturePage(driver, )
//    }
}


//    public List<Class<T>> T,U getProducts(T, U){
//        Class<T> generic = new ArrayList<T>();
//
//        for (T element : List<U>){
//            generic.add(new Class<T>(driver, element));
//        }
//        return generic;
//    }