
public class StaticDeck<E> extends StaticQueue {
	
	public StaticDeck(int maxSize) {
		super(maxSize);
	}
	
	public E destack() throws Exception {
		if (isEmpty())
			throw new UnderflowException();
		E element = (E) elements[last];
		elements[last] = null;
		
		try {
			if (first == last)
				first = last = -1;
			else
				last = (last - 1) % elements.length;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			
		}
		return element;
		
	}
	
	public void enstack(E element) throws Exception {
		
		try {
			if (isFull())
				throw new OverflowException();
			else if (first == -1)
				first = last = 0;
			else
				first = (first-1) % elements.length;
			elements[first] = element;
		}
		catch (Exception e) {
			throw new UnderflowException();
		}
	}
	
}
