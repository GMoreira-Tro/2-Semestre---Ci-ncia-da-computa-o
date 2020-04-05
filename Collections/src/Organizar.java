import java.util.*;

public class Organizar {
	public static <T, E> MyStack<T> fazPilhaEstatica(ArrayList<E> l) {
		return PfazPilhaEstatica(l, new MyStack(), 1);
	}
	private static <T, E> MyStack<T> PfazPilhaEstatica(ArrayList<E> l, MyStack<T> s, int i) {
		if (i == l.size()+1)
			return s;
		s.push(l.get(l.size()-i));
		return PfazPilhaEstatica(l,s, ++i);
	}
}
