package gt.edu.url.proyecto2.dataStructures;

public class CircularLinkedList<E> {

    /**
     * this class reptresents the nodes that we will use in this
     * CircularLinkedList to save data.
     */
    private static class Node<E> {

        private E element;
        private Node<E> next;

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

    private Node<E> tail = null;

    private int size = 0;

    /**
     * Retruns the size of the list.
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
     * returns the first element of the list with out removing it
     *
     * @return E the first element
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return tail.getNext().getElement();//Primer cambio
    }

    /**
     * returns the last element of the list with out removing it
     *
     * @return E the last element
     */
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    /**
     * Rotates the list
     */
    public void rotate() {
        if (tail != null) {
            tail = tail.getNext();
        }
    }

    /**
     * Adds an element e in the beginnig of the list
     * @param e the added element
     */
    public void addFirst(E e) {

        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    /**
     * Adds an element e in the end of the list
     * @param e the added element
     */
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
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
        Node<E> head = tail.getNext();
        if (head == tail) {
            tail = null;
        } else {
            tail.setNext(head.getNext());
        }
        size--;
        return head.getElement();
    }
}
