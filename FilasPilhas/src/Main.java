import java.util.*;

public class Main {
	public static Scanner scan = new Scanner (System.in);
	
	public static void main(String[] args) throws Exception {
		StaticQueue<Integer> q = new StaticQueue<Integer>(5);
		StaticQueue<Integer> q2 = new StaticQueue<Integer>(5);
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> st2 = new Stack<Integer>();
		Stack<Integer> st3 = new Stack<Integer>();
		List<Integer> auxL = new ArrayList<Integer>();
		
		try {
			q.enqueue(1);
			q.enqueue(2);
			q.enqueue(3);
			q.enqueue(4);
			q.dequeue();
			q.dequeue();
			q.enqueue(5);
			q.enqueue(6);
			q.enqueue(7);
		}
		catch (OverflowException e) {
			System.out.println(e);
		}
		catch(UnderflowException e) {
			System.out.println(e);
		}
		System.out.println("Elementos retirados:");
		while (!q.isEmpty()) {
			System.out.print("[" + q.dequeue() + "]" + " ");
		}
		
		try {
			q.enqueue(6);
			q.enqueue(7);
			q.enqueue(3);
			q.enqueue(4);
			q.enqueue(2);
			q.dequeue();
			q.dequeue();
			q.enqueue(2);
			
		}
		catch (OverflowException e) {
			System.out.println(e);
		}
		catch(UnderflowException e) {
			System.out.println(e);
		}
		
		System.out.println("\n\nToString() da fila " + q);
		
		try {
			q2.enqueue(10);
			q2.enqueue(21);
			q2.enqueue(31);
			q2.enqueue(432);
			q2.dequeue();
			q2.dequeue();
			q2.enqueue(532);
			q2.enqueue(744);
		}
		catch (OverflowException e) {
			System.out.println(e);
		}
		catch(UnderflowException e) {
			System.out.println(e);
		}
		
		q.bubbleSort();
		q2.bubbleSort();
		System.out.println("\nFila ordenada: " + q);
		System.out.println("\nFila 2 ordenada: " + q2);
		
		for (int i = 0; i < (int)(Math.random()*10+1); i++)  {
			st.add((int)(Math.random()*50));
		}
		for (int i = 0; i < (int)(Math.random()*10+1); i++)  {
			st2.add((int)(Math.random()*50));
		}
		
		System.out.println("\nPilha 1: " + st + "\nPilha 2:" + st2);
		st.sort(Collections.reverseOrder());
		st2.sort(Collections.reverseOrder());
		System.out.println("\nPilha 1 ordenada: " + st + "\nPilha 2 ordenada:" + st2);
		
		while (!st.isEmpty() || !st2.isEmpty()) {
			if (st.isEmpty())
				st3.add(st2.pop());
			else if (st2.isEmpty())
				st3.add(st.pop());
			else {
				if (st.peek() < st2.peek())
					st3.add(st.pop());
				else
					st.add(st2.pop());
			}
		}
		System.out.println("\nPilha 3: " + st3 + "\nPilha 1 e 2: " + st + st2);
		boolean is_pali = false;
		st.clear();
		st.add(2);
		st.add(3);
		st.add(4);
		
		if (st.size() == q.numElements()) {
			for (int i = 0; i < st.size(); i++) {
				if (q.elements[i+q.front()%q.numElements()].equals(st.peek())) {
					is_pali = true;
					st.pop();
					break;					
				}
			}
		}
		System.out.println("\nFila 1 e Pilha 1 são palíndromos? " + is_pali);
	}

}
