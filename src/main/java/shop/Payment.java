package shop;

public class Payment {
    public String pay(Cart cart) {
        return "Payment Successful. Total Cost: " + cart.getTotalPrice();
    }
}
