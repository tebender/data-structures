import junit.framework.TestCase;

/**
 * 
 */

/**
 * A test class for LinkedList
 * 
 * @author Tim Bender
 * @version 2019.10.08
 */
public class LinkedListTest extends TestCase {
    private LinkedList<String> list;


    /**
     * Sets up the test scenario
     */
    public void setUp() {
        list = new LinkedList<String>();
        list.add("one");
    }


    /**
     * tests basic add(E element) method
     */
    public void testAdd() {
        list.add("two");
        assertEquals(list.get(1), "two");
        list.add("three");
        assertEquals(list.get(2), "three");
        assertEquals(list.size(), 3);
    }


    /**
     * tests adding at an index
     */
    public void testAddIndex() {
        list.add(0, "two");
        list.add(0, "three");
        list.add(2, "elem");
        assertEquals(list.get(0), "three");
        assertEquals(list.get(1), "two");
        assertEquals(list.get(2), "elem");
        assertEquals(list.get(3), "one");
        assertEquals(list.size(), 4);
        Exception exception = null;
        try {
            list.add(5, "bad");
        }
        catch (Exception e) {
            exception = e;
        }
        assertEquals(exception.getClass(), IllegalArgumentException.class);        
    }


    /**
     * Tests contains(Object o) method
     */
    public void testContains() {
        assertTrue(list.contains("one"));
        assertFalse(list.contains("two"));
    }


    /**
     * tests the get(index i) method
     */
    public void testGet() {
        assertEquals(list.get(0), "one");
        assertNull(list.get(1));
    }


    /**
     * tests the indexOf(Object o) method
     */
    public void testIndexOf() {
        assertEquals(list.indexOf("one"), 0);
        assertEquals(list.indexOf("two"), -1);
    }


    /**
     * tests remove(int index) method
     */
    public void testRemove() {
        list.add("two");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        assertEquals(list.remove(0), "one");
        assertEquals(list.get(0), "two");
        assertEquals(list.remove(3), "5");
        assertEquals(list.get(3), "6");
        assertEquals(list.size(), 4);
        assertEquals(list.remove(3), "6");
        assertEquals(list.size(), 3);
        assertNull(list.remove(3));
        assertEquals(list.size(), 3);
    }


    /**
     * tests remove(Object o) method
     */
    public void testRemoveObject() {
        list.add("two");
        assertEquals(list.remove("two"), "two");
        assertEquals(list.get(0), "one");
        assertEquals(list.size(), 1);
        list.add("two");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        assertEquals(list.remove("3"), "3");
        assertEquals(list.remove("one"), "one");
        assertEquals(list.remove("6"), "6");
        assertEquals(list.size(), 3);
    }
}
