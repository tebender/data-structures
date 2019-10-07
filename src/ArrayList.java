/**
 * 
 */

/**
 * Array based implementation of a List
 * 
 * @author Tim Bender
 * @version 2019.10.07
 * @param <E>
 *            the type of Object being stored in the List
 */
public class ArrayList<E> implements List<E> {
    private E[] arr;
    private int size;


    /**
     * Constructor
     * 
     * @param l
     *            starting length for the array
     */
    public ArrayList(int l) {
        arr = (E[])new Object[l];
        size = 0;
    }


    /**
     * Adds an element to the end of the List
     * 
     * @param element
     *            the element to be added
     */
    @Override
    public void add(E element) {
        if (isFull()) {
            expandArr();
        }
        // add element
        arr[size] = element;
        size++;
    }


    /**
     * Adds an element at specified index
     * 
     * @param index
     *            index to be inserted to
     * @param element
     *            element to be added
     */
    @Override
    public void add(int index, E element) {
        if (index > size) {
            throw new IllegalArgumentException(
                "Index to be added to must be less than or equal to size");
        }
        if (isFull()) {
            expandArr();
        }
        E curr = element;
        E temp = null;
        for (int i = index; i <= size; i++) {
            temp = arr[i];
            arr[i] = curr;
            curr = temp;
        }
        size++;
    }


    /**
     * Checks if the List contains an Object
     * 
     * @param o
     *            the Object to search for
     * @return true if the Object is in the list
     */
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Expands the underlying array
     */
    private void expandArr() {
        int nLen = arr.length * 2;
        E[] tempArr = (E[])(new Object[nLen]);
        // copy elements over
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        arr = tempArr;
    }


    /**
     * Gets the element at the specified index
     * 
     * @param index
     *            the index to be searched in
     * @return the object in the index
     */
    @Override
    public E get(int index) {
        return arr[index];
    }


    /**
     * Finds the index of a specified Object
     * 
     * @param o
     *            the Object to be searched for
     * @return the index of the Object, -1 if it isn't in the list
     */
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Helper method to see if arr is full
     * 
     * @return true if our array is full
     */
    private boolean isFull() {
        return arr.length == size;
    }


    /**
     * Removes an element from the specified index
     * 
     * @param index
     *            the index from which to remove the element
     * @return the element if it was successfully removed, null if it was
     *         unsuccessful
     */
    @Override
    public E remove(int index) {
        if (index >= size) {
            return null;
        }
        E temp = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        return temp;
    }


    /**
     * Removes an Object from the list
     * 
     * @param o
     *            the Object to be removed
     * @return the element if it was successfully removed, null if it was
     *         unsuccessful
     */
    @Override
    public E remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) {
                return remove(i);
            }
        }
        return null;
    }


    /**
     * Gets the number of elements in the list
     * 
     * @return size, the number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Places elements in the list into an Array
     * 
     * @return an array of elements
     */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = arr[i];
        }
        return array;
    }
}
