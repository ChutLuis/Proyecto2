package gt.edu.url.proyecto2.dataStructures;

public class DynamicQueue<E> implements Queue<E> {
	
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
	
	public DynamicQueue() {
        first = new Node(null, null);
    }
	
	
	public int size() {
		return Sz;
	}
	

	public boolean isEmpty() {
		if (Sz == 0) {
			return true;
		}
		return false;
	}
	
    //No funciona
	public void enqueue(E e) {
		Node<E> nn = new Node(e, null);
        if (first == null) {
            first = nn;
        } else {
        	nn.setNext(first);
        	while (nn.getNext().getNext() != null){
        		nn.setNext(nn.getNext());
        	}
        	nn.getNext().setNext(nn);
        	nn.setNext(null);
        }
        Sz++;
	}
	

	public E first() {
		return first.getElement();
	}
	
	public E dequeue() {
		if (first == null) {
			return null;
		}
		else {
			E element = first.getElement();
			first.setNext(first.getNext());
			Sz--;
			return element;
		}
	}
}