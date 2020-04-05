
public class Main {

	public static void main(String[] args) {
		System.out.println("Lista:\n");
		List<Integer> lista1 = new StaticList<Integer>();
		for (int i = 0; i < 20; i++) {
			lista1.insert((int)(Math.random()*100), i);
			System.out.print(lista1.get(i) + " ");
		}
		
		System.out.println("\n\nSub lista:\n");
		List<Integer> lista2 = new StaticList<Integer>();
		lista2 = ((StaticList) lista1).subList(18, 19);
		for (int i = 0; i < lista2.numElements(); i++) {
			System.out.print(lista2.get(i) + " ");
		}
		System.out.println("\n\nLista mergeada:\n");
		((StaticList)lista2).merge(lista1);
		for (int i = 0; i < lista2.numElements(); i++) {
			System.out.print(lista2.get(i) + " ");
		}
	}

}
