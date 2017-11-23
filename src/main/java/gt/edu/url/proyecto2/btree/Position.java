package gt.edu.url.proyecto2.btree;

public interface Position<E> {

    /**
     * gives the element in the position
     *
     * @return the element
     * @throws IllegalStateException, if there is not node or element
     */
    E getElement() throws IllegalStateException;
}
