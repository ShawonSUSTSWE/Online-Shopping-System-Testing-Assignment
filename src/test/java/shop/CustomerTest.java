package shop;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    static Customer customer1, customer2;
    static Product product1, product2, product3, product4, product5, product6;
    static List<Product> productList1, productList2;

    @BeforeAll
    static void setUp() {

        productList1 = new ArrayList<>();
        productList2 = new ArrayList<>();

        product1 = new Product(1, "KitKat Chocolate", 50.00);
        product2 = new Product(2, "Cadbury Dairy Milk Chocolate", 40.00);
        product3 = new Product(3, "Amul Dark Chocolate", 70.00);
        product4 = new Product(4, "Bata Black Shoe", 1500.00);
        product5 = new Product(5, "Panda Blue Sneakers", 940.00);
        product6 = new Product(6, "Aarong Brown Sandal", 1070.00);

        productList1.add(product1);
        productList1.add(product2);

        productList2.add(product1);
        productList2.add(product2);

        customer1 = new Customer(101, "Md. Mazhar Ali", "Akhalia, Sylhet", "01775382540");
        customer2 = new Customer(102, "Md. Azhar Ali", "Akhalia, Sylhet", "01620518147");

    }


    @Test
    void testGetCustomerID() {
        assertEquals(101 ,customer1.getCustomerID());
    }

    @Test
    void testSetCustomerID() {
        customer2.setCustomerID(103);
        assertEquals(103 ,customer2.getCustomerID());
    }

    @Test
    void testGetAddress() {
        assertEquals("Akhalia, Sylhet" ,customer1.getAddress());
    }

    @Test
    void testSetAddress() {
        customer2.setAddress("Nobigonj");
        assertEquals("Nobigonj" ,customer2.getAddress());
    }

    @Test
    void testGetName() {
        assertEquals("Md. Mazhar Ali" ,customer1.getName());
    }

    @Test
    void testSetName() {
        customer1.setName("Md. Mazhar Ali Shawon");
        assertEquals("Md. Mazhar Ali Shawon" ,customer1.getName());
    }

    @Test
    void testGetPhoneNo() {
        assertEquals("01775382540" ,customer1.getPhoneNo());
    }

    @Test
    void testSetPhoneNo() {
        customer1.setPhoneNo("01620518147");
        assertEquals("01620518147" ,customer1.getPhoneNo());
    }

    @Test
    void testAddCart() {
        customer1.addCart();
        assertEquals(true, customer1.getCart() instanceof Cart);
    }

    @Test
    void testGetCart() {
        customer1.addCart();
        customer1.addToCart(product1);
        assertEquals(1, customer1.getCart().getNumberOfItems());
    }

    @Test
    void testAddToCart() {

        customer1.addCart();
        customer1.addToCart(product1);
        customer1.addToCart(product2);

        customer1.addToCart(product6);

        productList1.add(product6);

        String productListInCart = "";
        for (Product product: productList1) {
            productListInCart += product.toString();
        }

        assertEquals(productListInCart, customer1.seeAllItemsInCart());
    }

    @Test
    void testRemoveFromCart() {

        customer1.addCart();
        customer1.addToCart(product1);
        customer1.addToCart(product2);

        productList2.remove(product1);
        customer1.removeFromCart(product1);

        String productListInCart = "";
        for (Product product: productList2) {
            productListInCart += product.toString();
        }

        assertEquals(productListInCart, customer1.getCart().seeAllItemsInCart());

    }

    @Test
    void testSeeAllItemsInCart() {
        customer1.addCart();
        customer1.addToCart(product1);
        customer1.addToCart(product2);

        String productListInCart = "";
        for (Product product: productList1) {
            productListInCart += product.toString();
        }

        assertEquals(productListInCart, customer1.getCart().seeAllItemsInCart());
    }

    @Test
    void testCheckOut() {
        customer1.addCart();
        customer1.addToCart(product1);
        customer1.addToCart(product2);

        assertEquals("Payment Successful. Total Cost: " + customer1.getCart().getTotalPrice(), customer1.checkOut("MasterCard", "0123456789"));
    }
}