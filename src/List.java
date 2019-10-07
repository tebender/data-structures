/**
 * 
 */

/**
 * Interface for a List.
 * 
 * @author Tim Bender
 * @version 2019.10.07
 * @param <E>
 *            the type of Object the List will store
 */
public interface List<E> {

    /**
     * Adds an element to the end of the List
     * 
     * @param element
     *            the element to be added
     */
    public void add(E element);


    /**
     * Adds an element at specified index
     * 
     * @param index
     *            index to be inserted to
     * @param element
     *            element to be added
     */
    public void add(int index, E element);


    /**
     * Checks if the List contains an Object
     * 
     * @param o
     *            the Object to search for
     * @return true if the Object is in the list
     */
    public boolean contains(Object o);


    /**
     * checks if this List is equivalent to another Object
     * 
     * @param o
     *            the Object to compare against
     * @return true if this and o are equivalent
     */
    public boolean equals(Object o);


    /**
     * Gets the element at the specified index
     * 
     * @param index
     *            the index to be searched in
     * @return the object in the index
     */
    public E get(int index);


    /**
     * Finds the index of a specified Object
     * 
     * @param o
     *            the Object to be searched for
     * @return the index of the Object, -1 if it isn't in the list
     */
    public int indexOf(Object o);


    /**
     * Removes an element from the specified index
     * 
     * @param index
     *            the index from which to remove the element
     * @return the element if it was successfully removed, null if it was
     *         unsuccessful
     */
    public E remove(int index);


    /**
     * Removes an Object from the list
     * 
     * @param o
     *            the Object to be removed
     * @return the element if it was successfully removed, null if it was
     *         unsuccessful
     */
    public E remove(Object o);


    /**
     * Gets the number of elements in the list
     * 
     * @return the number of elements in the list
     */
    public int size();


    /**
     * Places elements in the list into an Array
     * 
     * @return an array of elements
     */
    public Object[] toArray();
}
