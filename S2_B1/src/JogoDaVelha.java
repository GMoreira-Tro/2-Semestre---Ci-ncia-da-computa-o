
public class JogoDaVelha {
	private char[][] tab;
	public JogoDaVelha () {
		this.tab = new char[3][3];
		for (int i = 0; i < tab.length; i++)
			for (int j = 0; j < tab[0].length; j++)
				tab[i][j] = ' ';
	}
	public JogoDaVelha(int p) {
		this.tab = new char [p][p];
		for (int i = 0; i < tab.length; i++)
			for (int j = 0; j < tab[0].length; j++)
				tab[i][j] = ' ';
	}
	public boolean RealizaJogada (int l, int c, char xo) {
		if (l > tab.length - 1 || c > tab.length - 1) return false;
		else if (this.tab[l][c] == ' ') { this.tab[l][c] = xo; return true;}
		else return false;
	}
	public boolean verificaGanhador () {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (j <= tab[0].length - 3) {
					if (tab[i][j] == 'X' && tab[i][j+1] == 'X' && tab[i][j+2] == 'X') return true;
					else if (tab[i][j] == 'O' && tab[i][j+1] == 'O' && tab[i][j+2] == 'O') return true;
				}
				
				if (i <= tab.length - 3) {
					if (tab[i][j] == 'X' && tab[i+1][j] == 'X' && tab[i+2][j] == 'X') return true;
					else if (tab[i][j] == 'O' && tab[i+1][j] == 'O' && tab[i+2][j] == 'O') return true;
				}
				if (i <= tab.length - 3 && j <= tab[0].length - 3) {
					if (tab[i][j] == 'X' && tab[i+1][j+1] == 'X' && tab[i+2][j+2] == 'X') return true;
					else if (tab[i][j] == 'O' && tab[i+1][j+1] == 'O' && tab[i+2][j+2] == 'O') return true;
				}
				if (i > 1 && j <= tab[0].length - 3) {
					if (tab[i][j] == 'X' && tab[i-1][j+1] == 'X' && tab[i-2][j+2] == 'X') return true;
					if (tab[i][j] == 'O' && tab[i-1][j+1] == 'O' && tab[i-2][j+2] == 'O') return true;
				}
			}	
			
		} return false;
	}
	public boolean verificaEmpate() {
		boolean a = false;
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (tab[i][j] == ' ') { a = true; break;}
			} if (a) return false;
		} return true;
	}
	public char[][] getTab() { return this.tab;}
	public String toString() {
		String t = "";
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[0].length; j++) {
				if (this.tab[i][j] != ' ') t += tab [i][j] + " | ";
				else t += "  | ";
			} t = t.substring(0, t.length() - 2); t += "\n";
		}
		return t;
	}
}
