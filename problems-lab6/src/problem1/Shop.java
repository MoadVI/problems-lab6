package problem1;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        ArrayList<Item> cart = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        String keepShopping;

        do {
            System.out.print("Enter the name of the item: ");
            String itemName = scan.nextLine();

            System.out.print("Enter the unit price: ");
            double itemPrice = scan.nextDouble();

            System.out.print("Enter the quantity: ");
            int quantity = scan.nextInt();
            scan.nextLine();

            Item item = new Item(itemName, itemPrice, quantity);
            cart.add(item);

            System.out.println("\n--- Current Cart ---");
            double total = 0;
            for (Item itm : cart) {
                System.out.println(itm);
                total += itm.getPrice() * itm.getQuantity();
            }
            System.out.printf("Total: $%.2f%n", total);

            System.out.print("\nContinue shopping (y/n)? ");
            keepShopping = scan.nextLine();

        } while (keepShopping.equals("y"));

        System.out.println("\nThank you for shopping!");
        scan.close();
    }
}
