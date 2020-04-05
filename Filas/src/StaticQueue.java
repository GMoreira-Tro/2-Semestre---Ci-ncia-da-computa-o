import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StaticQueue<E> implements MyQueue<E>{
	//Index to the first element
	protected int first;
	//Index to the last element
	protected int last;
	// Generic array used to store the elements
	protected E elements[];
	
	public StaticQueue(int maxSize) {
		elements = (E[]) new Object[maxSize];
		first = last = -1;
	}
	
	@Override
	public int numElements() {
		// TODO Auto-generated method stub
		if (isEmpty()) 
			return 0;
		else {
			int n = elements.length;
			return ((n + this.last - this.first) % n) + 1;
		}
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return first == -1;
	}
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return first == ((last + 1) % elements.length);
	}
	@Override
	public E front() throws UnderflowException{
		if (isEmpty())
			throw new UnderflowException ("Underflow try at queue.");
		return elements[first];
	}
	@Override
	public E back() throws UnderflowException {
		if (isEmpty())
		throw new UnderflowException ("Underflow try at queue.");
		return elements[last];
		}
	@Override
	public void enqueue(E element) throws OverflowException {
		if (isFull())
		throw new OverflowException("Overflow try at queue.");
		else {
			if (last == -1)
			first = last = 0;
			else
			last = (last + 1) % elements.length;
			elements[last] = element;
		}
	}
	@Override
	public String toString() {
		if (isEmpty())
			return "[]";
		
		String s = "[";
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] != null; i++) {
			s += elements[(first+i) % elements.length] + ", ";
		}
		
		s = s.substring(0, s.length()-2);
		s += "]";
		return s;
	}

	@Override
	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException("Underflow try at queue.");
		E element = elements[first];
		elements[first] = null; // p/ coleta de lixo
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;
		return element;
	}
	
	public int length() {
		return elements.length;
	}
	
	public E get(int index) {
		return (E) elements[(first+index) % elements.length];
	}
	
	public void clear() throws UnderflowException {
		int x = numElements();
		for (int i = 0; i < x; i++) {
			dequeue();
		}
	}
	
	public boolean contains(E element) {
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] 
				!= null; i++) {
			if (get(i).equals(element))
				return true;
		}
		return false;
	}
	
	public void flip() {
		E aux;
		for (int i = 0; i < numElements()/2; i++) {
			aux = elements[(first+i) % elements.length];
			elements[(first+i) % elements.length] = 
					elements[(elements.length+last-i) % elements.length];
			elements[(elements.length+last-i) % elements.length] = aux;
		}
	}
	
	public void enqueue(Queue<E> q) throws Exception {
		ArrayList<E> aux = new ArrayList<E>();
		for (Object e: q)
			aux.add((E) e);
		
		for (int i = 0; i < aux.size(); i++) {
			if (isFull())
				throw new OverflowException("Overflow try at queue.");
			else {
				if (last == -1)
					first = last = 0;
				else
					last = (last + 1) % elements.length;
				elements[last] = (E) aux.get(i);
			}
		}
	}
	
	public void enqueueWithPriority(E element) throws Exception {
		first = (elements.length+first-1) % elements.length;
		elements[first] = element;
	}
	
	public boolean equals(StaticQueue<E> q) {
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] 
				!= null; i++) {
			if (!get(i).equals(q.get(i)))
				return false;
		}
		return true;
	}
	
	public StaticQueue<E> clone(){
		StaticQueue<E> aux = new StaticQueue<E>(elements.length);
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] != null; i++) {
			try {
				aux.enqueue(get(i));
			} catch (OverflowException e) {
				e.printStackTrace();
			}
		}
		return aux;
	}
	
	public StaticQueue<E> split (E element) throws Exception {
		StaticQueue<E> s = new StaticQueue<E>(elements.length);
		List<E> aux = new ArrayList<E>();
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] 
				!= null; i++) {
			aux.add(get(i));
		}
		clear();
		int i;
		for (i = 0; i < aux.size() && !aux.get(i).equals(element); i++) {
			enqueue(aux.get(i));
		}
		try {
			enqueue(aux.get(i));
			i++;
		}
		catch(Exception e) {
			
		}
		for (; i < aux.size(); i++) {
			s.enqueue(aux.get(i));
		}
		return s;
	}
	
	public void moveToBackAllOccurrencesOf(E element) throws Exception {
		List<E> aux = new ArrayList<E>();
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] 
				!= null; i++) {
			aux.add(get(i));
		}
		clear();
		for (int i = 0; i < aux.size(); i++) {
			if (aux.get(i).equals(element)) {
				aux.add(aux.get(i));
				aux.remove(i);
			}
		}
		
		for (Object e : aux) {
			enqueue((E) e);
		}
		
	}
	
	public void ensureCapacity(int capacity) throws Exception {
		Object[] array = new Object[capacity];
		for (int i = 0; (i < numElements() && i < capacity)
				&& elements[(first+i) % elements.length] 
				!= null; i++) {
			array[i] = get(i);
		}
		elements = (E[]) array;
		
	}
}
