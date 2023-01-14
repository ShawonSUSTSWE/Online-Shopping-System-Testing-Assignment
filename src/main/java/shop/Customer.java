package shop;

public class Customer {

    private int customerID;
    private String name;
    private String address;
    private String phoneNo;
    private Cart cart;

    public Customer(int customerID, String name, String address, String phoneNo) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void addCart() {
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }

    public void addToCart(Product product) {
        cart.addToCart(product);
    }

    public void removeFromCart(Product product) {
        cart.removeFromCart(product);
    }

    public String seeAllItemsInCart() {
        return cart.seeAllItemsInCart();
    }

    public String checkOut(String cardType, String cardNo) {
        return new Payment(this.getCustomerID(), this.getName(), cardType, cardNo).pay(cart);
    }
}
