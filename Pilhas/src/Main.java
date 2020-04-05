import java.util.*;
public class Main {

	public static <E> void main(String[] args) {
		Stack<Integer> p1 = new Stack<Integer>();
		Stack<Integer> p2 = new Stack<Integer>();
		Stack<Integer> p3 = new Stack<Integer>();
		for (int i = 1; i < 5; i++) {
			p1.add(i);
		}
		System.out.println("Exercício 1:\n");
		System.out.println("Pilha 1: " + p1 +
				"\nPilha 2: " + p2 +
				"\nPilha 3: " + p3 + "\n");
		try {
			int temp = p1.pop();
			p2.push(temp);
			System.out.println("Pilha 2 pegou o valor: " + p2.peek());
			p3.push(p1.pop());
			p2.push(p1.pop());
			temp = p1.pop();
			System.out.println("Temp pegou o último dos valores de p1: " + temp);
			p3.push(temp);
			p1.push(p2.pop());
			System.out.println("P1 pegou de p2: " + p1.peek());
			p3.push(p2.pop());
			System.out.println("Agora p2 não tem nada!");
			p3.push(p1.pop());
			System.out.println("Agora p1 não tem nada também!\n");
		} 
		catch (Exception e) {
			System.out.println(e.toString());
		}
		System.out.println("Pilha 1 final: " + p1 +
				"\nPilha 2 final: " + p2 +
				"\nPilha 3 final: " + p3 + "\n");
		
		p1.clear();
		p2.clear();
		p3.clear();
		System.out.println("Exercício 2:\n");
		try { 
			p1.push(10);
			p1.push(20); 
			p1.push(30);
			p1.push(40);
			
			//Completando o código
			p2.add(p1.pop());
			p2.add(p1.pop());
			p3.add(p1.pop());
			p3.add(p1.pop());
			int x = (p2.pop());
			p3.add(p2.pop());
			p3.add(x);
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Pilha 1 final: " + p1 +
				"\nPilha 2 final: " + p2 +
				"\nPilha 3 final: " + p3 + "\n");
		
		System.out.println("Exercício 3:\n");
		int number = (int)(Math.random()*5) * 10;
		Integer[] v = Organizar.itemsExcept(number, p3);
		System.out.print("Número: " + number + "\nVetor: ");
		for (int i  = 0; i < v.length; i++) {
			System.out.print(v[i] + " ");
		}
		
		System.out.println("\n\nExercício 4:\n");
		geraPilhaRandom(p1);
		geraPilhaRandom(p2);
		
		System.out.println("Pilha 1 inicial: " + p1 + 
				"\nPilha 2 incial: " + p2);
		Organizar.transferElements(p1, p2);
		System.out.println("\nPilha 1 final: " + p1 + 
				"\nPilha 2 final: " + p2);
		
		System.out.println("\nExercício 5:\n");
		geraPilhaRandom(p1);
		geraPilhaRandom(p2);
		System.out.println("Pilha 1 inicial: " + p1 + 
				"\nPilha 2 incial: " + p2);
		Organizar.prependStack(p1, p2);	
		System.out.println("\nPilha 1 final: " + p1 + 
				"\nPilha 2 final: " + p2);
		
		System.out.println("\nExercício 6:\n");
		p1.clear();
		p2.clear();
		p1.push(5);
		p1.push(2);
		p1.push(3);
		Organizar.mul(p1);
		Organizar.sub(p1);
		//System.out.println(p1);

		System.out.println("(V) A sequência push(4); push(2); push(2); mul(); moo() resulta no valor 4 no topo da\r\n" + 
				"pilha. " + 
				"\n(F) O método moo() inverte os dois elementos do topo da pilha. " +
				"\n(V) Supondo a pilha inicialmente vazia, a execução da sequência push(2); push(5);\r\n" + 
				"push(3); mul(); push(1); add() deixa a pilha com um total de 2 elementos." +
				"\n(F) A sequência push(8); push(5); sub() resulta no valor -3 no topo da pilha. " +
				"\n(V) A expressão matemática 5 - 2 ×3 pode ser calculada pela sequência push(5); push(2);\r\n" + 
				"push(3); mul(); sub(). "
				);
		
		System.out.println("\nExercício 7:\n");
		System.out.println("Saídas possíveis: letra a");
		
		System.out.println("\nExercício 8:\n");
		p1.clear();
		p3.clear();
		geraPilhaRandom(p1);
		geraPilhaRandom(p2);
		System.out.println("Pilha 1 inicial: " + p1 + 
				"\nPilha 2 incial: " + p2 + 
				"\nPilha 3 inicial: " + p3);
		p3 = Organizar.foobar(p1, p2);	
		System.out.println("\nPilha 1 final: " + p1 + 
				"\nPilha 2 final: " + p2 +
				"\nPilha 3 final: " + p3 +
				"\n\nVê se o último elemento da Pilha 1 é maior que o último da Pilha 2"
				+ " e atribui\no maior valor. Se uma das pilhas estiver vazia, vai"
				+ " atribuindo os valores\nda outra até que ambas estejam vazias.");
		
		System.out.println("\nExercício 9:\n");
		geraPilhaRandom(p1);
		System.out.println("Pilha: " + p1);
		Organizar.invertePilha(p1);
		System.out.println("Pilha invertida: " + p1);
		
		System.out.println("\nExercício 10:\n");
		p1.clear();
		geraPilhaRandom(p1);
		int rand = (int)(Math.random()*20);
		System.out.println("Pilha: " + p1 + "\nElemento: " + rand);
		Organizar.achaPosicao(p1, rand);
		
		System.out.println("\n\nExercício 12:\n");
		MyStack<Integer> s1 = new MyStack();
		MyStack<Integer> s2 = new MyStack();
		rand = (int)(Math.random()*20);
		geraMyPilhaRandom(s1);
		System.out.println("Pilha: " + s1 + "\nElemento: " + rand);
		s1.contains(rand);
		
		System.out.println("\n\nExercício 13:\n");
		s1.clear();
		geraMyPilhaRandom(s1);
		System.out.println("Pilha: " + s1);
		s1.flip();
		System.out.println("Pilha invertida: " + s1);
		
		System.out.println("\nExercício 14:\n");
		s1.clear();
		s2.clear();
		geraMyPilhaRandom(s1);
		geraMyPilhaRandom(s2);
		System.out.println("Pilha 1 inicial: " + s1 +
				"\nPilha 2 inicial: " + s2);
		s1.push(s2);
		System.out.println("Pilha 1 final: " + s1 +
				"\nPilha 2 final (não mexeu): " + s2);
		
		System.out.println("\nExercício 15:\n");
		s1.clear();
		s2.clear();
		geraMyPilhaRandom(s1);
		geraMyPilhaRandom(s2);
		System.out.println("Pilha 1: " + s1 +
				"\nPilha 2: " + s2);
		if(s1.equals(s2)) 
			System.out.println("Pilhas iguais");
		else
				System.out.println("Pilhas diferentes");
		
		System.out.println("\nExercício 16:\n");
		s1.clear();
		s2.clear();
		geraMyPilhaRandom(s1);
		System.out.println("Pilha: " + s1);
		s2 = s1.JutsuCloneDasSombras();
		System.out.println("Não mexemos na pilha: " + s1 +
				"\nClone da pilha: " + s2);
		
		System.out.println("\nExercício 11:\n");
		Stack<Character> ch1 = new Stack<Character>();
		ch1.add('(');
		ch1.add(')');
		ch1.add(')');
		ch1.add('(');
		System.out.print("Pilha: ");
		for (int i = 0; i < ch1.size(); i++) {
			System.out.print(ch1.elementAt(i));
		}
		System.out.println("\nParêntese válidos? " + Organizar.checkBrackets(ch1));
				
	}
	
	public static <E> void geraPilhaRandom(Stack <Integer> s) {
		s.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			s.add((int)(Math.random()*20));
		}
	}
	public static <E> void geraMyPilhaRandom(MyStack <Integer> s) {
		s.clear();
		for (int i = 0; i < (int)(Math.random()*10+1); i++) {
			s.push((int)(Math.random()*20));
		}
	}
}
