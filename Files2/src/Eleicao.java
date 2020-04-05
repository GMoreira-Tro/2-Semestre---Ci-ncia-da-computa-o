import java.util.*;
import java.io.*;
public class Eleicao {
	public static void main(String[] args) throws DeputadosException{
		Scanner scan = new Scanner(System.in);
		
		int quant;
		try {
			do {
			System.out.println("Quantidade de deputados que vão concorrer a eleição:");
			 quant = Integer.parseInt(scan.nextLine());
			} while (quant < 0);
			if (quant > 10) {
				throw new DeputadosException("Bah mano, não pode ser mais de 10.");
			}
		}
		catch (DeputadosException e) {
			quant = 10;	
			System.out.println(e);
		}
		catch(NumberFormatException n) {
			quant = 10;
			System.out.println("Bah mano, era pra digitar um número.");
		}
		
		Candidatos candis = new Candidatos("listaDeDeputados.txt");
		for (int i = 0; i < quant; i++) {
			System.out.println(candis.getDeputados()[i] + "\n");
		}
		
		File votacao = new File("votos.txt");
		try {
			FileWriter fr = new FileWriter(votacao,false);
			for (int i = 0; i < 3; i++) {
				System.out.print("Nome do eleitor:");
				String nome = scan.nextLine();
				fr.write(nome + "\r\n");
				System.out.print("Voto:");
				try {
					short voto = Short.parseShort(scan.nextLine());
					
					for (int j = 0; j < quant; j++) {
						if (voto == candis.getDeputados()[j].getNumero()) {
							candis.getDeputados()[j].setVotos(
									candis.getDeputados()[j].getVotos()+1);
							fr.write("Voto: " + voto + "\r\n");
							break;
						}
						if (j == quant-1) fr.write("Voto: nulo\r\n");
					}
				}
				catch(NumberFormatException n) {
					fr.write("Voto: nulo\r\n");
				}
			}
			fr.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		catch(IOException i) {
			System.out.println(i);
		}
		System.out.print("\n");
		try {
			FileReader fw = new FileReader(votacao);
			BufferedReader buff = new BufferedReader(fw);
			String line = buff.readLine();
			while (line != null) {
				System.out.println(line);
				line = buff.readLine();
			}
			System.out.print("\n");
			Deputado dep = candis.getDeputados()[0];
			for (int i = 0; i < quant; i++) {
				if(dep.getVotos() < candis.getDeputados()[i].getVotos())
					dep = candis.getDeputados()[i];
			}
			System.out.println(dep + "\nVotos: " + dep.getVotos());
		}
		catch(FileNotFoundException x) {
			System.out.println(x);
		}
		catch(IOException si) {
			System.out.println(si);
		}
	}
}
