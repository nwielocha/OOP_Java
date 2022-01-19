public class Product {
    private String code;
    private String name;
    private double price;


    public Product(String productCode, String productName, double productPrice) {
        code = productCode;
        name = productName;
        price = productPrice;
    }


    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}