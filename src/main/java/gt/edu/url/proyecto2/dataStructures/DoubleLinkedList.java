package gt.edu.url.proyecto2.dataStructures;

public class DoubleLinkedList<E> {

    /**
     * this class reptresents the nodes that we will use in this
     * DoubleLinkedList to save data.
     */
    private static class Node<E> {

        private E element;
        private Node<E> prev;//Anterior
        private Node<E> next;//Siguiente

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

    }

    private Node<E> header = null;//Referencia
    private Node<E> trailer = null;
    private int size = 0;

    /**
     * this is the constructor of the class, creates the references header and
     * trailer, that indicates the beginnig and the end of the list
     */
    public DoubleLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

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
     * returns the first element of the list with out removing it
     *
     * @return E the first element
     */
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
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
        return trailer.getPrev().getElement();
    }

    /**
     * Adds an element e in the beginnig of the list
     *
     * @param e the added element
     */
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /**
     * Adds an element e in the end of the list
     *
     * @param e the added element
     */
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
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
        return remove(header.getNext());
    }

    /**
     * Removes the last element in the list
     *
     * @return E, the removed element
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    /**
     * adds en element between two existing nodes
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes and indicated node in the list
     *
     * @return E, the removed element
     */
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

}
