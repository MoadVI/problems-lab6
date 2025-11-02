package problem3;

public class Book extends Document{
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        super(title);
        this.title = title;
        this.author = author;
        this.pages = pages;
    }


    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() +
                " author='" + getAuthor() +
                " pages=" + pages +
                '}';
    }}
