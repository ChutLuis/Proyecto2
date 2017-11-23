package gt.edu.url.proyecto2.btree;

import java.util.Iterator;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    /**
     * this is the node of the binary tree
     *
     * @param <E> is the data type that we will use
     */
    protected static class Node<E> implements Position<E> {

        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        @Override
        public E getElement() throws IllegalStateException {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        public void setElement(E e) {
            element = e;
        }

        public void setParent(Node<E> parentNode) {
            parent = parentNode;
        }

        public void setLeft(Node<E> leftChild) {
            left = leftChild;
        }

        public void setRight(Node<E> rightChild) {
            right = rightChild;
        }
    }

    /**
     * this creates a new node
     *
     * @param e the elemet of the node
     * @param parent the parent of the new node
     * @param left a left positon in the node
     * @param right a right positon in the node
     * @return
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }

    protected Node<E> root = null;
    private int size = 0;

    /**
     * the constructor of the class
     */
    public LinkedBinaryTree() {
    }

    /**
     * validates if the node have a valid positon and if is a valid node
     *
     * @param p the new node
     * @return the node
     * @throws IllegalArgumentException
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Posicion no valida");
        }
        Node<E> node = (Node<E>) p;
        if (node.getParent() == node) // Convencion
        {
            throw new IllegalArgumentException("El nodo es invalido");
        }
        return node;
    }

    /**
     * gives the size of the tree
     *
     * @return the size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * gives the node root of the tree
     *
     * @return the positon of the root
     */
    @Override
    public Position<E> root() {
        return root;
    }

    /**
     * returns the parent of the node
     *
     * @param p the node
     * @return the parent
     * @throws IllegalArgumentException
     */
    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * returns the left of the node
     *
     * @param p the node
     * @return the left
     * @throws IllegalArgumentException
     */
    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    /**
     * returns the right of the node
     *
     * @param p the node
     * @return the right
     * @throws IllegalArgumentException
     */
    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    /**
     * add the root node
     *
     * @param e, the element in the root
     * @return the position of the node root
     * @throws IllegalStateException
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }

    /**
     * add a new node in the left
     *
     * @param p the referenced node
     * @param e the element of the new node
     * @return the positon of the new node
     * @throws IllegalArgumentException
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null) {
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /**
     * add a new node in the Right
     *
     * @param p the referenced node
     * @param e the element of the new node
     * @return the positon of the new node
     * @throws IllegalArgumentException
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null) {
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /**
     * changes the element in a node
     *
     * @param p the node
     * @param e the new element
     * @return the element that we set
     * @throws IllegalArgumentException
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /**
     * attaches 1 tree to another
     *
     * @param p the positon
     * @param t1 one tree
     * @param t2 the other tree
     * @throws IllegalArgumentException
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1,
            LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) {
            throw new IllegalArgumentException("p must be a leaf");
        }
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /**
     * removes a node in the tree
     *
     * @param p the node that we want to delete
     * @return the element removed
     * @throws IllegalArgumentException
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2) {
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if (child != null) {
            child.setParent(node.getParent());
        }
        if (node == root) {
            root = child;
        } else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft()) {
                parent.setLeft(child);
            } else {
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node);
        return temp;
    }

    /**
     * doesnt do anything
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * doesnt do anything
     *
     * @return
     */
    @Override
    public Iterable<Position<E>> positions() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * doesnt do anything
     *
     * @return
     * @throws IllegalStateException
     */
    public E getElement() throws IllegalStateException {
        // TODO Auto-generated method stub
        return null;
    }

}
