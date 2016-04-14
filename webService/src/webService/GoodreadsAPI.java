package webService;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.WebServiceException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Alex Drousth on 3/30/2016.
 */
public class GoodreadsAPI {
    private final Logger log = Logger.getLogger(this.getClass());

    private final static String SERVICE_URL = "https://www.goodreads.com/";
    private final static String API_KEY = "?key=FCu2HvScdASGklfD1GmDBg";
    private final static String AUTHOR_INFO_URL = "api/author_url/";
    private final static String AUTHOR_BOOK_URL = "author/list/";


    /**
     * takes author info xml from goodreads and returns their id
     *
     * @param xml the XMl to extract the author id from
     * @return a string containing the author's goodreads id
     * @exception IOException
     * @exception SAXException
     */
    public String getAuthorId(String xml) throws IOException, SAXException{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        String authorId = "";
        try
        {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            authorId = document.getElementsByTagName("author").item(0).getAttributes().item(0).getNodeValue();

        } catch (IOException e) {
            log.error(e);
            throw e;
        } catch (SAXException e) {
            log.error(e);
            throw e;
        } catch (Exception e) {
            log.error(e);
        }

        return authorId;
    }

    /**
     * takes author info xml from goodreads and returns their id
     *
     * @param param The string to be used in the URL to goodreads api.
     * @param type The type of api request being made, either author or books.
     * @return String containing the XML from goodreads
     * @exception IOException
     */
    public String getXmlFromGoodreads(String param, String type) throws IOException {
        URL goodreadsUrl = null;

        try {
            if (type == "author") {
                goodreadsUrl = new URL(SERVICE_URL + AUTHOR_INFO_URL + param + API_KEY);
            } else if (type == "books") {
                goodreadsUrl = new URL(SERVICE_URL + AUTHOR_BOOK_URL + param + API_KEY);
            }
        } catch (MalformedURLException ex) {
            log.error(ex);
            return "";
        }

        InputStream in = null;
        BufferedReader reader = null;
        String xml = "";

        try {
            in =  goodreadsUrl.openStream();
            reader = new BufferedReader(new InputStreamReader(in));

            String line = null;


            while ((line = reader.readLine()) != null) {
                xml += line;
                //System.out.println(line);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (reader != null) {
                reader.close();
            }
        }


        return xml;
    }


    /**
     * gets XML from goodreads containing information for up to 30 books by an author
     *
     * @param firstName The author's first name.
     * @param lastName The author's last name.
     * @return String containing the XML from goodreads
     * @exception IOException
     * @exception SAXException
     */
    public String getBooksByAuthorName(String firstName, String lastName) throws IOException, SAXException {
        String author;
        if (firstName.length() == 0 || lastName.length() == 0) {
            author = firstName + lastName;
        } else {
            author = firstName + "%20" + lastName;
        }
        String info = getXmlFromGoodreads(author, "author");
        String id = getAuthorId(info);


        String xml = getXmlFromGoodreads(id, "books");

        return xml;
    }

}
