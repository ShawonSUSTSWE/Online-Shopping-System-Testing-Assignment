package shop;

import java.util.List;

public class Shop {

    private String name;
    public List<Product> products;

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
                product.update(modProduct);
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
