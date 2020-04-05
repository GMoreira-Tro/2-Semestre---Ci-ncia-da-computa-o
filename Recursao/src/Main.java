
public class Main {
	public static void main (String[] args) {
		
		System.out.println("Exercício 1:");
		
		int n = 0;
		do {
			n = Teclado.leInt("N:");
		} while (n < 1);
		System.out.println(f1(n));
		
		System.out.println("\nExercício 2:"); 
		do {
			n = Teclado.leInt("Tamanho do vetor:");
		} while (n < 1);
		int[] v = new int[n];
		for (int i = 0; i < v.length; i++) v[i] = i+1;
		System.out.println(f2(v,v.length - 1));
		
		System.out.println("\nExercício 3:");
		int x,y;
		do {
			x = Teclado.leInt("X:");
			y = Teclado.leInt("Y:");
		} while (x < 0 || y < 0);
		System.out.println(f3(x,y));
		
		System.out.println("\nExercício 4:");
		String s; char c;
		//do {
			s = Teclado.leString("String:");
			c = Teclado.leChar("Char:");
		//} while (x < 0 || y < 0);
		System.out.println(f4(s,c,0));
		
		System.out.println("\nExercício 5:");
		char[] arrayC = new char[n];
		for (int i = 0; i < arrayC.length; i++)
			arrayC[i] = (char)(65+i);
		System.out.println(arrayC);
		System.out.println(f5(arrayC,0));
		
		System.out.println("\nExercício 6:");
		int linhas,colunas;
		do {
			linhas = Teclado.leInt("Linhas:");
			colunas = Teclado.leInt("Colunas:");
		} while (linhas < 1 || colunas < 1);
		double[][] arrayD = new double[linhas][colunas];
		for (int i = 0; i < arrayD.length; i++) {
			for (int j = 0; j < arrayD[0].length; j++) {
				arrayD[i][j] = i*arrayD[0].length + j;
			}
		}
		for (int i = 0; i < arrayD.length; i++) {
			for (int j = 0; j < colunas; j++) {
				System.out.print (arrayD[i][j] + " ");
			} System.out.print ("\n");
		}
		System.out.println("\n" + f6(arrayD,arrayD.length-1,arrayD[0].length-1));

    System.out.println("\nExercício 7:"); 
    int[] v_rand = new int[(int)(Math.random()*10+1)];
    for (int i = 0; i < v_rand.length; i++) {
      v_rand[i] = (int)(Math.random() * 51);
      System.out.println("Posicao:" + i + " - Valor:" + v_rand[i]);
    }
    int[] pointer = new int[1];

    System.out.println("\nMenor posição: " +  encontraPosicaoMenorValor(v_rand,0,pointer));

    System.out.println("\nExercício 9");
    String binary;
    do {
      binary = Teclado.leString("\nDigite um número binário de 8 digitos:");
    } while (verificaBinario(binary));
    System.out.println("\nConversão:" + binaryToDecimal(binary,0,pointer));
	}
	

	
	public static int multr (int m, int n) {
		if (n < 0) {m *=-1; n *=-1;}
		if (n == 0) return 0;
		else return (m + multr(m,n-1));
		
	}
	
	public static int fibonacci (int n) {
		if (n > 2) return n;
		else return fibonacci (n - 2) + fibonacci (n - 1);
	}
	
	public static int f1(int n) {
		if (n < 1) return 0;
		else return n + f1(n-1);
	}
	
	public static int f2(int[] v, int n) {
		if (n < 1) return v[0];
		else return v[n] + f2(v,n-1);
	}
	
	public static int f3(int x, int y) {
		if (y > x) {
			int aux = x;
			x = y;
			y = aux;
		}
		
		if (x%y == 0) return y;
		else return f3(y,x%y);
	}
	
	public static boolean f4(String s, char c, int i) {
		if (s.charAt(i) == c) return true;
		else if (i == s.length() -1) return false;
		else return f4(s,c,i+1);
	}
	
	public static char[] f5(char[] c, int i) {
		char aux;
		aux = c[c.length - i -1];
		c[c.length - i -1] = c[i];
		c[i] = aux;
		if (i == (c.length - 1)/2) return c;
		else return f5(c,i+1);
	}
	
	public static double f6(double[][] v, int l, int c) {
		if (c < 1 && l < 1) return v[l][c];
		else if (c < 1) return v[l][c] + f6(v, l-1, v[0].length-1);
		else  return v[l][c] + f6(v, l,c-1);
	}

  public static int encontraPosicaoMenorValor(int[]v,int i, int[] pointer) {
    if (i == 0) pointer[0] = i;
    else if (v[i] < v[pointer[0]]) pointer[0] = i;
    
    if (i < v.length - 1) return encontraPosicaoMenorValor(v,++i,pointer);
    else return pointer[0];
  }

  public static boolean verificaBinario(String s) {
    if (s.length() != 8) return true;
    else {
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) != '0' && s.charAt(i) !='1') 
          return true; 
      }
    }
    return false;
  }

  public static int binaryToDecimal (String s, int i, int[] pointer) { 
    if (i == 0) pointer[0] = 0;
    pointer[0] += ((int)(s.charAt(i))-48) * Math.pow(2, s.length()-i-1);
    if (i == s.length() - 1) return pointer[0];
    else return binaryToDecimal(s, ++i,pointer);
  }
}
