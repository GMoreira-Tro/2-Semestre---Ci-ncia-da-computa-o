
public class DoublyLinkedList<E> implements MyLinkedList<E> {
	DNode<E> head;
	DNode<E> tail;
	int numElements;
	
	public DoublyLinkedList() {
		head = tail = null;
		numElements = 0;
	}
	public E get(int index) {
		if (index == numElements - 1)
			return tail.getElement();
		else if (index < 0 || index >= numElements)
			throw new IndexOutOfBoundsException();
		DNode<E> element;
		if (Math.abs(index-numElements) > index) {
			element =  head;
			for (int i = 0; i < index; i++) {
				element = element.getNext();
			}
		}
		else {
			element = tail;
			for (int i = numElements-1; i > index; i--) {
				element = element.getPrevious();
			}
		}
		return element.getElement();
	}
	public void set(int index, E put) {
		if (index == numElements - 1)
			tail.setElement(put);
		else if (index < 0 || index >= numElements)
			throw new IndexOutOfBoundsException();
		DNode<E> element;
		if (Math.abs(index-numElements) > index) {
			element =  head;
			for (int i = 0; i < index; i++) {
				element = element.getNext();
			}
		}
		else {
			element = tail;
			for (int i = numElements-1; i > index; i--) {
				element = element.getPrevious();
			}
		}
		element.setElement(put);
	}
	public int numElements() {
		return numElements;
	}
	public boolean isEmpty() {
		return numElements == 0;
	}
	public void insertFirst(E element) {
		// cria um novo n� e o torna o novo "head"
		DNode<E> newDNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newDNode;
		else {
			head.setPrevious(newDNode);
			newDNode.setNext(head);
			head = newDNode;
		}
		// ajusta o total de elementos
		numElements++;
	}
	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		String s = "[";
		DNode<E> prev = head;
		while (prev != null) {
			s += prev.getElement() + ", ";
			prev = prev.getNext();
		}
		s = s.substring(0, s.length()-2);
		s += "]";
		return s;
		
	}
	public void insertLast(E element) {
		// cria um novo n� e o torna o novo "tail"
		DNode<E> newDNode = new DNode<E>(element);
		if (isEmpty())
			head = tail = newDNode;
		else {
			tail.setNext(newDNode);
			newDNode.setPrevious(tail);
			tail = newDNode;
		}
		// ajusta o total de elementos
		numElements++;
	}
	public E removeFirst() throws UnderflowException {
		// verifica se h� pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException("Underflow Exception");
		// guarda uma refer�ncia tempor�ria ao elemento sendo removido
		//System.out.println(head);
		E element = head.getElement();
		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else {
		// ...sen�o, o segundo elemento passa a ser o "head"
			head = head.getNext();
			head.setPrevious(null);
		}
		// ajusta o total de elementos e retorna o removido
		numElements--;
		return element;
	}
	public E removeLast() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException("Underflow Exception");
		// guarda uma refer�ncia tempor�ria ao elemento sendo removido
		E element = tail.getElement();
		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else {
			// ...sen�o, � necess�rio percorrer o encadeamento
			// at� chegar ao n� imediatamente anterior ao �ltimo...
			DNode<E> prev = head;
			while (prev.getNext() != tail)
				prev = prev.getNext();
			// ...para poder torn�-lo o novo "tail"
				tail = prev;
				prev.setNext(null);
			}
			// ajusta o total de elementos e retorna o removido
			numElements--;
			return element;
		}
	
	public void insert(E element, int pos) {
		// verifica se a posi��o � v�lida
		if (pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();
		// casos especiais: inser��o no in�cio...
		if (pos == 0)
			insertFirst(element);
		else if (pos == numElements) // ... ou inser��o no final
			insertLast(element);
		else { // caso geral: inser��o no meio da lista
			// localiza o n� imediatamente anterior � posi��o
			// onde o novo ser� inserido
			DNode<E> prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();
			// cria um novo n� e o posiciona logo ap�s "prev",
			// ajustando os apontamentos e o total de elementos
			DNode<E> newDNode = new DNode<E>(element);
			newDNode.setNext(prev.getNext());
			newDNode.setPrevious(prev);
			prev.setNext(newDNode);
			numElements++;
		}
	}
	
	public void addAfter(E element, int pos) {
		// verifica se a posi��o � v�lida
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();
		// casos especiais: inser��o no in�cio...
		/*if (pos == -1)
			insertFirst(element);
			n�o faz sentido
			*/
		 if (pos == numElements-1) // ... ou inser��o no final
			insertLast(element);
		 
		else { // caso geral: inser��o no meio da lista
			// localiza o n� imediatamente anterior � posi��o
			// onde o novo ser� inserido
			DNode<E> prev = head;
			for (int i = 0; i < pos; i++)
				prev = prev.getNext();
			// cria um novo n� e o posiciona logo ap�s "prev",
			// ajustando os apontamentos e o total de elementos
			DNode<E> newDNode = new DNode<E>(element);
			newDNode.setNext(prev.getNext());
			newDNode.setPrevious(prev);
			prev.setNext(newDNode);
			numElements++;
		}
	}
	
	public void addBefore(E element, int pos) {
		// verifica se a posi��o � v�lida
		if (pos <= 0 || pos > numElements)
			throw new IndexOutOfBoundsException();
		// casos especiais: inser��o no in�cio...
		if (pos == 1)
			insertFirst(element);
		/*else if (pos == numElements+1) // ... ou inser��o no final
			insertLast(element);
			n�o faz sentido se o nodo nem existe ainda!*/
		else { // caso geral: inser��o no meio da lista
			// localiza o n� imediatamente anterior � posi��o
			// onde o novo ser� inserido
			DNode<E> prev = head;
			for (int i = 0; i < pos-2; i++)
				prev = prev.getNext();
			// cria um novo n� e o posiciona logo ap�s "prev",
			// ajustando os apontamentos e o total de elementos
			DNode<E> newDNode = new DNode<E>(element);
			newDNode.setNext(prev.getNext());
			newDNode.setPrevious(prev);
			prev.setNext(newDNode);
			numElements++;
		}
	}
	public E remove(int pos) throws UnderflowException {
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();
		// casos especiais: remo��o do in�cio...
		if (pos == 0)
			return removeFirst();
		else if (pos == numElements-1) // ... ou remo��o do final
			return removeLast();
		else { // caso geral: remo��o do meio da lista
			// localiza o n� imediatamente anterior � posi��o
			// de onde o elemento ser� removido
			DNode<E> prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();
			// guarda uma ref. tempor�ria ao elemento sendo removido
			E element = prev.getNext().getElement();
			// ajusta o encadeamento "pulando" o n� sendo removido
			prev.setNext(prev.getNext().getNext());
			if (prev.getNext() != null)
				prev.getNext().setPrevious(prev);
			// ajusta o total de elementos e retorna o removido
			numElements--;
			return element;
		}
	}
	public int search(E element) {
		// percorre o encadeamento at� encontrar o elemento
		DNode<E> current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
				return i;
			i++;
			current = current.getNext();
		}
		// se chegar at� aqui, � porque n�o encontrou
		return -1;
	}
	public void clear() throws UnderflowException {
		while (!isEmpty()) {
			removeFirst();
		}
	}
	public void clearFirstHalf() throws UnderflowException {
		clearFirstHalfR(0);
		numElements /= 2;
	}
	private void clearFirstHalfR(int i) throws UnderflowException {
		if (i < numElements/2) {
			head = head.getNext();
			head.setPrevious(null);
			clearFirstHalfR(++i);
		}
	}
	public void swap (int i, int j) {
		if (i != j) {
			E element = get(i);
			set(i, get(j));
			set(j, element);
		}
	}
	
}