package models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<Product> products;

    public Order(){
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public int getProductsSize(){
        return products.size();
    }
}
