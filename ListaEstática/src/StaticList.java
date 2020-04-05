
public class StaticList<E> implements List<E> {

	private E[] elements;
	private int numElements;
	
	public StaticList(){
		this.numElements = 0;
		this.elements = (E[]) new Object[20];
	}
	
	public int numElements(){
		return numElements;
	}
	
	public boolean isEmpty(){
		return numElements == 0;
	}
	
	public boolean isFull(){
		return numElements == elements.length;
	}
	
	public void insert(E element, int pos) throws IndexOutOfBoundsException{
		if(pos < 0 || pos > numElements) throw new IndexOutOfBoundsException();
		if(isFull()){
			//aumenta o array elements
			E[] aux = (E[]) new Object[elements.length*2];
			for(int i=0; i<elements.length; i++)
				aux[i] = elements[i];
			elements = aux;
		}
		for(int i=numElements-1; i>=pos; i--)
			elements[i+1] = elements[i];
		
		elements[pos] = element;
		
		numElements++;
	}
	
	public E remove(int pos){
		return null;
	}
	
	public E get(int pos) throws IndexOutOfBoundsException{
		if(pos < 0 || pos >= numElements) throw new IndexOutOfBoundsException();
		return elements[pos];
	}
	
	public int search(E element){
		for(int i=0; i<numElements; i++)
			if(elements[i].equals(element))
				return i;
		return -1;
	}
	
	public static void main(String[] args) {
		StaticList<Integer> lista = new StaticList<>();
		lista.insert(1, 0);
		lista.insert(2, 0);
		lista.insert(3, 0);
		lista.insert(4, 0);
		lista.insert(5, 2);
		for(int i=0; i<lista.numElements(); i++)
			System.out.println(lista.get(i));
	}
	
	public void merge(List<E> l) {
		for (int i = 0; i < ((StaticList<E>)l).numElements; i++) {
			insert(l.get(i), numElements());
		}
	}
	
	public List<E> subList (int i, int j) {
		int x = 0;
		List<E> lista = new StaticList<E>();
		if (i > j) return null;
		else if (i < 0 || i >= elements.length) return null;
		else if (j < 0 || j >= elements.length) return null;
		
		else {
			for ( ; i <= j; i++) {
				lista.insert(elements[i], x);
				x++;
			}
			return lista;
		}
	}
}
