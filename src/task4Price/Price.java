package task4Price;

public class Price implements Comparable<Price>{

    String productName;
    String shopName;
    double price;

    Price(String productName, String shopName, double price) {
        this.price = price;
        this.productName = productName;
        this.shopName = shopName;
    }

    public String getProductName() {
        return productName;
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public int compareTo(Price p) {
        return this.shopName.compareTo(p.shopName);
    }

}
