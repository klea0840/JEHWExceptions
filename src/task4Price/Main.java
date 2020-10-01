package task4Price;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String productName;
        String shopName;
        double price = 0;

        Price[] priceList = new Price[2];

        // Ты создаешь сканнер два раза внутри цикла и один раз в конце программы
        // Можно создать его один раз в данной случае
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            System.out.println("Enter the name of the product: ");
            productName = sc.nextLine();

            System.out.println("Enter the name of the shop: ");
            shopName = sc.nextLine();


            boolean poop = true;
            while(poop) {
                try {
                    System.out.println("Enter the price: ");
                    price = sc.nextDouble();
                    if (price < 0) {
                        throw new Exception("Incorrect price data.");
                    }
                    poop = false;
//                } catch (NumberFormatException e) {
//                    System.out.println(e.getMessage() + "\nTry again");
                // Здесь можно обойтись даже одним catch-блоком
                } catch (Exception e) {
                    System.out.println(e.getMessage() + "\nTry again");
                }
            }

            Price currentPrice = new Price(productName, shopName, price);
            priceList[i] = currentPrice;
            System.out.println(currentPrice.toString());
            System.out.println("the end");
        }
        System.out.println(priceList.toString()); // Посмотри, что ты тут печатаешь
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
        System.out.println("Enter the name of the required shop: ");
        shopName2 = sc.nextLine();

        for (Price count:
                priceList) {
            try {
                boolean availableShop = (shopName2.equalsIgnoreCase(count.shopName)); // для чего эта переменная?
                System.out.println("The product " + count.getProductName() +
                            "\nis available at the shop " + count.getShopName() +
                            "\nat the price " + count.getPrice() + " rub.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
