package webService;

import entities.GoodreadsResponseType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alex on 4/13/2016.
 */
public class BookwormTest {
    private Bookworm worms;
    @Before
    public void setUp() throws Exception {
        worms = new Bookworm();
    }

    @Test
    public void getRecomendationWithTitleAndAuthor() throws Exception {
        String json = worms.getRecomendationWithTitleAndAuthor("joe", "smith");
        assertTrue(json.equals("{\"request\":{\"authentication\":\"true\",\"key\":\"FCu2HvScdASGklfD1GmDBg\",\"method\":\"author_list\"},\"author\":{\"id\":\"14463184\",\"name\":\"Joe   Smith\",\"role\":null,\"imageUrl\":null,\"smallImageUrl\":null,\"link\":\"https://www.goodreads.com/author/show/14463184.Joe_Smith\",\"averageRating\":null,\"ratingsCount\":null,\"textReviewsCount\":null,\"books\":{\"book\":[{\"id\":{\"value\":\"1110882\",\"type\":\"integer\"},\"isbn\":\"044651232X\",\"isbn13\":\"9780446512329\",\"textReviewsCount\":{\"value\":\"3\",\"type\":\"integer\"},\"title\":\"Off The Record: An Oral History Of Popular Music\",\"imageUrl\":\"https://d.gr-assets.com/books/1371827129m/1110882.jpg\",\"smallImageUrl\":\"https://d.gr-assets.com/books/1371827129s/1110882.jpg\",\"largeImageUrl\":\"\",\"link\":\"https://www.goodreads.com/book/show/1110882.Off_The_Record\",\"numPages\":\"429\",\"format\":\"Hardcover\",\"editionInformation\":\"\",\"publisher\":\"Warner Books\",\"publicationDay\":\"\",\"publicationYear\":\"1988\",\"publicationMonth\":\"\",\"averageRating\":\"3.71\",\"ratingsCount\":\"21\",\"description\":\"Stories told to Joe Smith ; edited by Mitchell Fink.\",\"authors\":{\"author\":{\"id\":\"14463184\",\"name\":\"Joe   Smith\",\"role\":\"\",\"imageUrl\":{\"value\":\"https://s.gr-assets.com/assets/nophoto/user/u_200x266-e183445fd1a1b5cc7075bb1cf7043306.png\",\"nophoto\":\"true\"},\"smallImageUrl\":{\"value\":\"https://s.gr-assets.com/assets/nophoto/user/u_50x66-632230dc9882b4352d753eedf9396530.png\",\"nophoto\":\"true\"},\"link\":\"https://www.goodreads.com/author/show/14463184.Joe_Smith\",\"averageRating\":\"3.71\",\"ratingsCount\":\"21\",\"textReviewsCount\":\"5\",\"books\":null}},\"published\":\"1988\"}],\"start\":\"1\",\"end\":\"1\",\"total\":\"1\"}}}"));
    }

    @Test
    public void getRecomendationWithTitleAndAuthorFail() throws Exception {
        String json = worms.getRecomendationWithTitleAndAuthor("ppppppppppppp", "");
        System.out.println(json);
        assertTrue(json.equals("Author: ppppppppppppp  could not be found."));
    }

    @Test
    public void unmarshalGoodreadsXML() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<GoodreadsResponse>\n" +
                "  <Request>\n" +
                "    <authentication>true</authentication>\n" +
                "      <key><![CDATA[FCu2HvScdASGklfD1GmDBg]]></key>\n" +
                "    <method><![CDATA[author_list]]></method>\n" +
                "  </Request>\n" +
                "  <author>\n" +
                "  <id>14463184</id>\n" +
                "  <name>Joe   Smith</name>\n" +
                "  <link><![CDATA[https://www.goodreads.com/author/show/14463184.Joe_Smith]]></link>\n" +
                "  <books start=\"1\" end=\"1\" total=\"1\">\n" +
                "    <book>\n" +
                "  <id type=\"integer\">1110882</id>\n" +
                "  <isbn>044651232X</isbn>\n" +
                "  <isbn13>9780446512329</isbn13>\n" +
                "  <text_reviews_count type=\"integer\">3</text_reviews_count>\n" +
                "  <title>Off The Record: An Oral History Of Popular Music</title>\n" +
                "  <image_url>https://d.gr-assets.com/books/1371827129m/1110882.jpg</image_url>\n" +
                "  <small_image_url>https://d.gr-assets.com/books/1371827129s/1110882.jpg</small_image_url>\n" +
                "  <large_image_url/>\n" +
                "  <link>https://www.goodreads.com/book/show/1110882.Off_The_Record</link>\n" +
                "  <num_pages>429</num_pages>\n" +
                "  <format>Hardcover</format>\n" +
                "  <edition_information/>\n" +
                "  <publisher>Warner Books</publisher>\n" +
                "  <publication_day/>\n" +
                "  <publication_year>1988</publication_year>\n" +
                "  <publication_month/>\n" +
                "  <average_rating>3.71</average_rating>\n" +
                "  <ratings_count>21</ratings_count>\n" +
                "  <description>Stories told to Joe Smith ; edited by Mitchell Fink.</description>\n" +
                "<authors>\n" +
                "<author>\n" +
                "<id>14463184</id>\n" +
                "<name>Joe   Smith</name>\n" +
                "<role></role>\n" +
                "<image_url nophoto='true'>\n" +
                "<![CDATA[https://s.gr-assets.com/assets/nophoto/user/u_200x266-e183445fd1a1b5cc7075bb1cf7043306.png]]>\n" +
                "</image_url>\n" +
                "<small_image_url nophoto='true'>\n" +
                "<![CDATA[https://s.gr-assets.com/assets/nophoto/user/u_50x66-632230dc9882b4352d753eedf9396530.png]]>\n" +
                "</small_image_url>\n" +
                "<link><![CDATA[https://www.goodreads.com/author/show/14463184.Joe_Smith]]></link>\n" +
                "<average_rating>3.71</average_rating>\n" +
                "<ratings_count>21</ratings_count>\n" +
                "<text_reviews_count>5</text_reviews_count>\n" +
                "</author>\n" +
                "</authors>\n" +
                "  <published>1988</published>\n" +
                "</book>\n" +
                "\n" +
                "  </books>\n" +
                "</author>\n" +
                "\n" +
                "</GoodreadsResponse>";
        GoodreadsResponseType response = worms.unmarshalGoodreadsXML(xml);

        assertTrue(response != null);
    }

    @Test
    public void unmarshalGoodreadsXMLFail() throws Exception {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<GoodreadsResponse>\n" +
                "  <Request>\n" +
                "    <authentication>true</authentication>\n" +
                "      <key><![CDATA[FCu2HvScdASGklfD1GmDBg]]></key>\n" +
                "    <method><![CDATA[author_list]]></method>\n" +
                "  </Request>\n" +
                "  <author>\n" +
                "  <id>14463184</id>\n" +
                "  <name>Joe   Smith</name>\n" +
                "  <link><![CDATA[https://www.goodreads.com/author/show/14463184.Joe_Smith]]></link>\n" +
                "  <books start=\"1\" end=\"1\" total=\"1\">\n" +
                "    <book>\n" +
                "  <id type=\"integer\">1110882</id>\n" +
                "  <isbn>044651232X</isbn>\n" +
                "  <isbn13>9780446512329</isbn13>\n" +
                "  <text_reviews_count type=\"integer\">3</text_reviews_count>\n" +
                "  <title>Off The Record: An Oral History Of Popular Music</title>\n" +
                "  <image_url>https://d.gr-assets.com/books/1371827129m/1110882.jpg</image_url>\n" +
                "  <small_image_url>https://d.gr-assets.com/books/1371827129s/1110882.jpg</small_image_url>\n" +
                "  <large_image_url/>\n" +
                "  <link>https://www.goodreads.com/book/show/1110882.Off_The_Record</link>\n" +
                "  <num_pages>429</num_pages>\n" +
                "  <format>Hardcover</format>\n" +
                "  <edition_information/>\n";
        GoodreadsResponseType response = null;
        try {
            response = worms.unmarshalGoodreadsXML(xml);
        } catch (Exception e) {

        }


        assertTrue(response == null);

    }

}