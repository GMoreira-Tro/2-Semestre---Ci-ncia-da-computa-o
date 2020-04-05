import java.util.LinkedList;
import java.util.Stack;

public class MyStack<T> implements Stackzada{

		  private LinkedList<T> objetos = new LinkedList<T>();

		  public void push(Object t) {
		    this.objetos.add((T)t);
		  }

		  public T pop() {
		    return this.objetos.remove(this.objetos.size() - 1);
		  }
		  
		  public T peek() {
			    return this.objetos.get(this.objetos.size()-1);
			  }
		  
		  public T elementAt(int i) {
			    return this.objetos.get(i);
			  }

		  public boolean isEmpty() {
		    return this.objetos.size() == 0;
		  }
		  
		  public <E> boolean contains(E e) {
			  for (int i = 0; i < objetos.size(); i++) {
					if (e.equals(objetos.get(i))) {
						System.out.print("Elemento '" + e + "' encontrado na posição: " + i);
						return true;
					}
				}
				System.out.print("Elemento não encontrado");
				return false;
			}
			
			public  <E> void flip() {
				MyStack<E> saux = new MyStack<E>();
				while(!objetos.isEmpty())
					saux.push( objetos.pop());
				Stack<E> saux2 = new Stack<E>();
				while(!saux.isEmpty())
					saux2.add(saux.pop());
				while(!saux2.isEmpty())
					objetos.push((T) saux2.pop());
			}
			
			public <E> void push( MyStack<E> s2) {
				MyStack<E> saux = new MyStack<E>();
				for (int i = 0; i < s2.objetos.size(); i++) {
					saux.push(s2.elementAt(i));
				}
				for (int i = 0; i < saux.objetos.size(); i++) {
					this.objetos.add((T) saux.objetos.get(i));
				}
			}
			
			public <E> boolean equals (Stack<E> s2) {
				if (objetos.size() != s2.size())
					return false;
				else {
					for (int i  = 0; i < objetos.size(); i++) {
						if(!objetos.get(i).equals(s2.elementAt(i)))
							return false;
					}
					return true;
				}
			}
			
			public <E> MyStack<E> JutsuCloneDasSombras() {
				MyStack<E> naruto = new MyStack<E>();
				for (int i = 0; i < objetos.size(); i++) {
					 naruto.push((T) objetos.get(i));
				}
				return (MyStack<E>) naruto;
			}
			
			public void clear() {
				while (!objetos.isEmpty())
					objetos.pop();
			}

			@Override
			public String toString() {
				String s = "[";
				
				for (int i = 0; i < objetos.size(); i++) {
					s +=  objetos.get(i) + ", ";
				}
				if (s.length() > 1)
					s = s.substring(0,s.length()-2);
				s += "]";
				return s;
			}
}
