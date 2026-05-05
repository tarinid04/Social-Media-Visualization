package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test class for DoublyLinkedList. * @author garim
 *
 * @version Nov 15, 2023
 * @author jackgartman04
 * @version Nov 18, 2023
 * @author tarinid
 * @version Nov 18, 2023
 */
public class DoublyLinkedListTest
    extends student.TestCase
{

    private DoublyLinkedList<Influencer> list;

    /**
     * Sets up the test fixture.
     */
    @Override
    public void setUp()
    {
        list = new DoublyLinkedList<>();
    }


    /**
     * Tests the add method.
     */
    public void testAdd()
    {
        assertTrue(list.add(new Influencer("1", "A")));
        assertEquals(1, list.getCurrentSize());
        assertTrue(list.add(new Influencer("2", "B")));
        assertEquals(2, list.getCurrentSize());
        assertTrue(list.add(new Influencer("3", "C")));
        assertEquals(3, list.getCurrentSize());
    }


    /**
     * Tests the getCurrentSize method.
     */
    public void testGetCurrentSize()
    {
        assertEquals(0, list.getCurrentSize());
        list.add(new Influencer("1", "A"));
        assertEquals(1, list.getCurrentSize());
        list.add(new Influencer("2", "B"));
        assertEquals(2, list.getCurrentSize());
        list.add(new Influencer("3", "C"));
        assertEquals(3, list.getCurrentSize());
    }


    /**
     * Tests the isEmpty method.
     */
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add(new Influencer("1", "A"));
        assertFalse(list.isEmpty());
        list.add(new Influencer("2", "B"));
        assertFalse(list.isEmpty());
        list.remove(0);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }


    /**
     * Tests the remove(T) method.
     */
    public void testRemoveT()
    {
        assertFalse(list.remove(new Influencer("1", "A")));
        list.add(new Influencer("1", "A"));
        assertTrue(list.remove(new Influencer("1", "A")));
        assertEquals(0, list.getCurrentSize());
        assertFalse(list.remove(new Influencer("2", "B")));
    }


    /**
     * Tests the remove(int) method.
     */
    public void testRemoveInt()
    {
        assertFalse(list.remove(0));
        list.add(new Influencer("1", "A"));
        assertTrue(list.remove(0));
        assertEquals(0, list.getCurrentSize());
        assertFalse(list.remove(1));
    }


    /**
     * Tests the getData(int) method.
     */
    public void testGetData()
    {
        assertNull(list.getData(0));
        list.add(new Influencer("1", "A"));
        assertEquals(new Influencer("1", "A"), list.getData(0));
        list.add(new Influencer("2", "B"));
        assertEquals(new Influencer("2", "B"), list.getData(1));
        assertNull(list.getData(2));
    }


    /**
     * Tests the clear method.
     */
    public void testClear()
    {
        list.add(new Influencer("1", "A"));
        list.add(new Influencer("2", "B"));
        list.add(new Influencer("3", "C"));
        list.clear();
        assertEquals(0, list.getCurrentSize());
        assertNull(list.getData(0));
    }


    /**
     * Tests the equals method.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals()
    {
        DoublyLinkedList<Influencer> otherList = new DoublyLinkedList<>();
        assertTrue(list.equals(list));
        assertFalse(list.equals(null));
        assertFalse(list.equals(1));

        list.add(new Influencer("1", "A"));
        assertFalse(list.equals(otherList));
        otherList.add(new Influencer("1", "A"));
        assertTrue(list.equals(otherList));

        list.add(new Influencer("2", "B"));
        assertFalse(list.equals(otherList));
        otherList.add(new Influencer("2", "B"));
        assertTrue(list.equals(otherList));

        otherList.add(new Influencer("3", "C"));
        assertFalse(list.equals(otherList));
    }


    /**
     * Tests the sortByName method.
     */
    public void testSortByName()
    {
        list.add(new Influencer("2", "B"));
        list.add(new Influencer("1", "A"));
        list.add(new Influencer("3", "C"));
        list.sortByName();
        assertEquals(new Influencer("1", "A"), list.getData(0));
        assertEquals(new Influencer("2", "B"), list.getData(1));
        assertEquals(new Influencer("3", "C"), list.getData(2));
    }


    /**
     * Tests the sortByEng method.
     */
    public void testSortByEng()
    {
        list.add(new Influencer("1", "A"));
        list.add(new Influencer("2", "B"));
        list.add(new Influencer("3", "C"));

        MonthlyStatistics p1 = new MonthlyStatistics(
            MonthEnum.MARCH,
            "United States",
            "Summer Weather",
            22876452,
            4650272,
            518,
            170095);
        MonthlyStatistics p2 = new MonthlyStatistics(
            MonthEnum.MARCH,
            "United States",
            "Summer Weather",
            22876452,
            4650272,
            518,
            170095);
        MonthlyStatistics p3 = new MonthlyStatistics(
            MonthEnum.JANUARY,
            "United Kingdom",
            "Summer",
            22876452,
            4650272,
            518,
            170095);

        list.getData(0).addData(p1);
        list.getData(1).addData(p2);
        list.getData(2).addData(p3);

        Influencer inf1 = list.getData(0);
        Influencer inf2 = list.getData(1);
        Influencer inf3 = list.getData(2);

        list.sortByEng(MonthEnum.MARCH, "traditional");

        // Compare relevant attributes instead of the entire Influencer object
        assertEquals("1", list.getData(0).getUserName());
        assertEquals("A", list.getData(0).getChannelName());

        assertEquals("2", list.getData(1).getUserName());
        assertEquals("B", list.getData(1).getChannelName());

        assertEquals("3", list.getData(2).getUserName());
        assertEquals("C", list.getData(2).getChannelName());
        assertEquals(inf1, list.getData(0));
        assertEquals(inf2, list.getData(1));
        assertEquals(inf3, list.getData(2));
    }


    /**
     * Tests the iterator method.
     */
    public void testIterator()
    {
        list.add(new Influencer("1", "A"));
        list.add(new Influencer("2", "B"));
        list.add(new Influencer("3", "C"));

        Iterator<Influencer> iter = list.iterator();
        assertTrue(iter.hasNext());
        assertEquals(new Influencer("1", "A"), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(new Influencer("2", "B"), iter.next());
        assertTrue(iter.hasNext());
        assertEquals(new Influencer("3", "C"), iter.next());
        assertFalse(iter.hasNext());
        Exception e = null;
        try
        {
            iter.next();
        }
        catch (NoSuchElementException exception)
        {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);
    }
}
