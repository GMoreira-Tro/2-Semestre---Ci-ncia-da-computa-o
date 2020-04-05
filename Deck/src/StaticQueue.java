public class StaticQueue<E> implements MyQueue<E>{
	protected int first,last;
	protected E[] elements;
	
	public StaticQueue(int maxSize) {
		elements = (E[]) new Object[maxSize];
		first = last = -1;
	}
	
	public boolean isEmpty() {
		return first == -1;
	}
	
	public boolean isFull() {
		return last == ((last + 1) % elements.length);
	}
	
	public int numElements() {
		int x,y;
		if (first > last) {
			x = first;
			y = last;
		}
		else {
			x = last;
			y = first;
		}
		if (isEmpty())
			return 0;
		else {
			int n = elements.length;
			return ((n + x - y) % n)+1;
		}
	}
	
	public E front() throws UnderflowException {
		if(isEmpty())
			throw new UnderflowException();
		
		return elements[first];
	}
	
	public E back() throws UnderflowException {
		if(isEmpty())
			throw new UnderflowException();
		
		return elements[last];
	}
	
	public void enqueue(E element) throws OverflowException {
		if (isFull())
			throw new OverflowException();
		else if (last == -1)
			first = last = 0;
		else
			last = (last+1) % elements.length;
		
		elements[last] = element;
	}
	
	public E dequeue() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = elements[first];
		elements[first] = null;
		if (first == last)
			first = last = -1;
		else
			first = (first + 1) % elements.length;
		return element;
		
	}
	
	public String toString() {		
		String s = "[";
		for(int i = 0; i < elements.length  && elements[(first+i) % elements.length] != null; i++) {
			s += "'" + elements[(i+first)% elements.length] + "', ";
		}
		
		if(s.length() > 1)
			s = s.substring(0, s.length()-2);
		s += "]";
		return s;
	}
	
	public void clear() {
		for (int i = 0; i < elements.length && elements[(first+i) % elements.length] != null; i++) {
			elements[i] = null;
		}
	}
	
	public int length() {
		return elements.length;
	}
	
	public E get(int index) {
		return (E) elements[(first+index) % elements.length];
	}
	
}
