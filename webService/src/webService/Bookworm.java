package webService;

import entities.Book;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by savannaholson on 3/8/16.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/webService")
public class Bookworm {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    @Path("/{title}/{author}")
    public String getRecomendationWithTitleAndAuthor(
            @PathParam("title") String title,
            @PathParam("author") String author
            ) {

        ArrayList<Book> recomendations = new ArrayList<Book>();

        Book book = new Book(author, title); //INCOMPLETE!!! THE BOOKS IN THE ARRAY LIST NEED TO BE GOTTEN FROM GOODREADS

        recomendations.add(book); // THIS WILL CONTAIN BOOK OBJECTS

        String recomendationsJSON = getJsonFromBooksList(recomendations);

        return recomendationsJSON;
    }

    public String getJsonFromBooksList(List<Book> books) {
        String json = "[";

        for (Book book : books) {

            json += "{ \"title\": \"" + book.getTitle() + "\", \"author\":\"" + book.getAuthor() + "\" },";

        }

        json = json.substring(0, (json.length() - 1) );

        json += "]";

        return json;
    }

}
