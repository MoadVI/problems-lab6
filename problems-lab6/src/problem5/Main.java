package problem5;

public class Main {
    public static void main(String[] args) {
        //Stack Test
        BookStack stack = new BookStack();
        System.out.println("=== Stack Test ===");

        stack.push(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        stack.push(new Book("1984", "George Orwell", 1949));
        stack.push(new Book("Clean Code", "Robert C. Martin", 2008));

        stack.display();
        stack.pop();
        stack.peek();
        stack.display();

        //Queue Test

        BookQueue queue = new BookQueue();
        System.out.println("\n=== Queue Test ===");

        queue.enqueue(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        queue.enqueue(new Book("1984", "George Orwell", 1949));
        queue.enqueue(new Book("Clean Code", "Robert C. Martin", 2008));

        queue.display();
        queue.dequeue();
        queue.peek();
        queue.display();

    }
}
