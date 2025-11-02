package problem2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank");

        Customer c1 = new Customer("Alice", new ArrayList<>());
        Customer c2 = new Customer("Bob", new ArrayList<>());

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        bank.sendMoney(c1, c2, 100.0);
        bank.printStatement("Alice");
        bank.printStatement("Bob");

    }
}
