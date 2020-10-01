package task4Price;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String productName;
        String shopName;
        double price = 0;

        Price[] priceList = new Price[2];

        for (int i = 0; i < 2; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name of the product: ");
            productName = sc.nextLine();

            System.out.println("Enter the name of the shop: ");
            shopName = sc.nextLine();

            boolean poop = true;
            while(poop) {
                try {
                    System.out.println("Enter the price: ");
                    price = sc.nextDouble();
                    poop = false;
                } catch (Exception e) {
                    System.out.println(e.getMessage() + "Try again");
                    sc.next();
                }
                try {
                    if (price < 0) {
                        throw new Exception("Incorrect price data.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage() + "Try again");
                }
            }

            Price currentPrice = new Price(productName, shopName, price);
            priceList[i] = currentPrice;
            System.out.println(currentPrice.toString());
            System.out.println("the end");
        }
        System.out.println(priceList.toString());
        for (Price values:
                priceList) {
            System.out.println("Unsorted Name: " + values.getShopName());
        }

        Arrays.sort(priceList);

        for (Price values:
                priceList) {
            System.out.println("Sorted Name: " + values.getShopName());
        }

        String shopName2;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Enter the name of the required shop: ");
        shopName2 = sc2.nextLine();

        for (Price count:
                priceList) {
            try {
                boolean availableShop = (shopName2.equalsIgnoreCase(count.shopName));
                System.out.println("The product " + count.getProductName() +
                            "\nis available at the shop " + count.getShopName() +
                            "\nat the price " + count.getPrice() + " rub.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            }
        }
}
