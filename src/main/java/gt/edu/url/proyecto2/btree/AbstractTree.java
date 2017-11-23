package gt.edu.url.proyecto2.btree;

public abstract class AbstractTree<E> implements Tree<E> {

    /**
     * validates if the node is internal
     *
     * @param p the node
     * @return true if the node is internal
     */
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     * validates if the node is external
     *
     * @param p the node
     * @return true if the node is external
     */
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     * validates if the node is the root
     *
     * @param p the node
     * @return true if the node is the root
     */
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     * validates if the tree is empty
     *
     * @param p the node
     * @return true if the node is empty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * calculates de depth of the tree in a specific node
     *
     * @param p the node
     * @return the depth of the tree
     */
    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    /**
     * calculates the height of the tree
     *
     * @param p the node
     * @return the heiht
     */
    public int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;

    }
}
