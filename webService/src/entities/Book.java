package entities;


import java.util.List;

/**
 * Created by Student on 3/24/2016.
 */
public class Book {
    private String title;
    private String isbn;
    private String goodreadsLink;
    private String bookImgUrl;
    private String numberOfPages;
    private String averageRating;
    private List<Author> authors;

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGoodreadsLink() {
        return goodreadsLink;
    }

    public void setGoodreadsLink(String goodreadsLink) {
        this.goodreadsLink = goodreadsLink;
    }

    public String getBookImgUrl() {
        return bookImgUrl;
    }

    public void setBookImgUrl(String bookImgUrl) {
        this.bookImgUrl = bookImgUrl;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
