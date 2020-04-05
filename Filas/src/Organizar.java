import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Organizar {
	
	public static void transferQueue(Queue<Integer> q1, Queue<Integer> q2) {
		Queue<Integer> aux = new LinkedBlockingQueue<Integer>();
		
		for (; !q1.isEmpty();) {
			aux.add(q1.poll());
		}
		for (; !q2.isEmpty();) {
			q1.add(q2.poll());
		}
		for (; !aux.isEmpty();) {
			q1.add(aux.poll());
		}
	}
	
	public static <E> void exterminateFromQueue(LinkedBlockingQueue<Character> q, char element) {
		List<E> l = new ArrayList<E>();
		for (Object e : q) {
			l.add((E) e);
		}
		q.clear();
		for (int i = 0; i < l.size(); i++) {
			if(l.get(i).equals(element)) {
				l.remove(l.get(i));
				i--;
			}
		}
		for (int i = 0; i < l.size(); i++) {
			q.add((Character) l.get(i));
		}
	}
}
