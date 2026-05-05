package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the comparator
 * 
 * @author Sajni
 * @version 15 Nov 2023
 * 
 * @author Tarini Duvvuri (tarinid)
 * @version 18 Nov 2023
 */
public class ComparatorTest extends TestCase {
    private Influencer influencer1;
    private Influencer influencer2;

    private ComparatorName name;
    private ComparatorERTraditional trad;
    private ComparatorERReach reach;

    /**
     * Sets up the test environment before each test method is executed.
     * Initializes the test data and objects needed for testing.
     */
    public void setUp() {
        String username = "Ausername";
        String chanName = "Achan";

        // totalLikes, totalPosts,totalFollowers, totalComments, totalViews
        influencer1 = new Influencer(username, chanName);
        // ERTrad = 20
        // ERReach = 20

        String username1 = "Busername";
        String chanName1 = "Bchan";

        influencer2 = new Influencer(username1, chanName1);
        // totalLikes, totalPosts,totalFollowers, totalComments, totalViews
        // ERTrad = 3
        // ERReach = 1.5

        name = new ComparatorName();
        trad = new ComparatorERTraditional();
        reach = new ComparatorERReach();

    }


    // ----------------------------------------------------------
    /**
     * Tests the ComparatorName Object
     * when a channelName is equal, negative, positive
     * 
     */
    public void testComparatorName() {

        // channel names are equal
        assertEquals(0, name.compare(influencer1, influencer1));

        // negative left comes before right
        assertFalse(name.compare(influencer1, influencer2) > 0);

        // positive left comes after right
        assertFalse(name.compare(influencer2, influencer1) < 0);

    }


    // ----------------------------------------------------------
    /**
     * Tests the ComparatorTraditional Object
     * when a username is equal, negative, positive
     * 
     */
    public void testComparatorERTraditional() {

        // engagement rates are equal
        assertEquals(0, trad.compare(20.0, 20.0));

        // negative left is lower than right
        assertFalse(trad.compare(20.0, 3.0) < 0);

        // positive left is higher than right
        assertFalse(trad.compare(3.0, 20.0) > 0);
    }


    /**
     * Tests the ComparatorERReach object when a username is equal, negative,
     * positive.
     */
    public void testComparatorERReach() {
        // engagement rates are equal
        assertEquals(0, reach.compare(20.0, 20.0));

        // negative left is lower than right
        assertTrue(reach.compare(1.5, 20.0) < 0);

        // positive left is higher than right
        assertTrue(reach.compare(20.0, 1.5) > 0);
    }

}
