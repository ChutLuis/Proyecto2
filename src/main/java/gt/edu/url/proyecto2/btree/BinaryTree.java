package gt.edu.url.proyecto2.btree;

public interface BinaryTree<E> extends Tree<E> {

    /**
     * return the left positon of the node
     *
     * @param p the actual node
     * @return the left positon
     * @throws IllegalArgumentException
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;

    /**
     * return the right positon of the node
     *
     * @param p the actual node
     * @return the right positon
     * @throws IllegalArgumentException
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;

    /**
     * return the sibling positon of the node
     *
     * @param p the actual node
     * @return the sibling positon
     * @throws IllegalArgumentException
     */
    Position<E> sibling(Position<E> p) throws IllegalArgumentException;
}
