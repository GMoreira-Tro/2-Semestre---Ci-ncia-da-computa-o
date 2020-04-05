import java.util.*;

public class Main {

	public static <E> void main(String[] args) throws UnderflowException, DesorderException {
		SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
		DoublyLinkedList<Integer> dl = new DoublyLinkedList<Integer>();
		geraListaEncadeadeRandom(sl);
		geraListaEncadeadeRandom(dl);
		
		System.out.println("Exerc�cio 1:\n");
		System.out.println("Minha lista: " + sl);
		 System.out.println("Convertendo-a para inteiro: " + Organizar.convertToInt(sl));
		
		System.out.println("\nExerc�cio 2:\n");
		geraListaEncadeadeRandom(sl);
		System.out.println("Minha lista: " + sl + "\nSoma dos valores: " + Organizar.convertToIntV2(sl));
		
		System.out.println("\nExerc�cio 3:\n");
		geraListaEncadeadeRandom(sl);
		System.out.println("Minha lista: " + sl);
		int x = sl.get((int)(Math.random() * sl.numElements));
		SinglyLinkedList<Integer> sl2 = sl.divideBy((x));
		System.out.println("Elemento do split: " + x);
		System.out.println("Lista splitada: " + sl + "\nNova lista: " + sl2);
		
		System.out.println("\nExerc�cio 4:\n");
		SinglyLinkedList<Double> slD = new SinglyLinkedList<Double>();
		geraListaEncadeadeRandomD(slD);
		System.out.println("Minha lista: " + slD);
		Stack<Double> st = Organizar.listToStack(slD);
		System.out.println("Minha pilha: " + st);
		
		System.out.println("\nExerc�cio 5:\n");
		System.out.println("Minha lista: " + dl);
		int i = (int)(Math.random()*dl.numElements);
		int j = (int)(Math.random()*dl.numElements);
		dl.swap(i, j);
		System.out.println("Invertendo a posi��o '" + i + "' com a"
				+ " posi��o '" + j + "': " + dl);
		
		System.out.println("\nExerc�cio 6:\n");
		DoublyLinkedList<String> dlS= new DoublyLinkedList<String>();
		geraListaEncadeadeRandomS(dlS);
		System.out.println("Minha lista: " + dlS);
		Stack<String> stS = new Stack<String>();
		System.out.println("Minha pilha: " + (stS = Organizar.listToStackS(dlS)));
		
		System.out.println("\nExerc�cio 7:\n");
		geraListaEncadeadeRandom(dl);
		System.out.println("Minha lista: " + dl);
		System.out.println("Ela t� ordenada? " + Organizar.taOrdenada(dl));
		
		System.out.println("\nExerc�cio 8:\n");
		/*for (int z = 0; i  < dl.numElements-1; z++) {
			for (int y = 0; y < dl.numElements-1-z; y++) {
				if (dl.get(y) > dl.get(y+1)) {
					dl.swap(y, y+1);
				}
			}
		} Programa LITERALMENTE MORRE AQUI!!!!*/
		DoublyLinkedList<Integer> dl2 = new DoublyLinkedList<Integer>();
		for (int z = 0; z < 20; z++) {
			dl2.insertLast(z);
		}
		System.out.println("Minha lista: " + dl2);
		i = (int)(Math.random()*25);
		System.out.println("Inteiro: " + i);
		System.out.println("Posi��o do inteiro: " + Organizar.pesquisaBinaria(dl2,i));
		
		System.out.println("\nExerc�cio 9:\n");
		System.out.println("Sim, a implementa��o faz sentido, pois com uma lista ordenada,"
				+ " saberemos onde podemos parar de iter�-la para descobrir o que queremos!");
		
	}
	
	public static void geraListaEncadeadeRandom(DoublyLinkedList<Integer> l) throws UnderflowException {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.insertFirst((int)(Math.random()*100 - 50));
		}
	}
	public static void geraListaEncadeadeRandom(SinglyLinkedList<Integer> l) throws UnderflowException {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.insertFirst((int)(Math.random()*100) - 50);
		}
	}
	public static void geraListaEncadeadeRandomD(SinglyLinkedList<Double> l) throws UnderflowException {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.insertFirst((Math.random()*100) - 50);
		}
	}
	public static String geraStringRandom() {
		String s = "";
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			s += (char)(Math.random()*60 + 48);
		}
		return s;
	}
	public static void geraListaEncadeadeRandomS(DoublyLinkedList<String> l) throws UnderflowException {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.insertFirst(geraStringRandom());
		}
	}
	

}
