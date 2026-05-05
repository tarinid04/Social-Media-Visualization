package prj5;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

/**
 * Test class for Influencer.
 *
 * @author Tarini Duvvuri (tarinid)
 * @version 15 Nov 2023
 */
public class InfluencerTest
{

    /**
     * Tests the constructor and getters of the Influencer class.
     */
    @Test
    public void testConstructorAndGetters()
    {
        // Create an Influencer object
        Influencer influencer = new Influencer("JohnDoe", "FashionChannel");

        // Test getters
        assertEquals("JohnDoe", influencer.getUserName());
        assertEquals("FashionChannel", influencer.getChannelName());

        // Check if the monthlyStats list is initialized
        assertNotNull(influencer.getPosts());
    }


    /**
     * Tests the addData method of the Influencer class.
     */
    @Test
    public void testAddData()
    {
        // Create an Influencer object
        Influencer influencer = new Influencer("JaneSmith", "TravelChannel");

        // Create a MonthlyStatistics object
        MonthlyStatistics monthlyStat = new MonthlyStatistics(
            MonthEnum.MARCH,
            "USA",
            "Adventure",
            200,
            8000,
            30,
            15000);

        // Add the MonthlyStatistics object to the Influencer's list
        influencer.addData(monthlyStat);

        // Check if the MonthlyStatistics object is added to the list
        List<MonthlyStatistics> posts = influencer.getPosts();
        assertEquals(1, posts.size());
        assertEquals(monthlyStat, posts.get(0));
    }


    /**
     * Unit tests for the compareTo method in the Influencer class.
     */
    @Test
    public void testCompareTo()
    {
        // Create influencer objects
        Influencer influencer1 = new Influencer("JohnDoe", "FashionChannel");
        Influencer influencer2 = new Influencer("JaneSmith", "TravelChannel");
        Influencer influencer3 = new Influencer("BobJohnson", "FashionChannel");

        // Test compareTo
        assertTrue(influencer1.compareTo(influencer2) < 0);
        assertTrue(influencer2.compareTo(influencer1) > 0);
        assertEquals(0, influencer1.compareTo(influencer3));
    }


    /**
     * Unit tests for the equals method in the Influencer class when comparing
     * the same object.
     */
    @Test
    public void testEqualsSameObject()
    {
        Influencer influencer = new Influencer("JohnDoe", "FashionChannel");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        assertTrue(influencer.equals(influencer));
    }


    /**
     * Unit tests for the equals method in the Influencer class when comparing
     * different objects.
     */
    @Test
    public void testEqualsDifferentObject()
    {
        Influencer influencer1 = new Influencer("JohnDoe", "FashionChannel");
        influencer1.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        Influencer influencer2 = new Influencer("JaneSmith", "TravelChannel");
        influencer2.addData(
            new MonthlyStatistics(
                MonthEnum.FEBRUARY,
                "Canada",
                "Travel",
                200,
                10000,
                20,
                20000));

        assertFalse(influencer1.equals(influencer2));
    }


    /**
     * Unit tests for the equals method in the Influencer class when comparing
     * with a null object.
     */
    @Test
    public void testEqualsNullObject()
    {
        Influencer influencer = new Influencer("JohnDoe", "FashionChannel");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        assertFalse(influencer.equals(null));
    }


    /**
     * Unit tests for the equals method in the Influencer class when comparing
     * with a different class object.
     */
    @SuppressWarnings("unlikely-arg-type")
    @Test
    public void testEqualsDifferentClass()
    {
        Influencer influencer = new Influencer("JohnDoe", "FashionChannel");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        assertFalse(influencer.equals("This is not an Influencer object"));
    }


    /**
     * Unit tests for the equals method in the Influencer class when comparing
     * objects with the same attributes.
     */
    @Test
    public void testEqualsSameAttributes()
    {
        Influencer influencer1 = new Influencer("JohnDoe", "FashionChannel");
        influencer1.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        Influencer influencer2 = new Influencer("JohnDoe", "FashionChannel");
        influencer2.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        assertTrue(influencer1.equals(influencer2));
    }


    /**
     * Unit tests for the equals method in the Influencer class when comparing
     * objects with different channel names.
     */
    @Test
    public void testEqualsDifferentChannelName()
    {
        Influencer influencer1 = new Influencer("JohnDoe", "FashionChannel");
        influencer1.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        Influencer influencer2 = new Influencer("JohnDoe", "TravelChannel");
        influencer2.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        assertFalse(influencer1.equals(influencer2));
    }


    /**
     * Unit tests for the equals method in the Influencer class when comparing
     * objects with different usernames.
     */
    @Test
    public void testEqualsDifferentUserName()
    {
        Influencer influencer1 = new Influencer("JohnDoe", "FashionChannel");
        influencer1.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        Influencer influencer2 = new Influencer("JaneSmith", "FashionChannel");
        influencer2.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        assertFalse(influencer1.equals(influencer2));
    }


    /**
     * Unit tests for the equals method in the Influencer class when comparing
     * objects with different posts.
     */
    @Test
    public void testEqualsDifferentPosts()
    {
        Influencer influencer1 = new Influencer("JohnDoe", "FashionChannel");
        influencer1.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "USA",
                "Fashion",
                100,
                5000,
                50,
                10000));

        Influencer influencer2 = new Influencer("JohnDoe", "FashionChannel");
        influencer2.addData(
            new MonthlyStatistics(
                MonthEnum.FEBRUARY,
                "Canada",
                "Travel",
                200,
                10000,
                20,
                20000));

        assertFalse(influencer1.equals(influencer2));
    }


    /**
     * Test getTradEngRateByMonth
     */
    public void testTradEngRateByMonth()
    {
        Influencer influencer0 = new Influencer("actionDan", "wizard");

        // Test with specific month
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer0.getTradEngRateByMonth(MonthEnum.MARCH),
            0.02);

        // Test with DEFAULT
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer0.getTradEngRateByMonth(MonthEnum.DEFAULT),
            0.02);

        // Test with null
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer0.getTradEngRateByMonth(null),
            0.02);

        // Test with a different influencer
        influencer0 = new Influencer("A", "B");
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer0.getTradEngRateByMonth(MonthEnum.DEFAULT),
            0.02);
    }


    /**
     * Test getReachEngRateByMonth
     */
    public void testReachEngRateByMonth()
    {
        Influencer influencer0 = new Influencer("actionDan", "wizard");

        // Test with specific month
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer0.getReachEngRateByMonth(MonthEnum.MARCH),
            0.02);

        // Test with DEFAULT
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer0.getReachEngRateByMonth(MonthEnum.DEFAULT),
            0.02);

        // Test with null
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer0.getReachEngRateByMonth(null),
            0.02);

        // Test with a different influencer
        influencer0 = new Influencer("A", "B");
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer0.getReachEngRateByMonth(MonthEnum.DEFAULT),
            0.02);
    }


    /**
     * Test when month is null
     */
    public void testNullMonth()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                40));

        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.getTradEngRateByMonth(null),
            0.01);
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.getReachEngRateByMonth(null),
            0.01);
    }


    /**
     * Test when month is MonthEnum.DEFAULT
     */
    public void testDefaultMonth()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                40));

        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.getTradEngRateByMonth(MonthEnum.DEFAULT),
            0.01);
        assertEquals(
            100.0,
            influencer.getReachEngRateByMonth(MonthEnum.DEFAULT),
            0.01);
    }


    /**
     * Test when month matches a specific month
     */
    public void testSpecificMonth()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                40));

        assertEquals(
            200.0,
            influencer.getTradEngRateByMonth(MonthEnum.JANUARY),
            0.01);
        assertEquals(
            100.0,
            influencer.getReachEngRateByMonth(MonthEnum.JANUARY),
            0.01);
    }


    /**
     * Test when followers are zero
     */
    public void testZeroFollowers()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                0));

        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.tradEngRateQuarterly(),
            0.01);
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.reachEngRateQuarterly(),
            0.01);
    }


    /**
     * Test when followers are non-zero
     */
    public void testNonZeroFollowers()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                40));

        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.tradEngRateQuarterly(),
            0.01);
        assertEquals(100.0, influencer.reachEngRateQuarterly(), 0.01);
    }


    /**
     * Test when all monthly statistics are DEFAULT
     */
    public void testAllDefaultMonths()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.DEFAULT,
                "country",
                "content",
                0,
                0,
                0,
                0));

        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.tradEngRateQuarterly(),
            0.01);
        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.reachEngRateQuarterly(),
            0.01);
    }


    /**
     * Test when there are multiple months with non-DEFAULT values
     */
    public void testMultipleNonDefaultMonths()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                40));
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.FEBRUARY,
                "country",
                "content",
                5,
                10,
                15,
                20));

        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.tradEngRateQuarterly(),
            0.01);
        assertEquals(100.0, influencer.reachEngRateQuarterly(), 0.01);
    }


    /**
     * Test when followers are zero for all months except March
     */
    public void testZeroFollowersExceptMarch()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                0));
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.FEBRUARY,
                "country",
                "content",
                5,
                10,
                15,
                0));
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.MARCH,
                "country",
                "content",
                8,
                15,
                25,
                40));

        assertEquals(620.0, influencer.tradEngRateQuarterly(), 0.01);
    }


    /**
     * Test when followers are zero for all months, including March
     */
    public void testZeroFollowersAllMonths()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                0));
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.FEBRUARY,
                "country",
                "content",
                5,
                10,
                15,
                0));
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.MARCH,
                "country",
                "content",
                0,
                0,
                0,
                0));

        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.tradEngRateQuarterly(),
            0.01);
    }


    /**
     * Test when followers are zero only for March
     */
    public void testZeroFollowersMarchOnly()
    {
        Influencer influencer = new Influencer("username", "channelName");
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.JANUARY,
                "country",
                "content",
                10,
                20,
                30,
                50));
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.FEBRUARY,
                "country",
                "content",
                5,
                10,
                15,
                30));
        influencer.addData(
            new MonthlyStatistics(
                MonthEnum.MARCH,
                "country",
                "content",
                0,
                0,
                0,
                0));

        assertEquals(
            Double.NEGATIVE_INFINITY,
            influencer.tradEngRateQuarterly(),
            0.01);
    }

}
