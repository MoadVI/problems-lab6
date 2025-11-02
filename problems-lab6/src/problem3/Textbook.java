package problem3;

public class Textbook extends Book {
    private String level;

    public Textbook(String title, String author, int pages,String level) {
        super(title, author, pages);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Textbook{" +
                "title='" + getTitle() +
                " author='" + getAuthor() +
                " pages=" + getPages() +
                " price=" + level +
                '}';
    }
}
