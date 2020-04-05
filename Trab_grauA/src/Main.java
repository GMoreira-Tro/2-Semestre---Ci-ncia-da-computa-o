import java.io.*;
import java.util.*;

public class Main {
	public static final int CADASTRO = 1;
	public static final int DELETAR = 2;
	public static final int BUSCA = 3;
	public static String allFile = "";
	public static String[] database;
	public static String[][] data;
	public static List<Registro> registros = new ArrayList<Registro>();
	public static File f = new File("fazenda_happi_bois.txt");
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x;
		
			
		do {
			leTudo();
			mainMenu();
			do {
				try {
					x = Integer.parseInt(scan.nextLine());
				} catch(NumberFormatException n) { x = 0;}
			} while (x > 4 || x < 1);
			
			switch(x) {
				case CADASTRO:
					try {
						FileWriter fw = new FileWriter(f,false);
						int ano = 0; double hectares = 0, sacas = 0;
						String grao;
						System.out.println("Grão plantado:");
						grao = scan.nextLine();
						do {
							try {
								System.out.println("\nAno do plantio:");
								ano = Integer.parseInt(scan.nextLine());
							} catch(NumberFormatException n) {}
						}
						while(ano < 1);
						
						registros.add(new Registro(String.valueOf(ano)+grao));
						String c = " ";
						boolean flag = false; int j = 0;
						if (registros.size() > 1) {
							for (int i = 0; i < registros.size()-1; i++) {
								if (registros.get(i).getNome_grao().equals
										(registros.get(registros.size() -1).getNome_grao())) 
								{
									j = i;
									flag = true;
									System.out.println("Registro já existente, deseja sobrescrevê-lo?(y/n)");
									c = scan.nextLine();
									registros.remove(registros.size()-1);
									break;
								}
							}
						}
						
						if (c.equals("y".toLowerCase()) || !flag) {
							do {
								try {
									System.out.println("\nQuantidade de hectares plantados:");
									hectares = Double.parseDouble(scan.nextLine());
								} catch(NumberFormatException n) {}
							}
							while(hectares <= 0);
							do {
								try {
									System.out.println("\nQuantidade de sacas colhidas:");
									sacas = Double.parseDouble(scan.nextLine());
								} catch(NumberFormatException n) {}
							}
							while(sacas <= 0);
						}	
							//fw.write("Ano\tHectares\tSacas");
						try {
							if (c.equals("y".toLowerCase())) {
								registros.set(j, new Registro(String.valueOf(ano)+grao));
								data[j][2] = String.valueOf(hectares);
								data[j][3] = String.valueOf(sacas);
							}
						} catch(Exception excecao) {System.out.println(excecao);}
							
							if (data != null) {
								fw.write("\r\n");
								for (int i = 0; i < data.length; i++) {
									if (String.valueOf(data[i].length) != null) {
										for (int k = 0; k < data[i].length; k++) {
											fw.write(data[i][k]);
											if (data[0].length-1 != k) fw.write("\t");
										}
									}fw.write("\r\n");
								}
							}
							if (!flag) {
									if (data == null) fw.write("\r\n");
									fw.write(grao + "\t" + ano + "\t" + hectares + "\t" + sacas);
								}
							
						fw.close();
						break;
					}
						
					catch(FileNotFoundException fa) {
						System.out.println(fa);
					}
					catch(IOException i) {
						System.out.println(i);
					}
				
				case BUSCA:
					try {
						FileReader fr = new FileReader (f);
						BufferedReader in = new BufferedReader(fr);
						String line = in.readLine();
						String allFile = line;
						while((line = in.readLine()) != null) {
							allFile += line + "\n";
						}
						String[] database = allFile.split("\n");
						String[][] data = new String[database.length][];
						for (int i = 0; i < database.length; i++) {
							data[i] = database[i].split("\t");
						}
						
						try {
							for (int i = 0; i < data.length; i++) {
								for (int j = 0; j < data[0].length; j++) {
									if (j%4 == 0) System.out.print("Grão: ");
									else if (j%4 == 1) System.out.print("Ano: ");
									else if(j%4 == 2) System.out.print("Hectares: ");
									else System.out.print("Sacas: ");
									if (j%4 != 3)
										System.out.print(data[i][j] + " |");
									else System.out.print(data[i][j] + "\n");
								}
							}
						} catch (Exception e) {}
						//System.out.println(registros.get(registros.size()-1).getNome_grao());
						
					}
					catch(FileNotFoundException fds) {
						
					}
					catch(IOException xy) {
						System.out.println(xy);
					}
					catch(Exception nulo) {
						
					}
					break;
				case DELETAR:
					detalhes();
					break;
				default:
					break;
			}
			System.out.println();
		} while (x != 4);	
			
	}
	
	public static void mainMenu() {
		System.out.println("1 - Cadastrar plantio");
		System.out.println("2 - Detalhes do plantio");
		System.out.println("3 - Buscar dados do plantio");
		System.out.println("4 - Sair");
	}
	
	public static void leTudo() {
		try {
			FileReader fr = new FileReader (f);
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			allFile = line;
			while((line = in.readLine()) != null) {
				allFile += line + "\n";
			}
			database = allFile.split("\n");
			data = new String[database.length][];
			for (int i = 0; i < database.length; i++) {
				data[i] = database[i].split("\t");
			}
			
			for (int i = 0; i < data.length; i++) {
				registros.add( new Registro(String.valueOf(data[i][1]) + data[i][0]));
			}
			
		}
		catch(FileNotFoundException fds) {
			
		}
		catch(IOException xy) {
			System.out.println(xy);
		}
		catch(Exception lul) {
		
		}
	}
	
	public static void detalhes() {
		
		String graos_ano = "";
		boolean ja_foi= false;
		int t = 0;
		double hects = 0;
		String mais_produtivo_sacas = "", mais_produtivo_grao;
		
		for (int i = 0; i < data.length; i++) {
			for (int k = i-1; k > 0; k--) {
				if (data[k][1].equals(data[i][1])) ja_foi = true;
			}
			if (!ja_foi) {
				System.out.print("\nGrãos plantados no ano " + data[i][1] + ":");
				mais_produtivo_sacas = data[i][3];
				mais_produtivo_grao = data[i][0];
				for (int j = i; j < data.length; j++) {
					try {
						if (data[j][1].equals(data[i][1])) {
							graos_ano += "\n" + data[j][0];
							if (Double.parseDouble(data[j][3]) >
							Double.parseDouble(data[i][3])) {
								mais_produtivo_sacas = data[j][3];
								mais_produtivo_grao  = data[j][0];
							}
						}
					} catch (Exception sla) {}
					
				} System.out.println(graos_ano);
				graos_ano = "";
				System.out.println("Grão mais produzido: " + mais_produtivo_grao +
						"\n" + mais_produtivo_sacas + " sacas");
				System.out.println();
			
			System.out.println();} ja_foi = false;}
		double media = 0;
		
		for (int i = 0; i < data.length; i++) {
			for (int k = i-1; k > 0; k--) {
				if (data[k][0].equals(data[i][0])) ja_foi = true;
			}
			if (!ja_foi) {
				System.out.print("\n\nQuantidade de colheitas do grão '" + data[i][0] + "':");
				for (int j = i; j < data.length; j++) {
					try {
						if (data[j][0].equals(data[i][0])) {
							t++;
							hects += Double.parseDouble(data[j][2]);
						}
					} catch (Exception sla) {}
					
				} System.out.print(t);
				/*if (data[i][1].equals("2019") || data[i][1].equals("2018")
						|| data[i][1].equals("2017"))
					media += Double.parseDouble(data[i][3]);
				media = media/3;*/
				t = 0;
				System.out.println("\nQuantidade de hectares do grão '" +  data[i][0] + "':"+ hects);
				hects = 0;
				//System.out.println("Média de produção de sacas do grão nos últimos 3 anos:"
				//		+ media);
				//media = 0;
			}
			ja_foi = false;
		}
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			for (int k = i-1; k > 0; k--) {
				if (data[k][0].equals(data[i][0])) ja_foi = true;
			}
			if (!ja_foi) {
				for (int j = i; j < data.length; j++) {
					if ((data[j][1].equals("2019") || data[j][1].equals("2018") ||
							data[j][1].equals("2017")) && data[j][0].equals(data[i][0])) {
						media += Double.parseDouble(data[j][3]);
					}
				}
				media = media/3;
				System.out.printf("Média de produção de sacas do grão '" +
				data[i][0] +"' nos últimos 3 anos: " + 
						"%.2f\n", media);
				media = 0;
			}
			ja_foi = false;
		}
		
	}
}
