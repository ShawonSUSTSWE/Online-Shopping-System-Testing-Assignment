package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cart {

    private int cartID;
    public List<Product> products;

    public Cart() {
        setCartID();
        products = new ArrayList<>();
    }

    public void setCartID() {
        cartID = new Random().nextInt(100);
    }

    public void addToCart(Product product) {
        products.add(product);
    }

    public void removeFromCart(Product product) {
        for (Product targetProduct: products) {
            if(targetProduct.equals(product)) {
                products.remove(targetProduct);
            }
        }
    }

    public String seeAllItemsInCart () {
        String cartItems = "";
        for (Product product: products) {
            cartItems += product.toString();
        }
        return cartItems;
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Product product: products) {
            total += product.getPrice();
        }
        return total;
    }

    public int getNumberOfItems() {
        return products.size();
    }
}
