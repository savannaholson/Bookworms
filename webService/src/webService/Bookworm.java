package webService;

import com.fasterxml.jackson.core.JsonProcessingException;
import entities.GoodreadsResponseType;
import org.xml.sax.SAXException;

import javax.ws.rs.*;
import java.io.IOException;
import java.io.StringReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

/**
 * Created by savannaholson on 3/8/16.
 */
// The Java class will be hosted at the URI path "/webservice"
@Path("/webService")
public class Bookworm {
    private final Logger log = Logger.getLogger(this.getClass());

    /**
     * This method takes the author's first and last names and uses them to return books by the author in JSON format
     *
     * @param authorFirst the first name of the author
     * @param authorLast the last name of the author
     * @return A string of json data that was retrived based on the first and last name provided, containing all of the
     * goodreads api information returned.
     */
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
            xml = apiRequest.getBooksByAuthorName(authorFirst, authorLast);
        } catch (UnknownHostException e) {
            log.error(e);
            return "www.goodreads.com is currently unavailable, please try again later.";
        } catch (IOException e) {
            log.error(e);
            return "Author with first name: " + authorFirst + " and last name: " + authorLast + " could not be found.";
        } catch (SAXException e) {
            log.error(e);
            return e.toString();
        }


        //Nancy's Code
        GoodreadsResponseType books = null;
        try {
            books = unmarshalGoodreadsXML(xml);
        } catch (JAXBException e) {
            log.error(e);
            return e.toString();
        }

        //Savannah's Code
        String json = convertToJSON(books);

        return json;
    }

    /**
     * This method takes xml representing goodreads objects and converts it into POJOs
     *
     * @param xml The xml to be unmarshalled
     * @return a pojo representing the data from the xml
     * @exception JAXBException
     */
    public GoodreadsResponseType unmarshalGoodreadsXML(String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(GoodreadsResponseType.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringBuffer xmlStr = new StringBuffer(xml);
        GoodreadsResponseType books = (GoodreadsResponseType) unmarshaller.unmarshal(new StreamSource(new StringReader(xmlStr.toString())));

        return books;
    }

    /**
     * This method takes any object and converts it into JSON
     *
     * @param object the object to be converted into JSON
     * @return a string of JSON representing the object passed in
     */
    public String convertToJSON(Object object) {

        ObjectMapper mapper = new ObjectMapper();
        String json = "";


        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error(e);
            return "Error with response from www.goodreads.com";
        }

        return json;
    }

}

