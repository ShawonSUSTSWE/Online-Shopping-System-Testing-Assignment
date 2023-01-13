package shop;

public class Admin {

    private int adminID;
    private String name;
    private Shop shop;

    public Admin(int adminID, String name, Shop shop) {
        this.adminID = adminID;
        this.name = name;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public void addProduct(Product product) {
        shop.addProduct(product);
    }

    public void removeProduct(Product product) {
        shop.removeProduct(product);
    }

    public void updateProduct(Product product, Product modProduct) {
        shop.updateProduct(product, modProduct);
    }

    public String makeShipment(Product product, int quantity) {
        for (Product targetProduct: shop.products) {
            if(targetProduct.equals(product)) {
                return "Shipment confirmed for " + String.valueOf(quantity) + " " + product.getName();
            }
        }
        return "Product Not Found";
    }
}
