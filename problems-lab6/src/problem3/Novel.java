package problem3;

public class Novel extends Book{
    private double  price;

    public Novel(String title, String author, int pages, double price) {
        super(title, author, pages);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Novel{" +
                "title='" + getTitle() +
                " author='" + getAuthor() +
                " pages=" + getPages() +
                " price=" + price +
                '}';
    }
}
