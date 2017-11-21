package gt.edu.url.proyecto2.dataStructures;



// TODO: Auto-generated Javadoc
/**
 * The Interface PositionalList.
 *
 * @param <E>
 *            the element type
 */
public interface PositionalList<E> {
	
	/**
	 * Size.
	 *
	 * @return the int
	 */
	int size( );
	
	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	boolean isEmpty( );
	
	/**
	 * First.
	 *
	 * @return the position
	 */
	Position<E> first( );
	
	/**
	 * Last.
	 *
	 * @return the position
	 */
	Position<E> last( );
	
	/**
	 * Adds the first.
	 *
	 * @param e
	 *            the e
	 * @return the position
	 */
	Position<E> addFirst(E e);
	
	/**
	 * Adds the last.
	 *
	 * @param e
	 *            the e
	 * @return the position
	 */
	Position<E> addLast(E e);
	
	/**
	 * Before.
	 *
	 * @param p
	 *            the p
	 * @return the position
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * After.
	 *
	 * @param p
	 *            the p
	 * @return the position
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * Adds the before.
	 *
	 * @param p
	 *            the p
	 * @param e
	 *            the e
	 * @return the position
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Adds the after.
	 *
	 * @param p
	 *            the p
	 * @param e
	 *            the e
	 * @return the position
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Sets the.
	 *
	 * @param p
	 *            the p
	 * @param e
	 *            the e
	 * @return the e
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * Removes the.
	 *
	 * @param p
	 *            the p
	 * @return the e
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	E remove(Position<E> p) throws IllegalArgumentException;
        
        /**
		 * Position at index.
		 *
		 * @param i
		 *            the i
		 * @return the position
		 */
        //Metodo a implementar
        Position<E> positionAtIndex(int i);
        

}
