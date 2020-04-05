import java.util.*;
import java.util.concurrent.*;
import java.lang.*;

public class Main {

	public static <E, T> void main(String[] args) {
		List<Integer> l1 = new ArrayList<Integer>();
		List<Character> l2 = new ArrayList<Character>();
		geraListaCRandom(l2);
		geraListaIRandom(l1);
		
		System.out.println("Minhas duas listinhas :3:\n" + l1 + "\n" + l2);
		Object[] a1 =  l1.toArray();
		System.out.println("\nMeu array primitivo que eu fiz usando o toArray():");
		for (int i = 0; i < a1.length; i++) {
			System.out.print(a1[i] + " ");
		}
		
		int x = l1.get(0);
		System.out.println("\n\nA lista 1 tem o elemento: " + x + "? " + l1.contains(x));
		
		l2.sort(null);
		System.out.println("\nLista 2 ordenada: " + l2);
		l2.sort(Collections.reverseOrder());
		System.out.println("Lista 2 ordenada ao contrário: " + l2);
		
		List<Character> l3 = new ArrayList<Character>();
		geraListaCRandom(l3);
		System.out.println("\nLista 3: " + l3);
		l2.addAll(l3);
		System.out.println("Lista 2 dando addAll da lista 3: " + l2);
		l2.addAll(1,l2);
		System.out.println("Lista 2 dando addAll da própria lista 2 na posição '1':");
		System.out.println(l2);
		
		l2.sort(null);
		System.out.println("\nVamo ordenar isso aí que tá feio:\n" + l2);
		
		System.out.println("\nL2 contém l3? " + l2.containsAll(l3));
		System.out.println("E l2? " + l2.containsAll(l2));
		System.out.println("E l1? " + l2.containsAll(l1));		
		System.out.println("A lista 1 é igual ao array? " + l1.equals(a1));
		
		MyStack<T> s = Organizar.fazPilhaEstatica((ArrayList<E>) l1);
		System.out.println("\nMinha pilha criada a partir da lista 1: " + s);
		
		l1.removeIf(osp -> osp > 50);
		System.out.println("\nRemovendo todos o elementos maiores que 50 da lista 1:\n" + l1);
		l2.removeAll(l3);
		System.out.println("Removendo a lista 3 da lista 2:\n" + l2);
		l2.removeAll(l2);
		System.out.println("Dando clear na lista 2:\n" + l2);
		System.out.println("Classe da lista 1: " + l1.getClass());
		
	}
	public static void geraListaIRandom(List<Integer> l) {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.add((int)(Math.random()*100));
		}
	}
	public static void geraListaCRandom(List<Character> l) {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.add((char)(Math.random()*49 + 60));
		}
	}
	public static void geraFilaCRandom(Queue<Character> l) {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.add((char)(Math.random()*49 + 60));
		}
	}
	public static void geraListaProdutoRandom(List<Produto> l) {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.add(new Produto(geraStringRandom(),(Math.random()*1000)));
		}
	}
	public static void geraFilaProdutoRandom(Queue<Produto> l) {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.add(new Produto(geraStringRandom(),(Math.random()*1000)));
		}
	}
	public static String geraStringRandom() {
		String s = "";
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			s += (char)(Math.random()*60 + 48);
		}
		return s;
	}

}
