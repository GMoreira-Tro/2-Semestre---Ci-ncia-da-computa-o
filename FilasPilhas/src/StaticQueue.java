import java.lang.Character.Subset;

public class StaticQueue<E> implements Queue<E>{
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
		if (isEmpty())
			return "Empty queue.";
		
		int x = first,y = last;
		
		
		String s = "[";
		for(int i = 0; i < numElements(); i++) {
			s += elements[(i+first%numElements())] + ",";
		}
		s = s.substring(0, s.length()-1);
		s += "]";
		return s;
	}
	
	public void bubbleSort() {
		E aux;
		for (int i = 0; i < numElements()-1; i++) {
			for (int j = 0; j < numElements()-i-1; j++) {
				if (((int)elements[(j+first%numElements())]) > ((int)elements[(j+first+1%numElements())])) {
					aux = elements[(j+first%numElements())];
					 elements[(j+first%numElements())] = elements[(j+first%numElements())+1];
					 elements[(j+first%numElements())+1] = aux;
				}
			}
		}
	}
	
}
