import java.util.*;

public class Organizar {
	public static Integer[] itemsExcept (int number, Stack<Integer> p) {
		int t = 0;
		for (int i = 0; i < p.size(); i++) {
			if (p.elementAt(i) != number)
				t++;
		}
		Integer[] v = new Integer[t];
		t = 0;
		for (int i = 0; i < p.size(); i++) {
			if(p.elementAt(i) != number) {
				v[t] = p.elementAt(i);
				t++;
			}
		}
		return v;
	}
	
	public static <E> void transferElements(Stack<E> s1, Stack<E> s2) {
		Stack<E> saux = new Stack<E>();
		while(!s2.isEmpty()) {
			saux.add(s2.pop());
		}
		while(!saux.isEmpty()) {
			s1.add(saux.pop());
		}
	}
	
	public static <E> void prependStack(Stack<E> s1, Stack<E> s2) {
		Stack<E> saux = new Stack<E>();
		Stack<E> saux2 = new Stack<E>();
		E[] vaux = ((E[])new Object[s2.size()]);
		int i = 0;
		while(!s1.isEmpty()) {
			saux.add(s1.pop());
		}
		while(!s2.isEmpty()) {
			saux.add(s2.pop());
			vaux[i] = saux.peek();
			i++;
		}
		while (!saux2.isEmpty()) {
			s1.add(saux2.pop());
		}
		while (!saux.isEmpty()) {
			s1.add(saux.pop());
		}
		for (int j = 0; j < vaux.length; j++) {
			s2.add(vaux[vaux.length-j-1]);
		}
		
	}
	
	public static void add(Stack<Integer> s) {
		s.push(s.pop() + s.pop());
	}
	
	public static void sub(Stack<Integer> s) {
		s.push(-1 * s.pop() + s.pop());
	}
	public static void mul(Stack<Integer> s) {
		s.push(s.pop() * s.pop());
	}

	public static void moo(Stack<Integer> s) {
		int x = s.pop();
		int y = s.pop();
		s.push(y);
		s.push(x);
	}
	
	public static Stack<Integer> foobar(Stack<Integer> s1, Stack<Integer> s2) {
		Stack<Integer> s3 = new Stack<Integer>();
		while (!s1.isEmpty() && !s2.isEmpty()) {
			int int1 = s1.peek();
			int int2 = s2.peek();
			s3.push(int1 > int2 ? s1.pop() : s2.pop());
		 }
		 while (!s1.isEmpty())
			 s3.push(s1.pop());
		 while (!s2.isEmpty())
			 s3.push(s2.pop());
		 return s3;
	}
	
	public static <E> void invertePilha(Stack<E> s1) {
		Stack<E> saux = new Stack<E>();
		while(!s1.isEmpty())
			saux.add(s1.pop());
		Stack<E> saux2 = new Stack<E>();
		while(!saux.isEmpty())
			saux2.add(saux.pop());
		while(!saux2.isEmpty())
			s1.add(saux2.pop());
	}
	
	public static <E> boolean achaPosicao(Stack<E> s1, E e) {
		for (int i = 0; i < s1.size(); i++) {
			if (e.equals(s1.elementAt(i))) {
				System.out.print("Elemento '" + e + "' encontrado na posição: " + i);
				return true;
			}
		}
		System.out.println("Elemento não encontrado");
		return false;
	}
	
	public static  boolean checkBrackets(Stack<Character> s1) {
		int x = 0, y = 0;
		for (int i = 0; i < s1.size(); i++) {
			if (s1.elementAt(i) == '(')
				x++;
			else if (s1.elementAt(i) == ')')
				y++;
			if (y > x)
				return false;
		}
		if (x == y)
			return true;
		else
			return false;
	}
}
