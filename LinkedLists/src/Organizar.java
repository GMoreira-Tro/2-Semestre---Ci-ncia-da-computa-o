import java.util.Stack;

public class Organizar {
	public static int convertToInt(SinglyLinkedList<Integer> l) {
		int t = 0;
		for (int i = 0; i < l.numElements; i++) {
			t += l.get(i);
		}
		return t;
	}
	public static int convertToIntV2(SinglyLinkedList<Integer> l) {
		return convertToIntV2(l,0, l.head);
	}
	private static int convertToIntV2(SinglyLinkedList<Integer> l, int t, Node<Integer> n) {
		t += n.getElement();
		if (n.getNext() == null)
			return t;
		else {
			n = n.getNext();
			return convertToIntV2(l,t,n);
		}
	}
	
	public static Stack<Double> listToStack(SinglyLinkedList<Double> l) {
		Stack<Double> s = new Stack<Double>();
		for (int i = 0; i < l.numElements; i++) {
			if (l.get(i) < 0) {
				s.add(l.get(i));
			}
		}
		return s;
	}
	
	public static Stack<String> listToStackS(DoublyLinkedList<String> l) {
		return (listToStackS(l,0, new Stack<String>()));
	}
	private static Stack<String> listToStackS(DoublyLinkedList<String> l, int i, Stack s) {
		if (i == l.numElements)
			return s;
		s.add(l.get(l.numElements-i-1));
		return listToStackS(l,++i,s);
	}
	
	public static boolean taOrdenada (DoublyLinkedList<Integer> l) {
		if (l.numElements < 2)
			return true;
		return taOrdenada (l.head.getNext());
	}
	private static boolean taOrdenada (DNode<Integer> n) {
		if (n.getPrevious().getElement() > n.getElement())
			return false;
		else if (n.getNext() == null)
			return true;
		else
			return taOrdenada(n.getNext());
	}
	
	public static int pesquisaBinaria (DoublyLinkedList<Integer> l, int n) throws DesorderException {
		if (!taOrdenada(l))
			throw new DesorderException("Lista desordenada");
		else return pesquisaBinaria(l,n,0);
	}
	private static int pesquisaBinaria (DoublyLinkedList<Integer> l, int n, int i) {
		if (i == l.numElements)
			return -1;
		if (l.get(i).equals(n))
			return i;
		else if (l.get(i) > n)
			return -1;
		else
			return pesquisaBinaria(l,n,++i);
	}
}

