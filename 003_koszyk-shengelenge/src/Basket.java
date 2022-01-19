import java.util.Arrays;

public class Basket {
    private Product[] products;
    private int productCount; // total number of items in the basket
    private double totalPrice; // total price of items in the basket
    private int capacity; // current basket capacity
    private String coupon;
    private double discountPrice;

    public Basket() {
        capacity = 5;
        products = new Product[capacity];
        productCount = 0;
        totalPrice = 0.0;
        coupon = "";
        discountPrice = 0.0;
    }

    public void addProduct(String code, String name, double price) {
        Product temp = new Product(code, name, price);
        totalPrice += price;
        products[productCount] = temp;
        productCount += 1;

        checkIfTwoForThreeDiscount();
        checkIfFivePercentDiscount();
        checkIfCupForFree();

        if (productCount == capacity)
            increaseSize();
    }

    public void showBasket() {
        for (int i = 0; i < productCount; i++) {
            System.out.print(products[i].getName());
            System.out.print("\n");
        }
    }

    public void showFinalPrice() {
        System.out.print(totalPrice);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void applyCoupon(String coupon) {
        this.coupon = coupon;

        if (coupon.equals("JAVA30")) {
            this.discountPrice = getTotalPrice() * 0.3;
            this.totalPrice = this.totalPrice - this.discountPrice;
        }
    }

    public void checkIfFivePercentDiscount() {
        if (this.totalPrice > 300.0) {
            this.discountPrice = getTotalPrice() * 0.05;
            this.totalPrice = this.totalPrice - this.discountPrice;
        }
    }

    public void checkIfTwoForThreeDiscount() {
        if (this.productCount % 3 == 0) {
            this.discountPrice = products[this.productCount - 1].getPrice();
            this.totalPrice = this.totalPrice - this.discountPrice;
        }
    }

    public void checkIfCupForFree() {
        if (this.totalPrice > 200.0) {
            System.out.print("Kubek gratis!\n");
        }
    }

    private void increaseSize() {
        Product[] temp = new Product[capacity + 5];

        if (capacity >= 0)
            System.arraycopy(products, 0, temp, 0, capacity);

        /*
        for (int i = 0; i < capacity; i++) {
            temp[i] = products[i];
        }
        */

        products = temp;
        capacity = products.length;
    }

}