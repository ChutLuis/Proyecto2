package gt.edu.url.proyecto2.dataStructures;

public class DynamicQueue<E> implements Queue<E> {

    /**
     * this class reptresents the nodes that we will use in this Dynamic Queue
     * to save data.
     */
    private static class Node<E> {

        private E element;
        private Node<E> next;// Anterior

        public Node(E e, Node<E> p) {
            element = e;
            next = p;
        }

        public E getElement() throws IllegalStateException {
            return element;
        }

        public void setElement(E e) {
            element = e;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    int Sz = 0;
    Node<E> first;

    /**
     * this is the constructor of the class
     */
    public DynamicQueue() {
        first = null;
    }

    /**
     * Retruns the size of the list.
     *
     * @return size
     */
    public int size() {
        return Sz;
    }

    /**
     * Return if the list is empty
     *
     * @return true or false
     */
    public boolean isEmpty() {
        if (Sz == 0) {
            return true;
        }
        return false;
    }

    /**
     * add an element at the end of the queue
     *
     * @param e, the new element
     */
    public void enqueue(E e) {
        Node<E> nn = new Node(e, null);
        if (first == null) {
            first = nn;
        } else {
            nn.setNext(first);
            while (nn.getNext().getNext() != null) {
                nn.setNext(nn.getNext().getNext());
            }
            nn.getNext().setNext(nn);
            nn.setNext(null);
        }
        Sz++;
    }

    /**
     * Returns the first element of the queue with out removing it
     *
     * @return E, the first element
     */
    public E first() {
        return first.getElement();
    }

    /**
     * removes the first element of the queue
     *
     * @return E, the first element
     */
    public E dequeue() {
        if (first == null) {
            return null;
        } else {
            E element = first.getElement();
            first = first.getNext();
            Sz--;
            return element;
        }
    }
}
