package gt.edu.url.proyecto2.btree;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {

    /**
     * this is the root of our tree
     *
     * @return the element in the root
     */
    Position<E> root();

    /**
     * this returns the parent of our actual node
     *
     * @param p, the actual node
     * @return, the parent
     * @throws IllegalArgumentException if there is not parent
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * this returns the children of our actual node
     *
     * @param p, the actual node
     * @return the children
     * @throws IllegalArgumentException, if there is not children
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     * return the number of childrens
     *
     * @param p, the actual node
     * @return the number of childrens
     * @throws IllegalArgumentException if there are not childrens
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * return if the node is not external
     *
     * @param p, the actual node
     * @return true if the node is internal
     * @throws IllegalArgumentException
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * return if the node is not internal
     *
     * @param p, the actual node
     * @return true if the node is external
     * @throws IllegalArgumentException
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * return if the actual node is the root
     *
     * @param p, the actual node
     * @return true if is the root of the tree
     * @throws IllegalArgumentException
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * gives the size of the tree
     *
     * @return size
     */
    int size();

    /**
     * if the tree is empty
     *
     * @return true if is empty
     */
    boolean isEmpty();

    Iterator<E> iterator();

    Iterable<Position<E>> positions();
}
