package shop;

public class Customer {

    private int customerID;
    private String name;
    private String cardNo;
    private String phoneNo;
    private Cart cart;

    public Customer(int customerID, String name, String cardNo, String phoneNo) {
        this.customerID = customerID;
        this.name = name;
        this.cardNo = cardNo;
        this.phoneNo = phoneNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
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

    public void seeAllItemsInCart() {
        cart.seeAllItemsInCart();
    }

    public void checkOut() {
        new Payment().pay(cart);
    }
}
