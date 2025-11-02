package problem3;


public class Document {
    private int numEnreg;
    private static int nextNumEnreg = 1;
    private String title;

    public Document(String title) {
        this.title = title;
        this.numEnreg =nextNumEnreg++;
    }

    public int getNumEnreg() {
        return numEnreg;
    }

    public String getTitle() {return title;}


    @Override
    public String toString() {
        return "Document{" +
                "numEnreg=" + numEnreg +
                ", title='" + title + '\'' +
                '}';
    }
}
