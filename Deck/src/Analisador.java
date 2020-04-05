import java.util.Stack;

public class Analisador {

	public static void main(String[] args) throws Exception {
		StaticDeck<Character> yugioh = new StaticDeck<Character>((int)(Math.random()*8+3));
		geraDeckRandom(yugioh);
		System.out.println("Deck: " + yugioh);
		System.out.println("\nBack do deck: " + yugioh.back());
		System.out.println("\nFront do deck: " + yugioh.front());
		//System.out.println(yugioh.numElements());
		
		try {
			yugioh.dequeue();
			System.out.println("\nTirando a primeira posi��o: " + yugioh);
			yugioh.destack();
			System.out.println("\nTirando a �ltima posi��o: " + yugioh);
		
			yugioh.enqueue('(');
			System.out.println("\nColocando '(' na �ltima posi��o: " + yugioh);
			yugioh.enstack(')');
			System.out.println("\nColocando ')' na primeira posi��o: " + yugioh);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		System.out.println("\nEsse deque n�o passa: " + checkBrackets(yugioh));
		StaticDeck<Character> setoKaiba = new StaticDeck<Character>(5);
		setoKaiba.enstack('B');
		setoKaiba.enqueue('(');
		setoKaiba.enqueue('A');
		setoKaiba.enqueue(')');
		setoKaiba.enqueue('X');
		System.out.println("\nEste aqui:\n" + setoKaiba + "\nVAI PASSAR: " + checkBrackets(setoKaiba));
	}
	
	public static  boolean checkBrackets(StaticQueue<Character> s1) {
		int x = 0, y = 0;
		for (int i = 0; i < s1.numElements(); i++) {
			if (s1.get(i).equals( '('))
				x++;
			else if (s1.get(i).equals(')'))
				y++;
			if (y > x)
				return false;
		}
		if (x == y)
			return true;
		else
			return false;
	}
	
	public static <E> void geraDeckRandom(StaticQueue<Character> s) throws OverflowException {
		if (!s.isEmpty())
			s.clear();
		
		for (int i = 0; i < s.length(); i++) {
			s.enqueue((char)(Math.random()*50 + 48));
		}
	}

}
