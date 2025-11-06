import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    private ArrayList<Comment> comments;
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
        comments = new ArrayList<>();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(false, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(false, salesIte1.addComment("Jamies Duckling", "This book is great. I perform brain surgery every week now.", 6));
        assertEquals(false, salesIte1.addComment("Jamas Duckling", "This book awful.", 0));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
    

    @Test
    public void findMostHelpfulComment()
    {
        SalesItem salesIte1 = new SalesItem("programming for Dummies", 1530);
        assertEquals(true, salesIte1.addComment("Alex Laurin", "its helpful", 4));
        salesIte1.upvoteComment(0);
        assertEquals(true, salesIte1.addComment("Laurin Alex", "I did not learn alot", 2));
        assertEquals(salesIte1.getComment().get(0), salesIte1.findMostHelpfulComment());
    }

    @Test
    public void testRemoveComment()
    {
        SalesItem salesIte1 = new SalesItem("test", 10);
        assertEquals(true, salesIte1.addComment("testAuthor", "description", 3));
        salesIte1.removeComment(0);
        salesIte1.removeComment(-1);
    }

    @Test
    public void testShowInfo()
    {
        SalesItem salesIte1 = new SalesItem("test", 10);
        salesIte1.showInfo();
        assertEquals(true, salesIte1.addComment("testAuthor", "description", 3));
        salesIte1.showInfo();
        salesIte1.upvoteComment(0);
        assertEquals(true, salesIte1.addComment("testAuthor2", "description2", 3));
        salesIte1.showInfo();
    }
}



