import java.text.Normalizer;

public class Main {
	public static void main (String[] args) {
	System.out.println("Exercício 1:");
	int[] v = new int[(int)(Math.random()*10+2)];
	System.out.println("Array de entrada:");
	for (int i = 0; i < v.length; i++) {
	v[i] = (int)(Math.random()*51 - 25);
	System.out.print(v[i] + " ");
	}
	int n;
	
	n = Teclado.leInt("\nN:");
	System.out.println(exercicio1(v,n));
	
	System.out.println("\nExercício 2:");
	System.out.println("N = " + n + "\n" + !exercicio2(n));
	
	/*	Selection Sort habitual
	int min, aux;
	for (int i = 0; i < v.length; i++) {
	min = i;
	for (int j = i+1; j < v.length; j++) {
	if (v[min] > v[j]) min = j;
	}
	if (i!=min) {
	aux = v[min];
	v[min] = v[i];
	v[i] = aux;
	}
	}
	*/
	
	System.out.println("\nExercício 3:");
	System.out.println("Array de entrada:");
	for (int i = 0; i < v.length; i++) System.out.print(v[i]+" ");
	v = (exercicio3(v));
	System.out.println("\nArray de saída:");
	for (int i = 0; i < v.length; i++) System.out.print(v[i]+" ");
	
	/*	Insertion Sort
	int j,aux;
	for (int i = 1; i < v.length; i++) {
	aux = v[i];
	for (j = i-1; j >= 0 && v[j] > v[i]; j--) {
	v[j+1] = v[j];
	}
	v[j+1] = aux;
	}
	*/
	System.out.println("\n\nExercício 4:");
	int[] v2 = new int[5];
	System.out.println("Array de entrada:");
	for (int i = 0; i < v2.length; i++) {
		v2[i] = (int)(Math.random()*51 - 25);
		System.out.print(v2[i] + " ");
	}
	System.out.println("");
	v2 = exercicio4(v2);
	System.out.println("Array de saída:");
	for (int i = 0; i < v2.length; i++) System.out.print(v2[i]+" ");
	
	System.out.println("\n\nExercício 5:");
	String sutoringa = Teclado.leString("String:");
	System.out.println(exercicio5(sutoringa));
	
	System.out.println("\nExercício 6:");
	int n2;
	do {
		n2 = Teclado.leInt("N:");
	} while (n2 < 1);
	System.out.println(exercicio6(n2));
	
	System.out.println("\nExercício 7:");
	String sutoringa2 = Teclado.leString("String:");
	System.out.println(exercicio7(sutoringa2));
	
	System.out.println("\nExercício 8:");
	String[] ss = new String[5];
	for (int i = 0; i < ss.length; i++)
		ss[i] = Teclado.leString("String da posição " + i + ":");
	System.out.println(exercicio8(ss));
	
	System.out.println("\nExercício 9:");
	int d;
	do {
		d = Teclado.leInt("Dígito:");
	} while (d < 0 || d > 9);
	
	do {
		n = Teclado.leInt("N:");
	} while(n < 1);
	//String ene = String.valueOf(n);
	System.out.println(exercicio9(d,n));
	
	System.out.println("\nExercício 10:");
	System.out.println("N = " + n + "\n" + "Média:" + exercicio10(n));
	
	System.out.println("\nExercício 11:");
	do {
		n = Teclado.leInt("N:");
	} while (n < 1);
	System.out.println(exercicio11(n));
}

	public static boolean exercicio1(int[] v, int n) {
		return f1(v,n,0);
	}

	private static boolean f1(int[] v, int n, int i) {
		if (n == v[i]) return true;
		else if (i == v.length -1) return false;
		else return f1(v,n,++i);
	}

	public static boolean exercicio2(int n) {
		return f2(n,2);
	}

	private static boolean f2(int n, int i) {
		if (n%i == 0 && n != 2 || n < 2) return true;
		else if (i >= n-1 ) return false;
		else return f2(n,++i);
	}

	public static int[] exercicio3(int[] v) {
		return f3(v,0,1,0);
	}

	private static int[] f3(int[] v, int i, int j, int min) {
		int aux;
		if (v[min] > v[j] ) min = j;
		if (j < v.length - 1) return f3(v,i,++j,min);
		if (i!=min) {
			aux = v[min];
			v[min] = v[i];
			v[i] = aux;
		}
		if (i < v.length - 1) return f3(v,++i,i,i);
		else return v;
	}

	public static int[] exercicio4(int[] v2) {
		if (v2.length > 1)
			return f4(v2,1,0,v2[1]);
		else return v2;
	}

	private static int[] f4(int[] v2, int i, int j, int aux) {
		if (j >= 0)  {
			if( v2[j] > aux) {
				v2[j+1] = v2[j];
				
				return f4(v2,i,--j,aux);
			}
		}
		v2[j+1] = aux;
		if (i < v2.length - 1) {	
			return f4(v2,i+1,i,v2[i+1]);
		}
		
		else return v2;
	
	}
	public static String exercicio5 (String s) {
		String xesquedele = "";
		return f5(s,0,xesquedele);
	}
	
	private static String f5(String s, int i,String xesquedele) {
		char aux;
		if (i < s.length()) {
			xesquedele += s.charAt(s.length()-1-i);
			return f5(s,++i,xesquedele);
		}
		else return xesquedele;
	}
	
	public static double exercicio6(int n) {
		return f6(n,1,0);
	}
	
	private static double f6(int n, int i,double sum) {
		if (i <= n) {
			sum += (1./i);
			return f6(n,++i,sum);
			}
		else return sum;
	}
	
	public static boolean exercicio7(String s) {
		s = s.replace(" " ,"");
		s = s.replace("," ,"");
		s = s.replace(";" ,"");
		s = s.replace("." ,"");
		s = s.replace("!" ,"");
		s = s.replace("?" ,"");
		s = removeAccents(s);
		//System.out.println(s);
		return f7(s);
	}
	
	public static String removeAccents(String str) {
	    str = Normalizer.normalize(str, Normalizer.Form.NFD);
	    str = str.replaceAll("[^\\p{ASCII}]", "");
	    return str;
	}
	
	private static boolean f7(String s) {
		String kk = exercicio5(s);
		if (kk.equals(s)) return true;
		else return false;  
	}
	
	public static int exercicio8(String[] ss) {
		return f8(ss,0,0);
	}
	
	private static int f8(String[] ss, int i, int total) {
		//String kk = exercicio5(ss[i]);
		if (exercicio7(ss[i])) ++total;
		if (i < ss.length-1) return f8(ss,++i,total);
		else return total;
	}
	
	public static int exercicio9(int d, int n) {
		return f9(d,n,n,0);
	}
	
	private static int f9 (int d, int n, int i, int total) {
		
		for (i = n; i%10 != 0; i--) {}
		if (d == n-i) ++total;
		if ( n >= 10) return f9(d,n/10,i,total);
		else return total;
	}
	
	public static double exercicio10(int n) {
		return f10(n,0,1);
	}
	
	private static double f10(int n,double sum, int i) {
		 int k = reduce(n);
		 int j = n - k;
		 sum += j;
		 if (n >= 10) return f10(n/10,sum,++i);
		 else return sum/i;
	}
	
	private static int reduce(int n) {
		if (n%10 != 0) return reduce(--n);
		else return n;
	}
	
	public static boolean exercicio11(int n) {
		if (n == 1) return false;
		return f11(n,0,1);
	}
	
	private static boolean f11(int n, int sum, int i) {
		if (n%i == 0) sum += i;
		if (i == n-1) {
			if (sum == n) return true;
			else return false;
		}
		else return f11(n,sum,++i);
	}
}

