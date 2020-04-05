import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class APIsJava {

	public static void main(String[] args) {
		Stack<Produto> st = new Stack<Produto>();
		LinkedBlockingQueue<Produto> qu = new LinkedBlockingQueue<Produto>();
		LinkedBlockingDeque<Produto> dk = new LinkedBlockingDeque<Produto>();
		Main.geraListaProdutoRandom(st);
		Main.geraFilaProdutoRandom(qu);
		Main.geraFilaProdutoRandom(dk);
		System.out.println("Minha pilha: " + st);
		System.out.println("\nMinha fila: " + qu);
		System.out.println("\nMeu deque: " + dk);
		System.out.println("\nPrimeiro e último elementos da pilha: " + 
		st.get(0)  + st.get(st.size()-1));
		qu.removeIf(filter -> filter.getPreco() > 500);
		System.out.println("\nRemovendo os elemento da fila cujo preço é maior que 500:\n" + 
		qu);
		dk.removeAll(dk);
		System.out.println("\nRemovendo todo o meu deque:\n" + dk);
		Main.geraFilaProdutoRandom(dk);
		System.out.println("\nRefiz o deque:\n" + dk);
		Queue<Produto> q2 = Collections.asLifoQueue(dk);
		System.out.println("\nFiz um asLifoQueue do deque pra queue, veremos o que" + 
		" acontece:\n" + q2);
		Collections.sort(st, new SortByRoll());
		System.out.println("\nOrdenando a pilha pelo preço:\n" + st);
		st.sort(null);
		System.out.println("\nOrdenando a pilha pelo nome:\n" + st);
	}

}
