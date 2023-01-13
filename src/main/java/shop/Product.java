package shop;

public class Product {

    private int productID;
    private String name;
    private double price;

    public Product(int productID, String name, double price) {
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void update(Product modProduct) {
        this.setProductID(modProduct.getProductID());
        this.setName(modProduct.getName());
        this.setPrice(modProduct.getPrice());
    }

    @Override
    public String toString() {
        return "productID: " + String.valueOf(productID) + "Name: " + name + "price: " + String.valueOf(price) + "/n";
    }
}
