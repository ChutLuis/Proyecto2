package gt.edu.url.proyecto2.dataStructures;

// TODO: Auto-generated Javadoc
/**
 * The Class LinkedPositionalList.
 *
 * @param <E>
 *            the element type
 */
public class LinkedPositionalList<E> implements PositionalList<E> {
	
	/**
	 * The Class Node.
	 *
	 * @param <E>
	 *            the element type
	 */
	private static class Node<E> implements Position<E> {
		
		/** The element. */
		private E element;
		
		/** The prev. */
		private Node<E> prev;// Anterior
		
		/** The next. */
		private Node<E> next;// Siguiente
                

		/**
		 * Instantiates a new node.
		 *
		 * @param e
		 *            the e
		 * @param p
		 *            the p
		 * @param n
		 *            the n
		 */
		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		/* (non-Javadoc)
		 * @see gt.edu.url.examen2.problema4.Position#getElement()
		 */
		public E getElement() throws IllegalStateException {
			if (next == null) // Nodo no valido
				throw new IllegalStateException("Posicion invalida");
			return element;
		}
		
		/**
		 * Sets the element.
		 *
		 * @param e
		 *            the new element
		 */
		public void setElement(E e) {
			element = e;
		}

		/**
		 * Gets the prev.
		 *
		 * @return the prev
		 */
		public Node<E> getPrev() {
			return prev;
		}

		/**
		 * Sets the prev.
		 *
		 * @param prev
		 *            the new prev
		 */
		public void setPrev(Node<E> prev) {
			this.prev = prev;
		}

		/**
		 * Gets the next.
		 *
		 * @return the next
		 */
		public Node<E> getNext() {
			return next;
		}

		/**
		 * Sets the next.
		 *
		 * @param next
		 *            the new next
		 */
		public void setNext(Node<E> next) {
			this.next = next;
		}

	}	

	/** The header. */
	private Node<E> header = null;// Referencia
	
	/** The trailer. */
	private Node<E> trailer = null;
	
	/** The size. */
	private int size = 0;

	/**
	 * Instantiates a new linked positional list.
	 */
	public LinkedPositionalList() {
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
	}

	// Metodos internos
	/**
	 * Valida si una posicion contiene un nodo y el nodo existe.
	 *
	 * @param p
	 *            the p
	 * @return the node
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		if (!(p instanceof Node))
			throw new IllegalArgumentException("P invalido");
		Node<E> node = (Node<E>) p; // safe cast
		if (node.getNext() == null)
			throw new IllegalArgumentException("p ya no se encuentra en la lista");
		return node;
	}
	
	/**
	 * "Empaca" un nodo como posicion a menos que sea header o trailer.
	 *
	 * @param node
	 *            the node
	 * @return the position
	 */
	private Position<E> position(Node<E> node) {
		if (node == header || node == trailer)
			return null; // do not expose user to the sentinels
		return node;
	}

	// ---

	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#size()
	 */
	public int size() {return size;}

	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#isEmpty()
	 */
	public boolean isEmpty() {return size == 0;}

	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#first()
	 */
	public Position<E> first( ) {
		return position(header.getNext());
	}

	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#last()
	 */
	public Position<E> last( ) {
		return position(trailer.getPrev());
	}
	
	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#before(gt.edu.url.examen2.problema4.Position)
	 */
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getPrev());
	}

	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#after(gt.edu.url.examen2.problema4.Position)
	 */
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		return position(node.getNext());
	}
	
	
	/**
	 * Adds the between.
	 *
	 * @param e
	 *            the e
	 * @param pred
	 *            the pred
	 * @param succ
	 *            the succ
	 * @return the position
	 */
	private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
                Node<E> newest = new Node<>(e, pred, succ);
		succ.setPrev(newest);
		pred.setNext(newest);
		size++;
		return newest;
	}
	
	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#addFirst(java.lang.Object)
	 */
	public Position<E> addFirst(E e) {
		return addBetween(e, header, header.getNext());
	}

	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#addLast(java.lang.Object)
	 */
	public Position<E> addLast(E e) {
		return addBetween(e, trailer.getPrev(), trailer);
	}
	
	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#addBefore(gt.edu.url.examen2.problema4.Position, java.lang.Object)
	 */
	public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException{
		Node<E> node = validate(p);
		return addBetween(e, node.getPrev(), node);
	}
	
	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#addAfter(gt.edu.url.examen2.problema4.Position, java.lang.Object)
	 */
	public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException{ 
		Node<E> node = validate(p);
		return addBetween(e, node, node.getNext());
	}

	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#set(gt.edu.url.examen2.problema4.Position, java.lang.Object)
	 */
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		Node<E> node = validate(p);
		E answer = node.getElement();
		node.setElement(e);
		return answer;
	}
	
	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#remove(gt.edu.url.examen2.problema4.Position)
	 */
	public E remove(Position<E> p) throws IllegalArgumentException {
		Node<E> node = validate(p);
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		E answer = node.getElement();
		node.setElement(null);
		node.setNext(null);
		node.setPrev(null);
        return answer;} 
	
	/* (non-Javadoc)
	 * @see gt.edu.url.examen2.problema4.PositionalList#positionAtIndex(int)
	 */
	public Position<E> positionAtIndex(int i) throws IndexOutOfBoundsException
	{ 
		if(i<=size) {
			Position<E> temp=null;
			for(int x =0; x< i; x++) {
				remove(first());
			}
			temp = first();
			return temp;
		}
		else {
			System.out.println("IndexOutOfBoundsException");
			return null;
		}
			    
			
			
		
	}
}
