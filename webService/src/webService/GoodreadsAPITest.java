package webService;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by Alex on 4/13/2016.
 */
public class GoodreadsAPITest {
    private String xml;
    private GoodreadsAPI api;
    @Before
    public void setUp() throws Exception {
        api = new GoodreadsAPI();
    }

    @Test
    public void getAuthorId() throws Exception {
        xml = "<GoodreadsResponse><Request><authentication>true</authentication><key>FCu2HvScdASGklfD1GmDBg</key><method>api_author_link</method></Request><author id=\"14463184\"><name>Joe   Smith</name><link>https://www.goodreads.com/author/show/14463184.Joe_Smith?utm_medium=api&amp;tm_source=author_link</link></author></GoodreadsResponse>";
        String authorId = api.getAuthorId(xml);
        assertTrue(authorId.equals("14463184"));
    }

    @Test
    public void getAuthorIdFail() throws Exception {
        xml = "<GoodreadsResponse><Request><authentication>true</authentication><key>FCu2HvScdASGklfD1GmDBg</key><method>api_author_link</method></Request></GoodreadsResponse>";
        String authorId = api.getAuthorId(xml);
        assertTrue(authorId.length() == 0);
    }


    @Test
    public void getXmlFromGoodreadsForAuthorInfo() throws Exception {
        String authorId = "14463184";
        String authorName = "joe%20smith";
        String goodreadsXml = api.getXmlFromGoodreads(authorName, "author");

        String goodreadsAuthorId = api.getAuthorId(goodreadsXml);

        assertTrue(goodreadsAuthorId.equals(authorId));
    }

    @Test
    public void getXmlFromGoodreadsForAuthorInfoFail() throws Exception {
        String authorName = "ppppppppppppppp";
        String goodreadsXml = api.getXmlFromGoodreads(authorName, "author");
        String goodreadsAuthorId = api.getAuthorId(goodreadsXml);

        assertTrue(goodreadsAuthorId.length() == 0);
    }

    @Test
    public void getXmlFromGoodreadsForAuthorBooks() throws Exception {
        String authorId = "14463184";
        String goodreadsXml = api.getXmlFromGoodreads(authorId, "books");

        assertFalse(goodreadsXml.equals(""));

    }

    @Test
    public void getXmlFromGoodreadsForAuthorBooksFail() throws Exception {
        String authorId = "14463dasf";
        boolean badURL = false;
        try {
            String goodreadsXml = api.getXmlFromGoodreads(authorId, "books");
        } catch (FileNotFoundException ex) {

            badURL = true;
        }
        assertTrue(badURL);

    }





}