import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StaticQueue<T> implements MyQueue<T>{
	//Index to the first element
	protected int first;
	//Index to the last element
	protected int last;
	// Generic array used to store the elements
	protected T elements[];
	
	public StaticQueue(int maxSize) {
		elements = (T[]) new Object[maxSize];
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
	public T front() throws UnderflowException{
		if (isEmpty())
			throw new UnderflowException ("Underflow try at queue.");
		return elements[first];
	}
	@Override
	public T back() throws UnderflowException {
		if (isEmpty())
		throw new UnderflowException ("Underflow try at queue.");
		return elements[last];
		}
	@Override
	public void enqueue(T element) throws OverflowException {
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
	public T dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException("Underflow try at queue.");
		T element = elements[first];
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
	
	public T get(int index) {
		return (T) elements[(first+index) % elements.length];
	}
	
	public void clear() throws UnderflowException {
		int x = numElements();
		for (int i = 0; i < x; i++) {
			dequeue();
		}
	}
	
	public boolean contains(T element) {
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] 
				!= null; i++) {
			if (get(i).equals(element))
				return true;
		}
		return false;
	}
	
	public void flip() {
		T aux;
		for (int i = 0; i < numElements()/2; i++) {
			aux = elements[(first+i) % elements.length];
			elements[(first+i) % elements.length] = 
					elements[(elements.length+last-i) % elements.length];
			elements[(elements.length+last-i) % elements.length] = aux;
		}
	}
	
	public void enqueue(Queue<T> q) throws Exception {
		ArrayList<T> aux = new ArrayList<T>();
		for (Object e: q)
			aux.add((T) e);
		
		for (int i = 0; i < aux.size(); i++) {
			if (isFull())
				throw new OverflowException("Overflow try at queue.");
			else {
				if (last == -1)
					first = last = 0;
				else
					last = (last + 1) % elements.length;
				elements[last] = (T) aux.get(i);
			}
		}
	}
	
	public void enqueueWithPriority(T element) throws Exception {
		first = (elements.length+first-1) % elements.length;
		elements[first] = element;
	}
	
	public boolean equals(StaticQueue<T> q) {
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] 
				!= null; i++) {
			if (!get(i).equals(q.get(i)))
				return false;
		}
		return true;
	}
	
	public StaticQueue<T> clone(){
		StaticQueue<T> aux = new StaticQueue<T>(elements.length);
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] != null; i++) {
			try {
				aux.enqueue(get(i));
			} catch (OverflowException e) {
				e.printStackTrace();
			}
		}
		return aux;
	}
	
	public StaticQueue<T> split (T element) throws Exception {
		StaticQueue<T> s = new StaticQueue<T>(elements.length);
		List<T> aux = new ArrayList<T>();
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
	
	public void moveToBackAllOccurrencesOf(T element) throws Exception {
		List<T> aux = new ArrayList<T>();
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
			enqueue((T) e);
		}
		
	}
	
	public void ensureCapacity(int capacity) throws Exception {
		Object[] array = new Object[capacity];
		for (int i = 0; (i < numElements() && i < capacity)
				&& elements[(first+i) % elements.length] 
				!= null; i++) {
			array[i] = get(i);
		}
		elements = (T[]) array;
		
	}
}
