package task4Price;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String productName;
        String shopName;
        double price = 0;

        Price[] priceList = new Price[2];

        Scanner sc;

        for (int i = 0; i < 2; i++) {
            sc = new Scanner(System.in);
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
                        throw new IllegalArgumentException("Incorrect price data.");
                    }
                    poop = false;
                /* Я немножко ошибся.
                 * Одним catch'ем здесь не обойтись. У нас по сути два исключения, которые требуют разных действий.
                 * Когда введено корректное, но отрицательное значение, нам нужно просто снова запросить ввод
                 * корректного значения.
                 */
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + "\nTry again");
                /*
                 * Когда же введено некорректное значение, нам надо перед запросом нового очистить введенную строку,
                 * потому что эти символы в противном случае остаются в буфере. В данном случае достаточно просто
                 * прочесть next()-ом.
                 */
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println(e.getMessage() + "\nTry again");
                }
            }

            Price currentPrice = new Price(productName, shopName, price);
            priceList[i] = currentPrice;
            System.out.println(currentPrice.toString());
            System.out.println("the end");
        }
        System.out.println(priceList.toString()); // Посмотри, что ты тут печатаешь
//        //*Это просто проверка для понимания, что массив сформировался, а еще освоение toString
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
        sc = new Scanner(System.in);
        shopName2 = sc.nextLine();

        //*еще не понимаю, как заставить сканировать, без исключений на тех элементах,
        // которые существуют в массиве, но не совпадают с введенным названием.
        // В текущем варианте он выдает исключение по элементам, где совпадения нет.
        for (Price count:
                priceList) {
            try {
                boolean availableShop = true;//изначально сделала черех иф, может, сначала присвоить значение?
                availableShop = (shopName2.equalsIgnoreCase(count.shopName)); // для чего эта переменная?
                System.out.println("The product " + count.getProductName() +
                            "\nis available at the shop " + count.getShopName() +
                            "\nat the price " + count.getPrice() + " rub.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
