import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		StaticQueue<Integer> f = new StaticQueue<Integer>(5);
		StaticQueue<Character> f2 = new StaticQueue<Character>(5);
		System.out.println("Exercício 1:\n");
		foobar(f);
		System.out.println("\n(F) A ordem final dos elementos na fila (último println executado) é {2, 4, 3, 7, 9};)"
				+ "\n(V) Não acontece exceção alguma no código acima. ");
		
		System.out.println("\nExercício 2:\n");
		Queue<Integer> q1 = new LinkedBlockingQueue<Integer>();
		Queue<Integer> q2 = new LinkedBlockingQueue<Integer>();
		geraFilaRandom(q1);
		geraFilaRandom(q2);
		System.out.println("Fila 1 inicial: " + q1 + "\nFila 2 inicial: " + q2);
		Organizar.transferQueue(q1, q2);
		System.out.println("Fila 1 final: " + q1 + "\nFila 2 final: " + q2);
		
		System.out.println("\nExercício 3:\n");
		LinkedBlockingQueue<Character> go = new LinkedBlockingQueue<Character>();
		go.add('x');
		go.add('a');
		go.add('f');
		go.add('x');
		go.add('x');
		go.add('y');
		char c = ((char)(Math.random()*50 + 48));
		geraStaticaFilaRandom(f2);
		System.out.println("Fila: " + go + "\nCaractere: " + 'x');
		f2.flip();
		Organizar.exterminateFromQueue(go, 'x');
		//System.out.println(f2);
		System.out.println("Fila atualizada: " + go);
		
		System.out.println("\nExercício 4:\n");
		System.out.println("Fila: " + f2 + "\nCaractere: " + c);
		System.out.println("Contém o caractere? " + f2.contains(c));
		
		System.out.println("\nExercício 5:\n");
		System.out.println("Fila: " + f2);
		f2.flip();
		System.out.println("Fila invertida: " + f2);
		
		System.out.println("\nExercício 6:\n");
		StaticQueue<Character> f3 = new StaticQueue<Character>(500);
		geraStaticaFilaRandom(f2);
		f3.enqueue('w');
		System.out.println("Fila: " + f3);
		System.out.println("Fila que vai ser inserida: " + go);
		f3.enqueue(go);
		//f3.enqueue(go);
		System.out.println("Fila atualizada: " + f3);
		
		System.out.println("\nExercício 7:\n");
		System.out.println("Fila: " + f3);
		c = ((char)(Math.random()*50 + 48));
		f3.enqueueWithPriority(c);
		System.out.println("Inserindo o caracter '" + c +
				"' no início da fila: " + f3);
		
		System.out.println("\nExercício 8:\n");
		geraStaticaFilaRandom(f2);
		geraStaticaFilaRandom(f3);
		System.out.println("Fila 1: " + f2 + "\nFila 2: " + f3);
		System.out.println("Filas iguais? " + f3.equals(f2));
		
		System.out.println("\nExercício 9:\n");
		geraStaticaFilaRandom(f2);
		f3.clear();
		System.out.println("Fila 1: " + f2 + "\nFila 2: " + f3);
		System.out.println("Fila 2 copiada da lista 1: " + (f3 = f2.clone()));
		
		System.out.println("\nExercício 10:\n");
		f.clear();
		System.out.println("Fila vazia: " + f);
		try {
			f.enqueue(9);
			f.enqueue(8);
			f.enqueue(5);
			f.enqueue(2);
			// 9,8,5,2
			f.dequeue();
			f.dequeue();
			// 5,2
			f.enqueue(1);
			f.enqueue(2); 
			f.enqueue(3);
			// 5,2,1,2,3
			System.out.println("Overflow ao tentar colocar mais um valor!");
			f.enqueue(7);
			// Overflow aqui
		}
		catch (Exception e) {
			//System.err.println(e.toString());
		}
		System.out.println("Fila no final: " + f);
		f3 = new StaticQueue<Character>(50);
		System.out.println("\nExercício 11:\n");
		geraStaticaFilaRandom(f3);
		System.out.println("Fila: " + f3 + "\nCaractere: " + c);
		f2 = f3.split(c);
		System.out.println("Lista dividida: " + f3 + "\ne " + f2);
		
		System.out.println("\nExercício 12:\n");
		geraStaticaFilaRandom(f2);
		System.out.println("Fila: " + f2 + "\nCaractere: " + f2.front());
		f2.moveToBackAllOccurrencesOf(f2.front());
		System.out.println("Fila final: " + f2);
		
		System.out.println("\nExercício 13:\n");
		f3 = new StaticQueue<Character>(5);
		geraStaticaFilaRandom(f3);
		System.out.println("Fila: " + f3 + "\nCapacidade: " + f3.length());
		f3.ensureCapacity((int)(Math.random()*10+1));
		System.out.println("Nova capacidade: " + f3.length());
		System.out.println("Lista mudou pela capacidade? " + f3);
	}
	
	public static void foobar(StaticQueue<Integer> f) {
		try {
			f.enqueue(1);
			f.enqueue(3);
			f.enqueue(5);
			f.enqueue(7);
			f.enqueue(9);
			System.out.println(f);
		} 
		catch (OverflowException e) {
			System.out.println("aaaa");
		}
		
		try {
			f.dequeue();
			//System.out.println(f);
			f.dequeue();
			//System.out.println(f);
		} 
		catch (UnderflowException e) {
			System.out.println("aaa");
		}
		try {
			f.enqueue(2);
			//System.out.println(f);
			f.enqueue(4);
			//System.out.println(f);
		} 
		catch (OverflowException e) {
			System.out.println("aaaa");
		}
		try {
			f.dequeue();
		} 
		catch (UnderflowException e) {
			System.out.println("aaaaaa");
		}
		try {
			f.enqueue(3);
		} 
		catch (OverflowException e) {
			System.out.println("aaaaa");
		}
		System.out.println(f);
	}
	
	public static void geraFilaRandom(Queue<Integer> q) {
		q.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			q.add((int)(Math.random()*16));
		}
	}
	
	public static void geraFilaRandomC(Queue<Character> q) {
		q.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			q.add((char)(Math.random()*50 + 48));
		}
	}
	
	public static <E> void geraStaticaFilaRandom(StaticQueue<Character> s) throws Exception {
		s.clear();
		for (int i = 0; i < s.length(); i++) {
			s.enqueue((char)(Math.random()*50 + 48));
		}
	}

}
