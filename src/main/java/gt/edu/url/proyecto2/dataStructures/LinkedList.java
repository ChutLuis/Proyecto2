package gt.edu.url.proyecto2.dataStructures;

public class LinkedList<E> implements Stack<E>, Queue<E> {

    /**
     * Inner class
     *
     * @author tuxtor
     *
     * @param <E>
     */
    private static class Node<E> {

        private E element; //Valor
        private Node<E> next; //Puntero en la lista

        public Node(E element, Node<E> next) {
            super();
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    private int size = 0;

    /**
     * Retruns the size of the list.
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Return if the list is empty
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first element of the list with out removing it
     *
     * @return E, the first element
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    /**
     * removes the last element of the list with out removing it
     *
     * @return E, the last element
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /**
     * Adds an element e in the beginnig of the list
     *
     * @param e the added element
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    /**
     * Adds an element e in the end of the list
     *
     * @param e the added element
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    /**
     * Removes the first element in the list
     *
     * @return E, the removed element
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E response = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return response;
    }

    /**
     * Radd first
     *
     */
    @Override
    public void push(E e) {
        this.addFirst(e);

    }

    /**
     * return the first element with out removing it
     *
     * @return E, the removed element
     */
    @Override
    public E top() {

        return this.first();
    }

    /**
     * return the first element removing it
     *
     * @return E, the removed element
     */
    @Override
    public E pop() {

        return this.removeFirst();
    }

    /**
     * add an element at the end of the list
     */

    @Override
    public void enqueue(E e) {
        this.addLast(e);

    }

    /**
     * return the first element removing it
     *
     * @return E, the removed element
     */
    @Override
    public E dequeue() {
        return removeFirst();
    }

}
