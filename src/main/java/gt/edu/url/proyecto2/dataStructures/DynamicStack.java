package gt.edu.url.proyecto2.dataStructures;

/**
 *
 * @author Laptop
 */
public class DynamicStack<E> implements Stack<E> {
    /**
     * this class reptresents the nodes that we will use in this
     * Dynamic Stack to save data.
     */
    private static class Node<E> {

        private E element;
        private Node<E> prev;// Anterior

        public Node(E e, Node<E> p) {
            element = e;
            prev = p;
        }

        public E getElement() throws IllegalStateException {
            return element;
        }

        public void setElement(E e) {
            element = e;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }

    Node<E> top;
    int Size = 0;
    /**
     * this is the constructor of the class that inicializates the beginning of our class
     */
    public DynamicStack() {
        top = new Node(null, null);
    }
    /**
     * Retruns the size of the list.
     * @return size
     */
    public int size() {
        return Size;
    }
    /**
     * Return if the list is empty
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return Size == 0;
    }
    /**
     * Return the top element with out removing it
     *
     * @return E, the top element
     */
    public E top() {
        return top.getPrev().getElement();
    }

        /**
     * add an element in the top
     * @param e, the new element
     */
    public void push(E e) {
        Node<E> nn = new Node(e, null);
        if (top.getPrev() == null) {
            top.setPrev(nn);
        } else {
            nn.setPrev(top.getPrev());
            top.setPrev(nn);
        }
        Size++;
    }

        /**
     * Return the top element removing it
     *
     * @return E, the top element
     */
    public E pop() {
        E element = null;
        if (Size > 0){ 
        Node<E> oldnode;
        oldnode = top.getPrev();
        top.setPrev(top.getPrev().getPrev());
        Size--;
        element = oldnode.getElement();
        oldnode = null;
        }
        return element;
    }
}