package problem2;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers;

    public Bank(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer c) {
        if (!customers.contains(c)) {
            customers.add(c);
            System.out.println("Added new customer " + c.getName());
        } else {
            System.out.println(c.getName() + " already exists ni teh bank!");
        }
    }

    public void sendMoney(Customer sender, Customer receiver, double amount) {
        if (customers.contains(sender) && customers.contains(receiver)) {
            receiver.addTransaction(amount);
            sender.addTransaction(-amount);
            System.out.println("Transferred " + amount + " from " + sender.getName() + " to " + receiver.getName());
        } else {
            System.out.println("Transaction failed one or both customers not found in the bank.");
        }
    }


    public void printStatement(String customerName) {
        for (Customer c : customers) {
            if (c.getName().equalsIgnoreCase(customerName)) {
                System.out.println("Statement for " + c.getName() + ":");
                for (Double d : c.getTransactions()) {
                    double amount = d;
                    System.out.println(amount + "$");
                }
                return;
            }
        }
        System.out.println("Customer " + customerName + " not found.");
    }

}
