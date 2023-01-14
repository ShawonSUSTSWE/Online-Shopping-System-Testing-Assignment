package shop;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AdminTest {

    static Admin admin1, admin2, admin3;
    static Shop shop1, shop2;
    static Product product1, product2, product3, product4, product5, product6;
    static List<Product> productList1, productList2;

    @BeforeAll
    static void init() {

        productList1 = new ArrayList<>();
        productList2 = new ArrayList<>();

        product1 = new Product(1, "KitKat Chocolate", 50.00);
        product2 = new Product(2, "Cadbury Dairy Milk Chocolate", 40.00);
        product3 = new Product(3, "Amul Dark Chocolate", 70.00);

        productList1.add(product1);
        productList1.add(product2);
        productList1.add(product3);

        product4 = new Product(4, "Bata Black Shoe", 1500.00);
        product5 = new Product(5, "Panda Blue Sneakers", 940.00);
        product6 = new Product(6, "Aarong Brown Sandal", 1070.00);

        productList2.add(product4);
        productList2.add(product5);
        productList2.add(product6);

        shop1 = new Shop("Family Super Shop", productList1);
        shop2 = new Shop("Imran Shoes");

        admin1 = new Admin(1, "Md. Mosoddar Ali", shop1);
        admin2 = new Admin(2, "Imran Shoes", shop2);
        admin3 = new Admin(3, "Adnan", shop2);
    }

    @Test
    public void testGetAdminID() {
        assertEquals(1, admin1.getAdminID());
        assertNotEquals(1, admin2.getAdminID());
    }

    @Test
    public void testSetAdminID() {
        admin3.setAdminID(4);
        assertEquals(4, admin3.getAdminID());
    }

    @Test
    public void testGetName() {
        assertEquals("Md. Mosoddar Ali", admin1.getName());
    }

    @Test
    public void testSetName() {
        admin1.setName("Mohammed Mosoddar Ali");
        assertEquals("Mohammed Mosoddar Ali", admin1.getName());
    }

    @Test
    public void testGetShop() {
        assertEquals(shop1, admin1.getShop());
        assertNotEquals(shop2, admin1.getShop());
    }

    @Test
    public void testSetShop() {
        admin3.setShop(shop1);
        assertEquals(shop1, admin3.getShop());
    }

    @Test
    public void testAddProduct() {

        //Creating and Adding a new Product
        Product product7 = new Product(7, "Pran Milk Candy", 1.00);
        productList1.add(product7);
        admin1.addProduct(product7);

        String productList = "";
        for (Product product: productList1) {
            productList += product.toString();
        }
        assertEquals(productList, admin1.seeProductsInShop());
    }

    @Test
    public void testRemoveProduct() {

        //Removing A Product
        productList1.remove(product3);
        admin1.removeProduct(product3);

        String productList = "";
        for (Product product: productList1) {
            productList += product.toString();
        }
        assertEquals(productList, admin1.seeProductsInShop());

    }

    @Test
    public void testUpdateProduct() {

        productList1.remove(product3);
        product3.setPrice(80.00);
        productList1.add(product3);
        admin1.updateProduct(product3, new Product(3, "Amul Dark Chocolate", 80.00));


        String productList = "";
        for (Product product: productList1) {
            productList += product.toString();
        }
        assertEquals(productList, admin1.seeProductsInShop());
    }

    @Test
    public void testMakeShipment() {
        String expectedMsg = "Shipment confirmed for 5 " + product2.getName();
        assertEquals(expectedMsg, admin1.makeShipment(product2, 5));
        assertEquals("Product Not Found", admin1.makeShipment(product5, 5));
    }

    @Test
    public void testConfirmDelivery() {
        String expectedMsg = "Delivery confirmed for 5 " + product2.getName();
        assertEquals(expectedMsg, admin1.confirmDelivery(product2, 5));
        assertEquals("Product Not Found", admin1.confirmDelivery(product5, 5));
    }
}