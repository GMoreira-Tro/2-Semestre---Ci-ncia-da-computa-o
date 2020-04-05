import java.util.*;

public class Main {
	public  static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Exercício 1:\n");
		System.out.println("Lista 1:");
		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			lista.add((int)(Math.random()*100));
			System.out.println(lista.get(i));
		}
		//System.out.println("\nLista 2:\n");
		List<Integer> lista2 = new ArrayList<Integer>();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			lista2.add((int)(Math.random()*100));
			//System.out.println(lista2.get(i));
		}
		
		System.out.println("\nLista de pares:\n");
		Integer v[] = Organizar.evenNumbers(lista);
		for (int i = 0; i < v.length; i++) {
			System.out.println(v[i]);
		}
		System.out.println("\nExercício 2:\n");		
		List<Character> ch1 = new ArrayList<Character>(), ch2 = new ArrayList<Character>();
		
		System.out.println("Lista 1:\n");
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			ch1.add((char)(Math.random()*61 + 47));
			System.out.println(ch1.get(i));
		}
		
		System.out.println("\nLista 2:\n");
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			ch2.add((char)(Math.random()*61 + 47));
			System.out.println(ch2.get(i));
		}
		
		System.out.println("\nLista intercalada:\n");
		List<Character> lista3 = Organizar.mergeLists(ch1, ch2);
		for (int i = 0; i < lista3.size(); i++) {
			System.out.println(lista3.get(i));
		}
		
		System.out.println("\nExercício 3:\n");
		List<Double> d1 = new ArrayList<Double>(), d2 = new ArrayList<Double>();
		
		System.out.println("Lista 1:\n");
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			d1.add(Math.random()*100);
			System.out.printf("%.2f\n",d1.get(i));
		}
		
		System.out.println("\nLista 2:\n");
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			d2.add(Math.random()*100);
			System.out.printf("%.2f\n",d2.get(i));
		}
		
		Organizar.prependList(d1, d2);
		System.out.println("\nCopiando a lista 2 para o início da lista 1:\n");
		for (int i = 0; i < d1.size(); i++) {
			System.out.printf("%.2f\n",d1.get(i));
		}
		
		System.out.println("\nExercício 4:\n");
		List<Character> ex4 = new ArrayList<Character>();
		
		System.out.println("Lista:\n");
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			ex4.add((char)(Math.random()*61 + 47));
			System.out.println(ex4.get(i));
		}
		System.out.println();
		char cat,cat2;
		while (true) {
			try {
				System.out.println("Digita o caractere a ser removido da lista:");
				cat = scan.nextLine().charAt(0);
				break;
			}
			catch (Exception e) {
				
			}
		}
		if(!Organizar.remove(cat, ex4)) {
			System.out.println("Elemento não encontrado");
		}
		else {
			System.out.println("\nLista Final:\n");
			for (int i = 0; i < ex4.size(); i++) {
				System.out.println(ex4.get(i));
			}
		}
		
		System.out.println("\nExercício 5:\n");
		System.out.println("Para a lista do exercício anterior,"
				+ "digite o caractere 1: ");
		while (true) {
			try {
				cat = scan.nextLine().charAt(0);
				break;
			}
			catch (Exception e) {
				
			}
		}
		System.out.println("\nAgora digite o caractere 2:");
		while (true) {
			try {
				cat2 = scan.nextLine().charAt(0);
				break;
			}
			catch (Exception e) {
				
			}
		}
		if(Organizar.insertAfter(cat, cat2, ex4)) {
			System.out.println("\nLista Final:\n");
			for (int i = 0; i < ex4.size(); i++) {
				System.out.println(ex4.get(i));
			}
		}
		
		System.out.println("\nExercício 6:\n");
		int p1,p2;
		while (true) {
			try {
				System.out.println("Bora continuar com a mesma lista, digita"
						+ " o primeiro índice: ");
				p1 = Integer.parseInt(scan.nextLine());
				System.out.println("Agora digita o segundo índice:");
				p2 = Integer.parseInt(scan.nextLine());
				break;
			}
			catch (Exception e) {
				
			}
		}
		
		if (Organizar.swap(p1, p2, ex4)) {
			System.out.println("\nLista Final:\n");
			for (int i = 0; i < ex4.size(); i++) {
				System.out.println(ex4.get(i));
			}
		}
		
		System.out.println("\nExercício 7:\n");
		Organizar.flip(ex4);
		System.out.println("Essa lista tá boa, toma ela invertida:\n");
		for (int i = 0; i < ex4.size(); i++) {
			System.out.println(ex4.get(i));
		}
		
		System.out.println("\nExercício 8:\n");
		System.out.println("Lista 1:\n");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		System.out.println("\nLista 2 (vai ser inserida depois de um elemento da lista 1):\n");
		for (int i = 0; i < lista2.size(); i++) {
			System.out.println(lista2.get(i));
		}
		System.out.println();
		while (true) {
			try {
				System.out.println("Digita o inteiro da lista 1"
						+ " que a lista 2 vai ser inserida após:");
				p1 = Integer.parseInt(scan.nextLine());
				break;
			}
			catch (Exception e) {
				
			}
		}
		if(Organizar.insertAfter(p1, lista2, lista)) {
			System.out.println("\nLista Final:\n");
			for (int i = 0; i < lista.size(); i++) {
				System.out.println(lista.get(i));
			}
		}
		
		System.out.println("\nExercício 9:\n");
		List<Character> listaNova = new ArrayList<Character>();
		
		for (int i = 0; i < (int)(Math.random()*20+1); i++) {
			listaNova.add((char)(Math.random()*10 + 50));
		}
		System.out.println("Lista nova:\n");
		for (int i = 0; i < listaNova.size(); i++) {
			System.out.println(listaNova.get(i));
		}
		System.out.println();
		while (true) {
			try {
				System.out.println("Digita o caractere da lista nova"
						+ " que serão removidas as múltiplas ocorrências:");
				cat = scan.nextLine().charAt(0);
				break;
			}
			catch (Exception e) {
				
			}
		}
		Organizar.deadUp(cat, listaNova);
		System.out.println("\nLista Final:\n");
		for (int i = 0; i < listaNova.size(); i++) {
			System.out.println(listaNova.get(i));
		}
		
		System.out.println("\nExercício 10:\n");
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			l1.add(i+1);
			//System.out.println("Lista 1, posição " + i + ": " + l1.get(i) + "\n");
			l2.add(5-i);
			//System.out.println("Lista 2, posição " + i + ": " + l2.get(i) + "\n");
		}
		System.out.println("Lista 1: " + l1 + "\nLista 2: " + l2);
		//l1.add(1); l2.add(1);
		System.out.println();
		if (Organizar.equals(l1, l2)) {
			System.out.println("Listas iguais");
		}
		else {
			System.out.println("Listas diferentes");
		}
		
		System.out.println("\nExercício 11:\n");
		List<Integer> lN = new ArrayList<Integer>();
		lN = Organizar.clone(l2);
		System.out.println("Lista clone: " + lN);
		
		System.out.println("\nExercício 12:\n");
		System.out.println("Lista: " + lN + "\n");
		while (true) {
			try {
				System.out.println("Start index: ");
				p1 = Integer.parseInt(scan.nextLine());
				System.out.println("End index: ");
				p2 = Integer.parseInt(scan.nextLine());
				break;
			}
			catch(Exception e) {
				
			}
		}
		System.out.println("\nTotal de posições removidas: " + Organizar.remove(p1, p2, lN));
		System.out.println("Lista final: " + lN);
		
		System.out.println("\nExercício 13:\n");
		System.out.println("Lista: " + l1 + "\n");
		while (true) {
			try {
				System.out.println("Posição onde a lista será separada: ");
				p1 = Integer.parseInt(scan.nextLine());
				break;
			}
			catch(Exception e) {
				
			}
		}
		List<Integer> lS = new ArrayList<Integer>();
		lS = Organizar.split(p1,l1);
		System.out.println("Lista inicial separada: " + l1);
		System.out.println("Lista que recebeu a outra parte: " + lS);
	}

}
