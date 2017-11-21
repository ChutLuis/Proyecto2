package gt.edu.url.proyecto2.dataStructures;

/**
 *
 * @author Laptop
 */
public class DynamicStack<E> implements Stack<E> {

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

    public DynamicStack() {
        top = new Node(null, null);
    }

    public int size() {
        return Size;
    }

    public boolean isEmpty() {
        return Size == 0;
    }

    public E top() {
        return top.getPrev().getElement();
    }

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