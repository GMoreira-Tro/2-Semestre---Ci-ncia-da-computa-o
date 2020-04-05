import java.util.List;

public class SinglyLinkedList<E> implements LinkedList<E> {
	Node<E> head;
	Node<E> tail;
	int numElements;
	
	public SinglyLinkedList() {
		head = tail = null;
		numElements = 0;
	}
	public E get(int index) {
		if (index == numElements - 1)
			return tail.getElement();
		else if (index < 0 || index >= numElements)
			throw new IndexOutOfBoundsException();
		Node<E> element =  head;
		for (int i = 1; i < index; i++) {
			element = element.getNext();
		}
		return element.getElement();
	}
	public int numElements() {
		return numElements;
	}
	public boolean isEmpty() {
		return numElements == 0;
	}
	public void insertFirst(E element) {
		// cria um novo n� e o torna o novo "head"
		Node<E> newNode = new Node<E>(element);
		if (isEmpty())
		head = tail = newNode;
		else {
		newNode.setNext(head);
		head = newNode;
		}
		// ajusta o total de elementos
		numElements++;
	}
	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		String s = "[";
		Node<E> prev = head;
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
		Node<E> newNode = new Node<E>(element);
		if (isEmpty())
		head = tail = newNode;
		else {
		tail.setNext(newNode);
		tail = newNode;
		}
		// ajusta o total de elementos
		numElements++;
	}
	public E removeFirst() throws UnderflowException {
		// verifica se h� pelo menos um elemento a ser removido
		if (isEmpty())
			throw new UnderflowException("Underflow Exception");
		// guarda uma refer�ncia tempor�ria ao elemento sendo removido
		E element = head.getElement();
		// se a lista possui somente 1 elemento, basta definir
		// "head" e "tail" para null...
		if (head == tail)
			head = tail = null;
		else
		// ...sen�o, o segundo elemento passa a ser o "head"
			head = head.getNext();
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
			Node<E> prev = head;
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
			Node<E> prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();
			// cria um novo n� e o posiciona logo ap�s "prev",
			// ajustando os apontamentos e o total de elementos
			Node<E> newNode = new Node<E>(element);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
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
			Node<E> prev = head;
			for (int i = 0; i < pos; i++)
				prev = prev.getNext();
			// cria um novo n� e o posiciona logo ap�s "prev",
			// ajustando os apontamentos e o total de elementos
			Node<E> newNode = new Node<E>(element);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
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
			Node<E> prev = head;
			for (int i = 0; i < pos-2; i++)
				prev = prev.getNext();
			// cria um novo n� e o posiciona logo ap�s "prev",
			// ajustando os apontamentos e o total de elementos
			Node<E> newNode = new Node<E>(element);
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
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
			Node<E> prev = head;
			for (int i = 0; i < pos-1; i++)
				prev = prev.getNext();
			// guarda uma ref. tempor�ria ao elemento sendo removido
			E element = prev.getNext().getElement();
			// ajusta o encadeamento "pulando" o n� sendo removido
			prev.setNext(prev.getNext().getNext());
			// ajusta o total de elementos e retorna o removido
			numElements--;
			return element;
		}
	}
	public int search(E element) {
		// percorre o encadeamento at� encontrar o elemento
		Node<E> current = head;
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
}