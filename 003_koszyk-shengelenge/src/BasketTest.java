import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    @Test
    public void testAddProduct() {
        Basket basket = new Basket();
        basket.addProduct("0000", "mikrofon", 250.0);
        double result = basket.getTotalPrice();
        basket.showBasket();
        basket.showFinalPrice();
        assertEquals("Adds one product.",250.0, result, 0);
    }

    @Test
    public void testApplyCoupon() {
        Basket basket = new Basket();
        basket.addProduct("7777", "myszka", 150.0);
        basket.applyCoupon("JAVA30");
        double result = basket.getTotalPrice();
        basket.showBasket();
        basket.showFinalPrice();
        assertEquals("Apply coupon", 105, result, 0);
    }

    @Test
    public void testApplyCouponWithFivePercentDiscount() {
        Basket basket = new Basket();
        basket.addProduct("0000", "ksiazka", 200.0);
        basket.addProduct("0001", "ksiazka1", 120.0);
        basket.applyCoupon("JAVA30");
        double result = basket.getTotalPrice();
        basket.showBasket();
        basket.showFinalPrice();
        assertEquals("Apply coupon with 5% discount.", 212.8, result, 0);
    }

    @Test
    public void testApplyIncorrectCoupon() {
        Basket basket = new Basket();
        basket.addProduct("0000", "ksiazka", 100.0);
        basket.addProduct("0001", "ksiazka1", 70.0);
        basket.applyCoupon("JAVA20");
        double result = basket.getTotalPrice();
        basket.showBasket();
        basket.showFinalPrice();
        assertEquals("Apply incorrect coupon.", 170.0, result, 0);
    }

    @Test
    public void testApplyFivePercentDiscount() {
        Basket basket = new Basket();
        basket.addProduct("0000", "ksiazka", 200.0);
        basket.addProduct("0001", "ksiazka1", 120.0);
        double result = basket.getTotalPrice();
        basket.showBasket();
        basket.showFinalPrice();
        assertEquals("Apply 5% discount.", 304.0, result, 0);
    }

    @Test
    public void testApplyTwoForThreeDiscount() {
        Basket basket = new Basket();
        basket.addProduct("0000", "ksiazka", 20.0);
        basket.addProduct("0001", "ksiazka1", 20.0);
        basket.addProduct("0010", "ksiazka2", 9.0);
        basket.addProduct("0011", "ksiazka3", 20.0);
        basket.addProduct("0100", "ksiazka4", 20.0);
        basket.addProduct("0101", "ksiazka5", 9.0);
        double result = basket.getTotalPrice();
        basket.showBasket();
        basket.showFinalPrice();
        assertEquals("Apply 2 for 3 discount.", 80.0, result, 0);
    }

}