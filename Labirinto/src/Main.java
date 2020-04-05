import java.util.*;
/* GUILHERME DOS SANTOS MOREIRA E LUIZ ALFREDO */

public class Main {
	private static final int LIVRE = 0;
	private static final int OCUPADO = 1;
	private static final int VISITADO = -1;
	private static final int VOLTOU = -2;
	
	private static final int DIREITA = 1;
	private static final int ESQUERDA = 2;
	private static final int BAIXO = 3;
	private static final int CIMA = 4;
	
	public static void main(String[] args) {
		char[][] lab = new char[(int)(Math.random()*9+2)][(int)(Math.random()*9+2)];
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				if (Math.random() < 0.25) lab[i][j] = 'X';
				else lab[i][j] = ' ';
				if (i == lab.length-1 && j == lab[0].length-1) lab[i][j] = 'D';
				System.out.print(lab[i][j] + " ");
			} System.out.print("\n");
		}
		int[][] quaternary = new int[lab.length][lab[0].length];
		for (int i = 0; i < quaternary.length; i++)
			for (int j = 0; j < quaternary[i].length; j++)
				quaternary[i][j] = 0;
		System.out.println("\n" + SeraQPassaRecursivo(lab,quaternary) + "\n");
		for (int i = 0; i < lab.length; i++) {
			for (int j = 0; j < lab[0].length; j++) {
				if (j<lab[0].length-1)
					System.out.print(lab[i][j] +" ");
				else System.out.print(lab[i][j]);
			} System.out.print("\n");
		}
	}
	
	
	/*public static boolean SeraQPassa (char[][] lab) {
		int i = 0, j;
		while (true) {
			for (j = 0; j < lab[0].length; j++) {
				if (lab[i][j] == ' ' && i < lab.length-1) {
					lab[i][j] = '!';
					break;
				}
				else if  (lab[i][j] == 'D') return true;
			}
			if (j == lab[0].length) return false;
			++i;
		}
	}*/
	
	public static boolean SeraQPassaRecursivo(char[][]lab,int[][] q) {
		for (int j = 0; j < lab[0].length; j++) {
			if (lab[0][j] == ' ') return SeraQPassaRecursivoPrivado(lab,0,j,q);
		}
		return false;
	}
	
	private static boolean SeraQPassaRecursivoPrivado(char[][] lab,int i, int j,int[][] q) {
		boolean flag = false;
		int machine=0;
		if (lab[i][j] == 'D') return true;
		lab[i][j] = 'O';
		if (j < lab[0].length-1) {
			if (lab[i][j+1] != 'X' && q[i][j+1] != VOLTOU) {
				if (q[i][j+1] == VISITADO)
					q[i][j] = VOLTOU;
				else
					q[i][j] = VISITADO;
				//q[i][j+1] = VOLTOU;
				flag = true;
				if(q[i][j+1] != VISITADO)
					return SeraQPassaRecursivoPrivado(lab,i,++j,q);
				else 
					machine = DIREITA;
			}
			if (lab[i][j+1] == 'D') return true;
		}
		if (j > 0) {
			if(lab[i][j-1] != 'X' && q[i][j-1] != VOLTOU) {
				if (q[i][j-1] == VISITADO)
					q[i][j]  = VOLTOU;
				else
					q[i][j] = VISITADO;
				//q[i][j-1] = VOLTOU;
				flag = true;
				if(q[i][j-1] != VISITADO)
					return SeraQPassaRecursivoPrivado(lab,i,--j,q);
				else
					machine = ESQUERDA;
			}
			if (lab[i][j-1] == 'D') return true;
		}
		if (i < lab.length-1) {
			if(lab[i+1][j] != 'X' && q[i+1][j] != VOLTOU) {
				if(q[i+1][j] == VISITADO)
					q[i][j] = VOLTOU;
				else
					q[i][j] = VISITADO;
				//q[i+1][j] = VOLTOU;
				flag = true;
				if (q[i+1][j] != VISITADO)
					return SeraQPassaRecursivoPrivado(lab,++i,j,q);
				else
					machine = CIMA;
			}
			if (lab[i+1][j] == 'D') return true;
		}
		if (i > 0) {
			if (lab[i-1][j] != 'X' && q[i-1][j] != VOLTOU) {
				if(q[i-1][j] == VISITADO)
					q[i][j] = VOLTOU;
				else
					q[i][j] = VISITADO;
				//q[i-1][j] = VOLTOU;
				flag = true;
				if (lab[i-1][j] != VISITADO)
					return SeraQPassaRecursivoPrivado(lab,--i,j,q);
				else
					machine = BAIXO;
			}
			//if(lab[i-1][j] == 'D') return true;
		}
		switch(machine) {
			case CIMA:
				return SeraQPassaRecursivoPrivado(lab,++i,j,q);
			case BAIXO:
				return SeraQPassaRecursivoPrivado(lab,--i,j,q);
			case DIREITA:
				return SeraQPassaRecursivoPrivado(lab,i,++j,q);
			case ESQUERDA:
				return SeraQPassaRecursivoPrivado(lab,i,--j,q);
			default:
				return false;
		}
	}
	
}
