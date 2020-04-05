
public class Organizar {
	public static int convertToInt(SinglyLinkedList<Integer> l) {
		int t = 0;
		for (int i = 0; i < l.numElements; i++) {
			t += l.get(i);
		}
		return t;
	}
}

/*public void swap (int i, int j) {
		if (i != j) {
			E element = get(i);
			set(i, get(j));
			set(j, element);
		}
	}*/