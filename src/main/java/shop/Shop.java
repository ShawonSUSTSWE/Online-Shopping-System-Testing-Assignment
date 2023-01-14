package shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    private String name;
    public List<Product> products;

    public Shop(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    public Shop(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        for (Product targetProduct: products) {
            if(targetProduct.equals(product)) {
                products.remove(targetProduct);
            }
        }
    }

    public void updateProduct(Product product, Product modProduct) {
        for (Product targetProduct: products) {
            if(targetProduct.equals(product)) {
                product.setProductID(modProduct.getProductID());
                product.setName(modProduct.getName());
                product.setPrice(modProduct.getPrice());
            }
        }
    }

    public String getProductsList() {
        String productsList = "";
        for (Product product: products) {
            productsList += product.toString();
        }
        return productsList;
    }
}
