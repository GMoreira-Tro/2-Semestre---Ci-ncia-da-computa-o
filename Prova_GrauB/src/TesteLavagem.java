import java.io.*;
import java.util.*;

public class TesteLavagem {
	public static Scanner scan = new Scanner(System.in);
	public static void main (String[] args) throws Exception {
		DoublyLinkedList<Veiculo> ll = new DoublyLinkedList<Veiculo>();
		/*l.getV().insertLast(new Veiculo("Gol","VW","Carro"));
		l.getV().insertLast(new Veiculo("Sandero","Renault","Veículo de aplicativo"));
		l.getV().insertLast(new Veiculo("Vitara","Suzuki","Caminhote"));
		l.getV().insertFirst(new Veiculo("Cargo","Ford","Caminhão"));
		
		System.out.println(l);
		geraLavagemRandom(l);
		System.out.println(l);*/
		File f = new File("Veículos.txt");
		File fil = new File("Fila.txt");
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader in = new BufferedReader(fr);
			String line;
			String[] splitted;
			while ((line = in.readLine()) != null) {
				splitted = line.split("\t");
				String nome,marca,tipo;
				nome = splitted[0];
				marca = splitted[1];
				tipo = splitted[2];
				ll.insertLast(new Veiculo(nome,marca,tipo));
			}
		}
		catch (FileNotFoundException foo) {
			//System.out.println(foo);
		}
		catch (IOException i) {
			//System.out.println(i);
		}
		Lavagem l = new Lavagem(ll);
		boolean flag = true;
		int x;
		while (flag) {
			menu();
			while (true) {
				try {
					x = Integer.parseInt(scan.nextLine());
					System.out.println();
					break;
				}
				catch (Exception e) {
					
				}
			}
			switch (x) {
				case 1:
					System.out.println("\n" + l + "\n");
					break;
				case 2:
					try {
						System.out.print("Digita a posição a ser inserido o veículo: ");
						int p = Integer.parseInt(scan.nextLine());
						if (p < 0 || p > l.getV().numElements)
							throw new IndexOutOfBoundsException();
						System.out.print("\nNome: ");
						String nome = scan.nextLine();
						System.out.print("\nMarca: " );
						String marca = scan.nextLine();
						System.out.println();
						menu2();
						System.out.println();
						int opt;
						while (true) {
							try {
								opt = Integer.parseInt(scan.nextLine());
								if (opt > 4 || opt < 1)
									throw new Exception();
								break;
							}
							catch (Exception e) {
								
							}
						}
						String tipo;
						switch(opt) {
							case 1:
								tipo = "Veículo de aplicativo";
								break;
							case 2:
								tipo = "Carro";
								break;
							case 3:
								tipo = "Caminhonete";
								break;
							default:
								tipo = "Caminhão";
								break;
						}
						l.getV().insert(new Veiculo(nome,marca,tipo), p);
						System.out.println("\nVeículo salvo!\n");
					}
					catch (Exception e) {
						System.out.println("\nPosição inválida!\n");
					}
					break;
				case 3:
					try {
						System.out.print("Digita a posição a ser inserido o veículo: ");
						int p = Integer.parseInt(scan.nextLine());
						if (p < 0 || p >= l.getV().numElements)
							throw new IndexOutOfBoundsException();
						l.getV().remove(p);
						System.out.println("\nPosição removida!\n");
					}
					catch (Exception e) {
						System.out.println("\nPosição inválida!\n");
					}
					break;
				case 4:
					StaticQueue<Veiculo> q = l.filaLavagem();
					System.out.println(q + "\n");
					break;
				case 5:
					try {
						 l.salvaFila(fil);
						FileWriter fw = new FileWriter(f,false);
						for (int i = 0; i < l.getV().numElements; i++) {
							fw.write(l.getV().get(i).getNome() + "\t"
									+ l.getV().get(i).getMarca() + "\t"
									+ l.getV().get(i).getTipo() + "\r\n");
						}
						fw.close();
					}
					catch(FileNotFoundException n) {
						System.out.println("Arquivo não encontrado");
					}
					catch (IOException e) {
						System.out.println("Erro na leitura do arquivo");
					}
					flag = false;
					break;
			}
		}
	}
	
	public static void geraLavagemRandom(Lavagem l) throws UnderflowException {
		l.getV().clear();
		for (int i = 0; i < (int)(Math.random()*10 +1); i++) {
			int x = (int)(Math.random()*5);
			switch (x) {
				case 1:
					l.getV().insertLast(new Veiculo("Gol","VW","Carro"));
					break;
				case 2:
					l.getV().insertLast(new Veiculo("Sandero","Renault","Veículo de aplicativo"));
					break;
				case 3:
					l.getV().insertLast(new Veiculo("Vitara","Suzuki","Caminhote"));
					break;
				default:
					l.getV().insertFirst(new Veiculo("Cargo","Ford","Caminhão"));
					break;
			}
		}
	}
	
	public static void menu() {
		System.out.println("1 - Visualizar lista:");
		System.out.println("2 - Inserir veículo:");
		System.out.println("3 - Remover veículo:");
		System.out.println("4 - Visualizar fila estática:");
		System.out.println("5 - Sair");
	}
	public static void menu2() {
		System.out.println("1 - Veículo de aplicativo:");
		System.out.println("2 - Carro:");
		System.out.println("3 - Caminhonete:");
		System.out.println("4 - Caminhão");
	}
}
