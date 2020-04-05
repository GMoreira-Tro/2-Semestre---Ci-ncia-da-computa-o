import java.util.ArrayList;
import java.util.List;

public class Organizar<E> {
	
	public static Integer[] evenNumbers(List<Integer> lista) {
		Integer t = 0;
		
		for (int i = 0; i < lista.size(); i++) {
			if ((lista.get(i) & 1 ) == 0) {
				t++;
			}
		}
		Integer v[] = new Integer[t];
		t = 0;
		for (int i = 0; i < lista.size(); i++) {
			if ((lista.get(i) & 1 ) == 0) {
				v[t] = lista.get(i);
				t++;
			}
		}
		
		
		return v;
	}
	
	public static List<Character> mergeLists(List<Character> lista1, List<Character> lista2) {
		List<Character> inter = new ArrayList<Character>();
		for (int i = 0; i < lista1.size() || i < lista2.size(); i++) {
			try {
				lista1.get(i);
				lista2.get(i);
				inter.add(lista1.get(i));
				inter.add(lista2.get(i));
			}
			catch (Exception e) {
				try {
					inter.add(lista1.get(i));
				}
				catch (Exception ei) {
					inter.add(lista2.get(i));
				}
			}
		}
		return inter;
	}
	
	public static void prependList(List<Double> lista1, List<Double> lista2) {
		
		List<Double> aux = new ArrayList<Double>();
		for (int i = 0; i <  lista1.size(); i++) {
			aux.add(lista1.get(i));
		}
		for (int i = 0; i < lista2.size(); i++) {
			lista1.add(null);
		}	
		for (int i = 0; i < lista2.size(); i++) {
			lista1.set(i, lista2.get(i));
		}
		for (int i = lista2.size(); i < lista1.size(); i++) {
			lista1.set(i,aux.get(i-lista2.size()));
		}
			
	}
	
	public static <E> boolean remove (E element, List<E> lista) {
		int i = findElement(element, lista);
		if (i > -1) {
			lista.remove(i);
			System.out.println("Elemento da posição '" + i + "' removido!");
			return true;
		}
		return false;
	}
	
	private static <E> int findElement(E element, List<E> lista) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(element)) return i;
		}
		return -1;
	}
	
	public static <E> boolean insertAfter(E obj1, E obj2, List<E> lista) {
		int index = findElement (obj1, lista);
		if (index < 0) {
			System.out.println("O primeiro elemento não foi encontrado");
			return false;
		}
			lista.add(null);
			for (int i = lista.size()-1; i > index+1; i--) {
				lista.set(i, lista.get(i-1));
			}
			lista.set(index+1, obj2);
			System.out.println("Elemento inserido na posição '" + index + "'!");
			return true;
	}
	
	public static <E> boolean swap(int p1, int p2, List<E> lista) {
		try {
			E aux = lista.get(p1);
			lista.set(p1, lista.get(p2));
			lista.set(p2, aux);
			return true;
		}
		catch (IndexOutOfBoundsException e) {
			System.out.println("Índices inválidos!");
			return false;
		}
	}
	
	public static<E> void flip(List<E> lista) {
		for (int i = 0; i < lista.size()/2; i++) {
			E aux = lista.get(lista.size()-i-1);
			lista.set(lista.size()-i-1, lista.get(i));
			lista.set(i,aux);		
		}
	}
	
	public static <E> boolean insertAfter(E obj1, List<E> lista2, List<E> lista) {
		int index = findElement (obj1, lista), t = lista.size();
		if (index < 0) {
			System.out.println("O elemento não foi encontrado");
			return false;
		}
			for (int i = 0; i < lista2.size(); i++) {
				lista.add(null);
			}
			for (int i = lista.size()-1; i > index+lista2.size(); i--) {
				lista.set(i, lista.get(i-lista2.size()));
			}
			for (int i = 0; i < lista2.size(); i++) {
				lista.set(index+i+1, lista2.get(i));
			}
			System.out.println("Lista inserida na posição '" + index + "'!");
			return true;
	}
	
	public static <E> void deadUp (E element, List<E> lista) {
		boolean f = false;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).equals(element)) {
				if (f) {
					lista.remove(i);
					i--;
				}
				f = true;
			}
		}
	}
	
	public static <E> boolean equals (List<E> l1, List<E> l2) {
		try {
			for (int i = 0; i < l1.size() || i < l2.size(); i++) {
				if (!(l1.get(i).equals(l2.get(i))))
					return false;
			}
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public static <E> List<E> clone (List<E> lista) {
		List<E> BunshinNoJutsu = new ArrayList<E>();
		for (int i = 0; i < lista.size(); i++) {
			BunshinNoJutsu.add(lista.get(i));
		}
		return BunshinNoJutsu;
	}
	
	public static <E> int remove (int start, int end, List<E> lista) {
		if (start < 0 || end < 0 || start > lista.size() || end > lista.size()) {
			System.out.println("Índices inválidos");
			return 0;
		}
		int all = end - start, t = all;
		for (int i = 0; i < all; i++) {
			lista.remove(start);
		}
		if (t > 0) return t;
		else return 0;
	}
	
	public static <E> List<E> split (int p, List<E> lista) {
		if (p < 0 || p > lista.size()) {
			System.out.println("Posição inválida!");
			return null;
		}
		List<E> lS = new ArrayList<E>();
		int t = lista.size();
		for (int i = 0; i < t-p; i++) {
			lS.add(lista.get(p));
			lista.remove(p);
		}
		return lS;
	}
}
