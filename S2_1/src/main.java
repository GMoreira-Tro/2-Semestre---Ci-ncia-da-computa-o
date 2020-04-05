public class main {
	
	public static void main (String[] args) {
		exercicio1a();
		System.out.print("\n");
		exercicio1b();
		System.out.print("\n");
		exercicio1c();
		System.out.print("\n");
		exercicio1d();
		System.out.print("\n");
		exercicio2();
		System.out.print("\n");
		double [][] matriz = new double[2][5];
		matriz = exercicio3();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(matriz[i][j] + " ");
			} System.out.print("\n");
		}
		System.out.print("\n");
		System.out.println(exercicio4(matriz));
		System.out.print("\n");
		System.out.println(exercicio6(matriz));
		System.out.print("\n");
		System.out.println(exercicio7(matriz));
		System.out.print("\n");
		int [][] v = new int [3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				v[i][j] = (int)(Math.random() * 51) - 25;
		System.out.println(exercicio8(v));
		System.out.print("\n");
		System.out.println(exercicio9(matriz));
		int[] vet = new int [100];
		System.out.print("\n");
		vet = exercicio11(v); 
		for (int i = 0; i < vet.length; i++) System.out.print(vet[i] + " ");
		System.out.print("\n\n");
		char [][] ch = new char [5][3];
		ch = exercicio10();
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[0].length; j++) {
				System.out.print(ch[i][j] + " ");
			} System.out.print("\n");
		}
		// exercicio 10 tá depois do 11
	}
	
	public static void exercicio1a() {
		int[][] x = new int[3][10];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				x[i][j] = j; System.out.print(x[i][j] + " ");
			} System.out.print("\n"); }
	}
	
	public static void exercicio1b() {
		int[][] x = new int[3][10];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				x[i][j] = j*j; System.out.print(x[i][j] + " ");
			} System.out.print("\n"); }
	}
	
	public static void exercicio1c() {
		int[][] x = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				x[i][j] = i; System.out.print(x[i][j] + " ");
			} System.out.print("\n"); }
	}
	
	public static void exercicio1d() {
		int[][] x = new int[9][6];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 6; j++) { if (i%2 == 1)
				x[i][j] = 0; else x[i][j] = -1; System.out.print(x[i][j] + " ");
			} System.out.print("\n"); }
	}
	
	public static void exercicio2() {
		int a,b;
		do {
			a = Teclado.leInt("Linhas:");
		} while (a < 1);
		
		do {
			b = Teclado.leInt("Colunas:");
		} while (b < 1);
				
		int[][] x = new int[a][b]; 
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) { 
				x[i][j] = (int)(Math.random() * 99) + 1; System.out.print(x[i][j] + " ");
			} System.out.print("\n"); }
	}
	
	public static double[][] exercicio3() {
		double[][] x = new double[2][5];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) { 
				x[i][j] = Teclado.leDouble((j + i*5 + 1) + "º valor:");
			} System.out.print("\n"); }
		return x;
	}
	
	public static int exercicio4(double m[][]) {
		return m.length * m[0].length;
	}
	
	public static int exercicio5(double m[][]) {
		return exercicio4(m);
	}
	
	public static String exercicio6(double m[][]) {
		String s = "";
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				s += m[i][j] + " - ";
			} s = s.substring(0, s.length() - 2); s += "\n";
		}
		return s;
	}
	
	public static double exercicio7(double m[][]) {
		double aux = m[0][0];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] > aux) aux = m[i][j];
			}
		}
		return aux;
	}
	
	public static int exercicio8 (int m[][]) {
		int s = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				s += m[i][j];
			}
		}
		return s;
	}
	
	public static double exercicio9 (double m[][]) {
		double s = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				s += m[i][j];
			}
		}
		s = s/ (m.length * m[0].length);
		return s;
	}
	
	public static int[] exercicio11 (int m[][]) {
		
		int c = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] > 0) {
					c++;
				}
			}
		}
		int[] v = new int [c]; c = 0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				if (m[i][j] > 0) {
					v[c] = m[i][j]; c++;
				}
			}
		}
		return v;
	}
	
	public static char[][] exercicio10 () {
		char[][] ch = new char [(int)(Math.random() * 5  + 1)][(int)(Math.random() * 3  + 1)];
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch[0].length; j++) {
				ch[i][j] = Teclado.leChar("Digite um caractere:");
			}
		}
		return ch;
	}
}
