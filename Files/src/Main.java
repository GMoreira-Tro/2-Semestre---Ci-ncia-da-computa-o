import java.util.*;
import java.io.*;
public class Main {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Exercício 1:");
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			System.out.println("Posição " + i + ":" );
			al.add(Integer.parseInt(scan.nextLine()));
		} 
		System.out.println(exercicio1(al) + "\n");
		System.out.println("\nExercício 2:");
		Vector<Integer> v1 = new Vector<Integer>(), v2 = new Vector<Integer>();
		for (int i = 0; i < 5; i++) {
			v1.add((int)(Math.random()*20 - 10));
			v2.add((int)(Math.random()*20 - 10));
		}
		
		System.out.println("Vetor 1 = " + v1);
		System.out.println("Vetor 2 = " + v2);
		System.out.println("Lista = " + exercicio2(v1,v2));
	}
	
	public static ArrayList<Integer> exercicio1(ArrayList<Integer> al) {
		int aux;
		for (int i = 0; i < (al.size()/2); i++) {
			aux = al.get(i);
			al.set(i,al.get(al.size()-i-1));
			al.set(al.size()-i-1,aux);
		}
		return al;
	}
	
	public static List<Integer> exercicio2(Vector<Integer> v1, Vector<Integer> v2) {
		List<Integer> l = new Vector<Integer>();
		int c = 0;
		for (int i = 0; i < v1.size(); i++) {
			for (int j = 2; j < v1.get(i); j++) {
				if (v1.get(i)%j == 0) c++;
			}
			if (c == 0 && v1.get(i) > 1) l.add(v1.get(i));
		}
		
		for (int i = 0; i < v2.size(); i++) {
			for (int j = 2; j < v2.get(i); j++) {
				if (v2.get(i)%j == 0) c++;
			}
			if (c == 0 && v2.get(i) > 1) l.add(v2.get(i));
		}
		
		return l;
	}
}
