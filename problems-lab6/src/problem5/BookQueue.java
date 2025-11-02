package problem5;

import java.util.LinkedList;

public class BookQueue {
    private LinkedList<Book> queue;

    public BookQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Book book) {
        queue.addLast(book);
    }

    public Book dequeue() {
        if (!queue.isEmpty()) {
            Book removed = queue.removeFirst();
            System.out.println("Dequeued: " + removed);
            return removed;
        }
        System.out.println("Cannot dequeue: Queue is empty!");
        return null;
    }

    public Book peek() {
        if (!queue.isEmpty()) {
            Book front = queue.getFirst();
            System.out.println("Front: " + front);
            return front;
        }
        System.out.println("Cannot peek: Queue is empty!");
        return null;
    }

    public void display() {
        System.out.println("Queue contents (front to back):");
        for (Book book : queue) {
            System.out.println("- " + book);
        }
    }
}
