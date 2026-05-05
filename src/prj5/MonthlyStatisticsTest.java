package prj5;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for the {@link MonthlyStatistics} class.
 *
 * @author Tarini Duvvuri (tarinid)
 * @version 14 Nov 2023
 */
public class MonthlyStatisticsTest
{

    /**
     * Tests the equality of two MonthlyStatistics objects with the same values.
     */
    @Test
    public void testEquals()
    {
        // Create two MonthlyStatistics objects with the same values
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);

        // Test if they are equal
        assertEquals(stats1, stats2);
    }


    /**
     * Tests the inequality of two MonthlyStatistics objects with different
     * values.
     */
    @Test
    public void testNotEquals()
    {
        // Create two MonthlyStatistics objects with different values
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.FEBRUARY,
            "Canada",
            "Travel",
            200,
            10000,
            20,
            20000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);

        // Test if they are not equal
        assertNotEquals(stats1, stats2);
    }


    /**
     * Tests the {@link MonthlyStatistics#toString()} method.
     */
    @Test
    public void testToString()
    {
        // Create a MonthlyStatistics object
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.MARCH,
            "Germany",
            "Food",
            150,
            8000,
            30,
            15000);

        // Test the toString method
        assertEquals(
            "Social Media Post: Food, Country: Germany, Month: MARCH, "
                + "Followers: 8000, Views: 15000, Likes: 150, Comments: 30",
            stats.toString());
    }


    /**
     * Tests the equality of a MonthlyStatistics object with a null object.
     */
    @Test
    public void testEqualsWithNullObject()
    {
        // Create a MonthlyStatistics object
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);

        // Test with null object
        assertNotEquals(stats, null);
    }


    /**
     * Tests the equality of a MonthlyStatistics object with an object of a
     * different class.
     */
    @Test
    public void testEqualsWithDifferentClass()
    {
        // Create a MonthlyStatistics object
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);

        // Test with an object of a different class
        assertNotEquals(stats, "This is not a MonthlyStatistics object");
    }


    /**
     * Tests the equality of two MonthlyStatistics objects with different
     * months.
     */
    @Test
    public void testEqualsWithDifferentMonth()
    {
        // Create two MonthlyStatistics objects with different months
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.FEBRUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);

        // Test if they are not equal
        assertNotEquals(stats1, stats2);
    }


    /**
     * Tests the equality of two MonthlyStatistics objects with different
     * countries.
     */
    @Test
    public void testEqualsWithDifferentCountry()
    {
        // Create two MonthlyStatistics objects with different countries
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "Canada",
            "Fashion",
            100,
            5000,
            50,
            10000);

        // Test if they are not equal
        assertNotEquals(stats1, stats2);
    }


    /**
     * Tests the equality of two MonthlyStatistics objects with different main
     * topics.
     */
    @Test
    public void testEqualsWithDifferentMainTopic()
    {
        // Create two MonthlyStatistics objects with different main topics
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Travel",
            100,
            5000,
            50,
            10000);

        // Test if they are not equal
        assertNotEquals(stats1, stats2);
    }


    /**
     * Tests the equality of two MonthlyStatistics objects with different likes.
     */
    @Test
    public void testEqualsWithDifferentLikes()
    {
        // Create two MonthlyStatistics objects with different likes
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            200,
            5000,
            50,
            10000);

        // Test if they are not equal
        assertNotEquals(stats1, stats2);
    }


    /**
     * Tests the equality of two MonthlyStatistics objects with different
     * followers.
     */
    @Test
    public void testEqualsWithDifferentFollowers()
    {
        // Create two MonthlyStatistics objects with different followers
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            6000,
            50,
            10000);

        // Test if they are not equal
        assertNotEquals(stats1, stats2);
    }


    /**
     * Tests the equality of a MonthlyStatistics object with itself.
     */
    @Test
    public void testEqualsWithSameObject()
    {
        // Create a MonthlyStatistics object
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);

        // Test if the object is equal to itself
        assertEquals(stats, stats);
    }


    /**
     * Tests the equality of two MonthlyStatistics objects with different
     * comments.
     */
    @Test
    public void testEqualsWithDifferentComments()
    {
        // Create two MonthlyStatistics objects with different comments
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            60,
            10000);

        // Test if they are not equal
        assertNotEquals(stats1, stats2);
    }


    /**
     * Tests the equality of two MonthlyStatistics objects with different views.
     */
    @Test
    public void testEqualsWithDifferentViews()
    {
        // Create two MonthlyStatistics objects with different views
        MonthlyStatistics stats1 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);
        MonthlyStatistics stats2 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            20000);

        // Test if they are not equal
        assertNotEquals(stats1, stats2);
    }


    /**
     * Tests the setters and getters of the MonthlyStatistics class.
     */
    @Test
    public void testSettersAndGetters()
    {
        // Create a MonthlyStatistics object
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "France",
            "Technology",
            120,
            6000,
            40,
            12000);

        // Test getters
        assertEquals(MonthEnum.JANUARY, stats.getMonth());
        assertEquals("France", stats.getCountry());
        assertEquals("Technology", stats.getMainTopic());
        assertEquals(120, stats.getLikes());
        assertEquals(6000, stats.getFollowers());
        assertEquals(40, stats.getComments());
        assertEquals(12000, stats.getViews());

        // Test setters
        stats.setMonth(MonthEnum.FEBRUARY);
        stats.setMainTopic("Science");
        stats.setLikes(130);
        stats.setFollowers(7000);
        stats.setComments(50);
        stats.setViews(13000);

        assertEquals(MonthEnum.FEBRUARY, stats.getMonth());
        assertEquals("Science", stats.getMainTopic());
        assertEquals(130, stats.getLikes());
        assertEquals(7000, stats.getFollowers());
        assertEquals(50, stats.getComments());
        assertEquals(13000, stats.getViews());
    }


    /**
     * Unit test for the getTraditionalEngagementRate method in the
     * MonthlyStatistics class with non-zero followers.
     */
    @Test
    public void testTraditionalEngagementRateWithNonZeroFollowers()
    {
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);

        double traditionalEngagementRate = stats.getTraditionalEngagementRate();

        assertEquals(3.0, traditionalEngagementRate, 0.01);
    }


    /**
     * Unit test for the getTraditionalEngagementRate method in the
     * MonthlyStatistics class with zero followers.
     */
    @Test
    public void testTraditionalEngagementRateWithZeroFollowers()
    {
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            0,
            50,
            10000);

        double traditionalEngagementRate = stats.getTraditionalEngagementRate();

        assertEquals(Double.NEGATIVE_INFINITY, traditionalEngagementRate, 0.01);
    }


    /**
     * Unit test for the getReachEngagementRate method in the MonthlyStatistics
     * class with non-zero views.
     */
    @Test
    public void testReachEngagementRateWithNonZeroViews()
    {
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            10000);

        double reachEngagementRate = stats.getReachEngagementRate();

        assertEquals(1.5, reachEngagementRate, 0.01);
    }


    /**
     * Unit test for the getReachEngagementRate method in the MonthlyStatistics
     * class with zero views.
     */
    @Test
    public void testReachEngagementRateWithZeroViews()
    {
        MonthlyStatistics stats = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "USA",
            "Fashion",
            100,
            5000,
            50,
            0);

        double reachEngagementRate = stats.getReachEngagementRate();

        assertEquals(Double.NEGATIVE_INFINITY, reachEngagementRate, 0.01);
    }
}
