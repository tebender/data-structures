/**
 * Node based implementation of a List.
 * 
 * @author Tim Bender
 * @version 2017.10.08
 */
public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;


    /**
     * A constructor
     */
    public LinkedList() {
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
        Node<E> n = new Node<E>(element);
        if (size == 0) {
            head = n;
            tail = n;
            size++;
        }
        else {
            tail.setNext(n);
            tail = n;
            size++;
        }
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
        if (index == 0) {
            Node<E> temp = new Node<E>(element, head);
            head = temp;
            size++;
            return;
        }

        // general case
        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next();
        }
        Node<E> temp = curr.next();
        curr.setNext(new Node<E>(element, temp));
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
        Node<E> curr = head;
        while (curr != null) {
            if (curr.data().equals(o)) {
                return true;
            }
            curr = curr.next();
        }
        return false;
    }


    /**
     * checks if this List is equivalent to another Object
     * 
     * @param o
     *            the Object to compare against
     * @return true if this and o are equivalent
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (this.getClass() == o.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<E> other = ((LinkedList<E>)o);
            if (other.size() == this.size()) {
                Node<E> current = head;
                Node<E> otherCurrent = other.head;
                while (current != null) {
                    if (!current.data().equals(otherCurrent.data())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }
        return false;
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
        if (index > size - 1) {
            return null;
        }
        Node<E> curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next();
        }
        return curr.data();
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
        Node<E> curr = head;
        for (int i = 0; i < size; i++) {
            if (curr.data().equals(o)) {
                return i;
            }
            curr = curr.next();
        }
        return -1;
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
        if (index > size - 1) {
            return null;
        }
        if (index == 0) {
            E data = head.data();
            head = head.next();
            size--;
            return data;
        }
        Node<E> curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next();
        }
        if (index == size - 1) {
            tail = curr;
        }
        E data = curr.next().data();
        curr.setNext(curr.next().next());
        size--;
        return data;
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
        if (head.data().equals(o)) {
            E data = head.data();
            head = head.next();
            size--;
            return data;
        }
        Node<E> curr = head;
        for (int i = 0; i < size - 1; i++) {
            if (curr.next().data().equals(o)) {
                // update tail
                if (curr.next().equals(tail)) {
                    tail = curr;
                }
                // remove node
                E data = curr.next().data();
                curr.setNext(curr.next().next());
                size--;
                return data;
            }
            curr = curr.next();
        }
        return null;
    }


    /**
     * Gets the number of elements in the list
     * 
     * @return the number of elements in the list
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
        Object[] arr = new Object[size];
        Node<E> curr = head;
        for (int i = 0; i < size; i++) {
            arr[i] = curr.data();
            curr = curr.next();
        }
        return arr;
    }

}
