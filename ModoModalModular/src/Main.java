
public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Exerc�cio 1:\n");
		System.out.println("O operador modular, assim como na matem�tica, � usado "
				+ "para voltar um ciclo para o in�cio ap�s passado do t�rmino.");
		System.out.println("Como, por exemplo, se divirirmos um n�mero por 10, o " +
				"resto sempre ser� um n�mero de 0 a 9 e o resto sempre vir� de forma sequencial.\n");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " % 10*n = " + i);
		}
		
		System.out.println("\nExerc�cio 2:\n");
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
