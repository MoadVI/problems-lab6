package problem3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the library: ");
        int capacity = scanner.nextInt();
        scanner.nextLine();
        Library library = new Library(capacity);
        library.add(new Textbook("Introduction to Algorithms", "Cormen", 1312, "5"));

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add a document");
            System.out.println("2. Display all documents");
            System.out.println("3. Delete a document by numEnreg");
            System.out.println("4. Display authors");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Add a: 1. Novel  2. Textbook  3. Magazine");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter number of pages: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine();

                    switch (type) {
                        case 1 -> {
                            System.out.print("Enter author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter price: ");
                            double price = scanner.nextDouble();
                            scanner.nextLine();
                            library.add(new Novel(title, author, pages, price));
                        }
                        case 2 -> {
                            System.out.print("Enter author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter level: ");
                            String level = scanner.nextLine();
                            library.add(new Textbook(title, author, pages, level));
                        }
                        case 3 -> {
                            System.out.print("Enter month: ");
                            String month = scanner.nextLine();
                            System.out.print("Enter year: ");
                            int year = scanner.nextInt();
                            scanner.nextLine();
                            library.add(new Magazine(title, month, year));
                        }
                        default -> System.out.println("Invalid document type.");
                    }
                    System.out.println("Document added!");
                }

                case 2 -> {
                    System.out.println("\nLibrary Documents:");
                    library.displayDocuments();
                }

                case 3 -> {
                    System.out.print("Enter numEnreg of document to delete: ");
                    int num = scanner.nextInt();
                    scanner.nextLine();

                    Document toDelete = library.document(num);
                    if (toDelete != null) {
                        library.delete(toDelete);
                        System.out.println("Document deleted.");
                    } else {
                        System.out.println("No document found with numEnreg " + num);
                    }
                }

                case 4 -> {
                    System.out.println("\nAuthors in the library:");
                    library.displayAuthors();
                }

                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid option! Try again.");
            }
        }
    }
}
