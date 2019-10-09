/**
 * 
 */

/**
 * Node class for a Singly Linked List
 * 
 * @author Tim Bender
 * @version 2019.10.08
 * @param <E>
 *            the type of element to be stored in the Node
 */
public class Node<E> {
    private E data;
    private Node<E> next;


    /**
     * A constructor
     * 
     * @param d
     *            the data to be stored in this
     */
    public Node(E d) {
        data = d;
    }


    /**
     * A constructor
     * 
     * @param n
     *            the Node this should be pointing to
     * @param d
     *            the data to be stored in this
     */
    public Node(E d, Node<E> n) {
        next = n;
        data = d;
    }


    /**
     * Gets data
     * 
     * @return data, a generic
     */
    public E data() {
        return data;
    }


    /**
     * gets the Node this is pointing to
     * 
     * @return next, a Node
     */
    public Node<E> next() {
        return next;
    }


    /**
     * sets the data to be stored in this
     * 
     * @param d
     *            the data to be stored
     */
    public void setData(E d) {
        data = d;
    }


    /**
     * sets the Node this should point to
     * 
     * @param n
     *            the Node to be pointed to
     */
    public void setNext(Node<E> n) {
        next = n;
    }

}
