
public class Main {
	public static void main (String[] args) {
		int[] v = new int[50000];
		int[] v2 = new int[50000];
		int[] v3 = new int[50000];
		
		//vetor randômico
		for (int i = 0; i < v.length; i++) 
			v[i] = (int)(Math.random() * 1000);
		
		//vetor decrescente (pior caso)
		for (int i = 0; i < v2.length; i++) 
			v2[i] = v2.length - i;
		
		//vetor crescente (melhor caso)
		for (int i = 0; i < v3.length; i++) 
			v3[i] = i+1;
		
		//BubbleSort(v);
		InsertSort(v2);
		//SelectionSort(v2);  
	}
	
	public static void BubbleSort(int v[]) {
		int aux;
		for (int i = 0; i < v.length - 1; i++) {
			for (int j = 0; j < v.length - i - 1; j++) {
				if (v[j] > v[j+1]) {
					aux = v[j]; v[j] = v[j+1]; v[j+1] = aux;
				}
			}
		}
		
		for (int i = 0; i < v.length; i++) System.out.print(v[i] + "\n");
	}
	
	public static void InsertSort(int v[]) {
		int aux,j;
		for (int i = 1; i < v.length; i++) {
			aux = v[i];
			for (j = i-1; j >= 0 && v[j] > aux; j--) {
				v[j+1] = v[j];
			}
			v[j+1] = aux;
		}
		for (int i = 0; i < v.length; i++) System.out.print(v[i] + "\n");
		
	}
	
	public static void SelectionSort(int v[]) {
		int aux,min;		
		for (int i = 0; i < v.length - 1; i++) {
			min = i;
			for (int j = i+1; j < v.length; j++) {
				if (v[min] > v[j])
					min = j;
			}
			if (v[min] != v[i]) {
				aux = v[i];
				v[i] = v[min];
				v[min] = aux;
			}
		}
		
		for (int i = 0; i < v.length; i++) System.out.print(v[i] + "\n");
	}
}
