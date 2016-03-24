package entities;

/**
 * Created by Student on 3/24/2016.
 */
public class Author {
    private String name;
    private String goodreadsLink;
    private String rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodreadsLink() {
        return goodreadsLink;
    }

    public void setGoodreadsLink(String goodreadsLink) {
        this.goodreadsLink = goodreadsLink;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
