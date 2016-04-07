package webService;

import com.fasterxml.jackson.core.JsonProcessingException;
import entities.GoodreadsResponseType;
import org.xml.sax.SAXException;

import javax.ws.rs.*;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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

        //Nancy's Code
        GoodreadsResponseType books = unmarshalGoodreadsXML(xml);


        //Savannah's Code
        String json = convertToJSON(books);

        return json;
    }

    private GoodreadsResponseType unmarshalGoodreadsXML(String xml) {

        GoodreadsResponseType books = null;

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(GoodreadsResponseType.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringBuffer xmlStr = new StringBuffer(xml);
            books = (GoodreadsResponseType) unmarshaller.unmarshal(new StreamSource(new StringReader(xmlStr.toString()) ) );

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return books;
    }

    private String convertToJSON(Object object) {

        ObjectMapper mapper = new ObjectMapper();
        String json = "";


        try {
            json = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

}

