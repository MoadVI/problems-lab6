package problem3;

import java.util.ArrayList;

public class Library {
    private int capacity;
    ArrayList<Document> library;

    public Library(int capacity) {
        this.capacity = capacity;
        this.library = new ArrayList<>(capacity);
    }

    public void displayDocuments() {
        for (Document d : library) {
            System.out.println(d);
        }
    }

    public boolean add(Document doc) {
        if (library.size() < capacity) {
            library.add(doc);
            return true;
        }
        return false;
    }

    public boolean delete(Document doc){
        if (!library.isEmpty()) {
            library.remove(doc);
            return true;
        }
        return false;
    }

    public Document document(int numEnrg) {
        for (Document doc : library) {
            if (doc.getNumEnreg() == numEnrg) {
                return doc;
            }
        }
        return null;
    }

    public void displayAuthors() {
        for (Document doc : library) {
            if (doc instanceof Book book) {
                System.out.println(book.getAuthor());
            }
        }
    }
}
