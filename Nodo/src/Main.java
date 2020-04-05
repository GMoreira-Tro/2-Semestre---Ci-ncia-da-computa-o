
public class Main {

	public static <E> void main(String[] args) throws UnderflowException {
		SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
		System.out.println("Lista vazia? " + l.isEmpty() + "\n" + l);
		try {
			l.insert(4, 0);
			l.insert(5, 1);
			l.insertFirst(10);
			l.insertLast(8);
			l.insert(7, 1);
			System.out.println("\nSe liga na nova lista: " + l);
			System.out.println("\nTestando meu get:\n");
			System.out.println("Pegando posição 4: " + l.get(4));
			System.out.println("Pegando posição 0: " + l.get(0));
			System.out.println("Pegando posição 2: " + l.get(2));
			System.out.println("Dando exception pra posição 5: ");
			System.out.println(l.get(5));
		}
		catch (Exception e) {
			System.out.println("Ratiou, deu exception!");
		}
		l.addAfter(66, 4);
		l.addAfter(72, 5);
		l.addAfter(61, 2);
		l.addAfter(55, 0);
		System.out.println("Let's see o meu addAfter:\n" + l);
		try {
			System.out.println("\nVery good, mas tem que dar exception agora:");
			l.addAfter(5, l.numElements);
		}
		catch(Exception e) {
			System.out.println("Some exception here!");
		}
		System.out.println("\nAddBefore time!\n");
		l.addBefore(99, 1);
		l.addBefore(100, l.numElements);
		System.out.println(l);
		try {
			System.out.println("\nNão dá pra inserir antes da primeira, claro:");
			l.addBefore(92, 0);
		}
		catch (Exception e) {
			System.out.println("Some exception here!");
		}
		System.out.println("\nRemovendo a última, antepenúltima e segunda posições:");
		l.remove(l.numElements-1);
		l.removeLast();
		l.remove(1);
		System.out.println(l);
		System.out.println("\nO Gran Finale é a mágica do meu CLEAR:");
		l.clear();
		System.out.println(l);
		System.out.println("\nBIS! BIS! Geranado uma lista nova!");
		geraListaEncadeadeRandom(l);
		System.out.println(l);
		
	}
	
	public static void geraListaEncadeadeRandom(SinglyLinkedList<Integer> l) throws UnderflowException {
		l.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			l.insertFirst((int)(Math.random()*100));
		}
	}

}
