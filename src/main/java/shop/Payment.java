package shop;

public class Payment {

    private int customerID;
    private String name;
    private String cardType;
    private String cardNo;

    public Payment(int customerID, String name, String cardType, String cardNo) {
        this.customerID = customerID;
        this.name = name;
        this.cardType = cardType;
        this.cardNo = cardNo;
    }

    public String pay(Cart cart) {
        return "Payment Successful. Total Cost: " + cart.getTotalPrice();
    }
}
