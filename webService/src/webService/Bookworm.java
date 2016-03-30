package webService;

import entities.Book;
import org.xml.sax.SAXException;

import javax.ws.rs.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.*;

/**
 * Created by savannaholson on 3/8/16.
 */
// The Java class will be hosted at the URI path "/webservice"
@Path("/webService")
public class Bookworm {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    @Path("/{authorFirst}/{authorLast}")
    public String getRecomendationWithTitleAndAuthor(
            @PathParam("authorFirst") String authorFirst,
            @PathParam("authorLast") String authorLast
            ) {

        GoodreadsAPI apiRequest = new GoodreadsAPI();
        String xml = "";










        try {
            xml = apiRequest.getBooksByAuthorName(authorFirst + "%20" + authorLast);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        JAXBContext jc = JAXBContext.newInstance( "entities.Book" );
        Unmarshaller u = jc.createUnmarshaller();
        StringBuffer xmlStr = new StringBuffer(xml);
        Object o = u.unmarshal( new StreamSource( new StringReader( xmlStr.toString() ) ) );

        return "";


        /*
        ArrayList<Book> recomendations = new ArrayList<Book>();

        Book book = new Book(author, title); //INCOMPLETE!!! THE BOOKS IN THE ARRAY LIST NEED TO BE GOTTEN FROM GOODREADS

        recomendations.add(book); // THIS WILL CONTAIN BOOK OBJECTS

        String recomendationsJSON = "";

        return recomendationsJSON;
        */

        return "";
    }

    /*
    public String getJsonFromBooksList(List<Book> books) {
        String json = "[";

        for (Book book : books) {

            json += "{ \"title\": \"" + book.getTitle() + "\", \"author\":\"" + book.getAuthor() + "\" },";

        }

        json = json.substring(0, (json.length() - 1) );

        json += "]";

        return json;
    }
    */

}
