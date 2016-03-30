package webService;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.ws.WebServiceException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Student on 3/30/2016.
 */
public class GoodreadsAPI {

    private final static URL SERVICE_URL;

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://www.goodreads.com/");
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }
        SERVICE_URL = url;
    }

    private String getAuthorId(String name) throws IOException, SAXException{

        URL authorInfo = null;
        try {
            authorInfo = new URL(SERVICE_URL + "api/author_url/" + name + "?key=FCu2HvScdASGklfD1GmDBg");
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }

        InputStream in = authorInfo.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        String xml = "";
        while (reader.ready()) {
            line = reader.readLine();
            xml += line;
            //System.out.println(line);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        String authorId = "";
        try
        {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            authorId = document.getElementsByTagName("author").item(0).getAttributes().item(0).getNodeValue();

        } catch (Exception e) {
            System.out.println(e);
        }

        return authorId;
    }


    public String getBooksByAuthorName(String author) throws IOException, SAXException {
        String id = getAuthorId(author);

        URL authorBooks = null;
        try {

            //https://www.goodreads.com/author/list/14463184?format=xml&key=FCu2HvScdASGklfD1GmDBg
            //https://www.goodreads.com/author/list/18541?format=xml?key=FCu2HvScdASGklfD1GmDBg
            //https://www.goodreads.com/author/list/18541?format=xml&key=FCu2HvScdASGklfD1GmDBg

            authorBooks = new URL(SERVICE_URL + "author/list/" + id + "?format=xml&key=FCu2HvScdASGklfD1GmDBg");
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        }


        InputStream in = authorBooks.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        String xml = "";
        while (reader.ready()) {
            line = reader.readLine();
            xml += line;
            System.out.println(line);
        }

        return xml;
    }
}