package gt.edu.url.proyecto2.btree;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {

    /**
     * Retruns the position of the sibling
     *
     * @param p, is our actual node
     * @return the sibling
     */
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null;
        }
        if (p == left(parent)) {
            return right(parent);
        } else {
            return left(parent);
        }
    }

    /**
     * gives the number of childerns thas has a node
     *
     * @param p, the node
     * @return the number of childrens
     */
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }

}
