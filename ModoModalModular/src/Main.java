
public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Exercício 1:\n");
		System.out.println("O operador modular, assim como na matemática, é usado "
				+ "para voltar um ciclo para o início após passado do término.");
		System.out.println("Como, por exemplo, se divirirmos um número por 10, o " +
				"resto sempre será um número de 0 a 9 e o resto sempre virá de forma sequencial.\n");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " % 10*n = " + i);
		}
		
		System.out.println("\nExercício 2:\n");
		StaticQueue<Integer> s = new StaticQueue<Integer>(5);
		for (int i = 0; i < 5; i++) {
			s.enqueue(i);
		}
		System.out.println(s);
		System.out.println(s.isFullv2());
		s.dequeueV2();
		s.dequeueV2();
		s.dequeueV2();
		System.out.println(s + "---" + s.numElementsV2());
		System.out.println(s.isFullv2());
		s.enqueueV2(6);
		System.out.println(s);
		System.out.println(s.isFullv2());
		s.enqueueV2(1);
		System.out.println(s + " " + s.numElementsV2());
	}

}
