package hw2.models;

public class Book {
    private String title;
    private String authorName;
    private String authorLName;
    private Integer pages;

    public Book(String title, String authorName, String authorLName, Integer pages) {
        this.title = title;
        this.authorName = authorName;
        this.authorLName = authorLName;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorLName() {
        return authorLName;
    }

    public void setAuthorLName(String authorLName) {
        this.authorLName = authorLName;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorLName='" + authorLName + '\'' +
                ", pages=" + pages +
                '}';
    }
}
