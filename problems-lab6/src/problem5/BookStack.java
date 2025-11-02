package problem5;

import java.util.LinkedList;

public class BookStack {
    private LinkedList<Book> stack;

    public BookStack() {
        stack = new LinkedList<>();
    }

    public void push(Book book) {
        stack.addFirst(book);
    }

    public Book pop() {
        if (!stack.isEmpty()) {
            Book removed = stack.removeFirst();
            System.out.println("Popped: " + removed);
            return removed;
        }
        System.out.println("Cannot pop: Stack is empty!");
        return null;
    }

    public Book peek() {
        if (!stack.isEmpty()) {
            Book top = stack.getFirst();
            System.out.println("Top: " + top);
            return top;
        }
        System.out.println("Cannot peek: Stack is empty!");
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("Stack contents (top to bottom):");
        for (Book book : stack) {
            System.out.println("- " + book);
        }
    }
}
