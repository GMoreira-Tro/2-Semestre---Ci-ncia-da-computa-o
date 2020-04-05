
public class Principal {
	public static void main (String[] args) {
		String n = Teclado.leString("Nome do 1º jogador:");
		Jogador j1 = new Jogador (n);
		n = Teclado.leString("Nome do 2º jogador:");
		Jogador j2 = new Jogador (n);
		int d = 0;
		char again = 's';
		do {
			d = Teclado.leInt("\nDimensões do tabuleiro:");
		} while (d < 3);
		
		int l = 0, c = 0;
		do {	JogoDaVelha jv = new JogoDaVelha (d); 
			do {					
				do {
					do {
						l = Teclado.leInt("\nJogador 1\nLinha:");
						c = Teclado.leInt("Coluna:");
					} while (l > jv.getTab().length - 1 || c > jv.getTab().length - 1);
				} while (!jv.RealizaJogada(l,c,'X'));
				
				if (jv.verificaGanhador()) j1.setPts();
				if (jv.verificaGanhador() || jv.verificaEmpate()) {System.out.print(jv.toString()); break;}
				
				System.out.print(jv.toString());
				do {
					do {
						l = Teclado.leInt("\nJogador 2\nLinha:");
						c = Teclado.leInt("Coluna:");
					} while (l > jv.getTab().length - 1 || c > jv.getTab().length - 1);
				} while (!jv.RealizaJogada(l,c,'O'));
				System.out.print(jv.toString());
				if (jv.verificaGanhador()) j2.setPts();
			} while (!jv.verificaGanhador() || jv.verificaEmpate());
			System.out.print("\n"+j1+"\n"+j2);
		} while ((again = Teclado.leChar("Deseja jogar novamente? (s/n):")) == 's');
	} 
}
