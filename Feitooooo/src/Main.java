import java.io.*;
import java.util.*;
public class Main {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		Campeonato liga_dos_champs = new Campeonato();
		String[] equipes = {"Grêmio", "Real_Madrid","Corinthians","Íbis","XV_de_Piracicaba"};
		File f = new File("jogos.txt");
		int x;
		do {
			System.out.print("Quantidade de jogos:");
			x = Integer.parseInt(scan.nextLine());
		} while(x < 0);
		try {
			FileWriter fr = new FileWriter(f,false);
			for (int i = 0; i < x; i++) {
				int j = (int)(Math.random()*equipes.length);
				int k = (int)(Math.random()*equipes.length);
				if (k == j) {
					if (k < equipes.length-1) k++;
					else k--;
				}
				
				fr.write(equipes[j] +" "+ (int)(Math.random()*10)
						+ " x " + (int)(Math.random()*10) + " " + equipes[k] + "\r\n");
			}
			fr.close();
		}
		catch(FileNotFoundException n) {
			System.out.println("Arquivo não encontrado");
		}
		catch (IOException e) {
			System.out.println("Erro na leitura do arquivo");
		}
		liga_dos_champs.leArquivo("jogos.txt");
	}
}
