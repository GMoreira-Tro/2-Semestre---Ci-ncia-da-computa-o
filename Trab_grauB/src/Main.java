import java.io.*;
import java.util.*;

public class Main {
	public static Scanner scan = new Scanner(System.in);
	public static int t[] = {0};
	
	public static void main(String[] args) {
		//A lista serve como nosso banco de dados, mas só adicionamos
		//ou removemos elementos dela.
		List<Galho<Estabelecimento>> arvore = new ArrayList<Galho<Estabelecimento>>();
		int x; boolean flag = true;
		File f = new File("Estabelecimentos.txt");
		
		leArquivo(f, arvore);
		/*Não dá pra ler o arquivo pois fica extremamente pesado. 
		Precisaríamos de um banco de dados pra suporte :( */
		
		while(flag) {
			
			menu();
			while (true) {
				try {
					x = Integer.parseInt(scan.nextLine());
					break;
				}
				catch(Exception e) {
				
				}
			}
			System.out.println();
			switch(x) {
				case 1:
				cadastro(arvore);	
				System.out.println();
				break;
				
			case 2:
				if (arvore.isEmpty()) {
					System.out.println("Nenhum estabelecimento cadastrado\n");
					break;
				}
				arvore.forEach(each -> each.getData().setCodigo_estruturado(""));
				codigoConcatenado(arvore);
				List<Galho<Estabelecimento>> a4 = new ArrayList<Galho<Estabelecimento>>();
				a4.addAll(arvore);
				a4.removeIf(each -> each.getData().getNivel() != 1);
				a4.forEach(each -> each.printTree(each));
				System.out.println();
				break;
			case 3:
				if (arvore.isEmpty()) {
					System.out.println("Nenhum estabelecimento cadastrado\n");
					break;
				}
				listarOpcoes(arvore);
				System.out.println();
				try {
					int edit = Integer.parseInt(scan.nextLine());
					List<Galho<Estabelecimento>> sql = new ArrayList<Galho<Estabelecimento>>();
					sql.addAll(arvore);
					sql.removeIf(each -> each.getId() != edit);
					
					edit(arvore,sql.get(0));
					
				}
				catch(Exception e) {
					System.out.println("\nOpção inválida!");
				}
				System.out.println();
				break;
			case 4:
				if (arvore.isEmpty()) {
					System.out.println("Nenhum estabelecimento cadastrado\n");
					break;
				}
				listarOpcoes(arvore);
				System.out.println();
				try {
					int edit = Integer.parseInt(scan.nextLine());
					List<Galho<Estabelecimento>> sql = new ArrayList<Galho<Estabelecimento>>();
					sql.addAll(arvore);
					sql.removeIf(each -> each.getId() != edit);
					if (!sql.get(0).getFilhos().isEmpty())
						throw new InconsistentQuery();
					try {
						arvore.get(arvore.indexOf(sql.get(0).getPai())).
						getFilhos().remove(arvore.get(arvore.indexOf(sql.get(0))));
					}
					catch(Exception ex) {
						
					}
					arvore.remove(arvore.get(arvore.indexOf(sql.get(0))));
					System.out.println("\nEstabelecimento excluído!");
					
				}
				catch(InconsistentQuery q) {
					System.out.println("\nNão se pode deletar estabelecimentos com filhos!");
				}
				catch(Exception e) {
					System.out.println("\nOpção inválida!");
				}
				System.out.println();
				break;
			case 5:
				flag = false;
				break;
			}	
			
		}
		codigoConcatenado(arvore);
		arquivar(f,arvore);
	}
	
	public static void menu() {
		System.out.println("1 - Cadastrar estabelecimento");
		System.out.println("2 - Visualizar árvore");
		System.out.println("3 - Editar estabelecimento");
		System.out.println("4 - Deletar estabelecimento");
		System.out.println("5 - Sair");
		System.out.println();
	}
	
	public static void listarOpcoes(List<Galho<Estabelecimento>> arvore) {
		List<Galho<Estabelecimento>> a2 = new ArrayList<Galho<Estabelecimento>>();
		a2.addAll(arvore);
		a2.removeIf(each -> each.getData().getNivel() != 1);
		int i[] = {0};
		t[0] = 0;
		
		for (; i[0] < a2.size(); i[0]++) {
			arvore.get(i[0]+t[0]).setId(i[0]+t[0]+1);
			System.out.println(i[0]+t[0]+1 + " - " + a2.get(i[0]).getData().getNome());
			for (Galho<Estabelecimento> each : a2.get(i[0]).getFilhos()) {
				printGalho(i[0],each,arvore);
			}
		}
	}
	
	public static void listarPossiveisPais(List<Galho<Estabelecimento>> arvore) {
		int i[] = {0};
		
		for (; i[0] < arvore.size(); i[0]++) {
			System.out.println(i[0]+1 + " - " + arvore.get(i[0]).getData().getNome());
			arvore.get(i[0]).setId(i[0]+1);
		}
	}
	
	public static void printGalho(int i, Galho<Estabelecimento> g, List<Galho<Estabelecimento>> arvore) {	
		t[0]++;
		String tab = "";
		for (int x = 0; x < g.getPai().getData().getNivel(); x++) {
			tab += "   ";
		}
		System.out.println(tab + (i+t[0]+1) + " - " + g.getData().getNome());
		arvore.get(i+t[0]).setId(i+t[0]+1);
		g.getFilhos().forEach(each -> printGalho(i,each,arvore));
	}
	
	public static void cadastro(List<Galho<Estabelecimento>> arvore) {
		String nome;
		int nivel[] = {0}, codigo[] = {0};
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("\nNível: ");
		while(true) {
			try {
				nivel[0] = Integer.parseInt(scan.nextLine());
				if (nivel[0] < 1)
					throw new Exception();
				break;
			}
			catch(Exception e) {
				
			}
		}
		
		System.out.println("\nCódigo reduzido: ");
		while(true) {
			try {
				codigo[0] = Integer.parseInt(scan.nextLine());
				if (codigo[0] < 1 || codigo[0] > 9)
					throw new Exception();
				break;
			}
			catch(Exception e) {
				
			}
		}
		List<Galho<Estabelecimento>> a2 = new ArrayList<Galho<Estabelecimento>>();
		a2.addAll(arvore);
		a2.removeIf(each -> each.getData().getNivel() != nivel[0]);
		a2.removeIf(each -> each.getData().getCodigo_reduzido() != codigo[0]);
		if (!a2.isEmpty()) {
			System.out.println("Código reduzido deve ser único por nível!");
		}
		else {
			Estabelecimento e = new Estabelecimento(nome,codigo[0],nivel[0]);
			Galho<Estabelecimento> g = new Galho(e);
			
			if (nivel[0] != 1) {
				List<Galho<Estabelecimento>> a3 = new ArrayList<Galho<Estabelecimento>>();
				a3.addAll(arvore);
				a3.removeIf(each -> each.getData().getNivel() != g.getData().getNivel()-1);
				if (a3.isEmpty())
					System.out.println("\nNão se pode cadastrar um estabelecimento neste nível ainda!");
				else {
					System.out.println("\nEscolha um pai\n");
					listarPossiveisPais(a3);
					int pai;
					try {
						pai = Integer.parseInt(scan.nextLine());
						e.setPai(e.search(nivel[0]-1, arvore, pai));
						g.setData(e);
						a3.removeIf(each -> each.getData() != e.getPai());
						g.setPai(a3.get(0));
						g.getPai().getFilhos().add(g);
						arvore.add(g);
						System.out.println("\nEstabelecimento cadastrado!");
					}
					catch(Exception ex) {
						System.out.println("\nOpção inválida!");
					}
				}
			}
			else {
				arvore.add(g);
				System.out.println("\nEstabelecimento cadastrado!");
			}
		}
	}
	
	public static void edit(List<Galho<Estabelecimento>> arvore, Galho<Estabelecimento> g_ref) {
		String nome;
		int nivel[] = {0}, codigo[] = {0};
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("\nNível: ");
		while(true) {
			try {
				nivel[0] = Integer.parseInt(scan.nextLine());
				if (nivel[0] < 1)
					throw new Exception();
				break;
			}
			catch(Exception e) {
				
			}
		}
		
		try {
				if(!g_ref.getFilhos().isEmpty() && nivel[0] != g_ref.getData().getNivel())
					throw new Exception();
			
			
			System.out.println("\nCódigo reduzido: ");
			while(true) {
				try {
					codigo[0] = Integer.parseInt(scan.nextLine());
					if (codigo[0] < 1 || codigo[0] > 9)
						throw new Exception();
					break;
				}
				catch(Exception e) {
					
				}
			}
			List<Galho<Estabelecimento>> a2 = new ArrayList<Galho<Estabelecimento>>();
			Galho<Estabelecimento> ref = g_ref;
			a2.addAll(arvore);
			a2.removeIf(each -> each.getData().getNivel() != nivel[0]);
			a2.removeIf(each -> each.getData().getCodigo_reduzido() != codigo[0]
					|| each.getData() == ref.getData());
			if (!a2.isEmpty()) {
				System.out.println("Código reduzido deve ser único por nível!");
			}
			else {
				Estabelecimento e = new Estabelecimento(nome,codigo[0],nivel[0]);
				Galho<Estabelecimento> g = new Galho(e);
				
				if (nivel[0] != 1) {
					List<Galho<Estabelecimento>> a3 = new ArrayList<Galho<Estabelecimento>>();
					a3.addAll(arvore);
					a3.removeIf(each -> each.getData().getNivel() != g.getData().getNivel()-1
							|| each.getData() == ref.getData());
					if (a3.isEmpty())
						System.out.println("\nNão se pode cadastrar um estabelecimento neste nível ainda!");
					else {
						System.out.println("\nEscolha um pai\n");
						listarPossiveisPais(a3);
						int pai;
						try {
							pai = Integer.parseInt(scan.nextLine());
							g.getData().setPai(e.search(nivel[0]-1, arvore, pai));
							a3.removeIf(each -> each.getData() != e.getPai());
							g.setPai(a3.get(0));
							
							try {
								arvore.get(arvore.indexOf(g_ref.getPai())).
								getFilhos().remove(
										g_ref.getPai().getFilhos().indexOf(g_ref)
								);
							}
							catch(Exception en) {
								
							}
							System.out.println("aaa");
							arvore.remove(arvore.indexOf(g_ref));		
							
							g_ref.setData(g.getData());
							g_ref.setPai(g.getPai());
							arvore.add(g_ref);
							try {
								arvore.get(arvore.indexOf(g_ref.getPai())).addFilho(g_ref);
							}
							catch(Exception en) {
								
							}
							System.out.println("\nEstabelecimento editado!");
						}
						catch(Exception ex) {
							System.out.println("\nOpção inválida!");
						}
					}
				}
				else {
					try {
						arvore.get(arvore.indexOf(g_ref.getPai())).
						getFilhos().remove(
								g_ref.getPai().getFilhos().indexOf(g_ref)
						);
					}
					catch(Exception exx) {
						//System.out.println(exx);
					}
					arvore.remove(arvore.indexOf(g_ref));
					g_ref.setData(g.getData());
					g_ref.setPai(null);
					arvore.add(g_ref);
					System.out.println("\nEstabelecimento editado!");
				}
			}
		}
		catch(Exception e) {
			System.out.println("Não se pode alterar o nível de um estabelecimento com filhos!");
		}
	}
	
	public static void codigoConcatenado(List<Galho<Estabelecimento>> arvore) {
		
		int p[] = {0};
		for (; p[0] < arvore.size(); p[0]++) {
			arvore.get(p[0]).getData().setCodigo_estruturado
			(swap(concatenaCodigo(arvore.get(p[0]),"")) + "."
					+ arvore.get(p[0]).getData().getCodigo_reduzido());
			if (arvore.get(p[0]).getData().getCodigo_estruturado().charAt(0)
					== '.')
				arvore.get(p[0]).getData().setCodigo_estruturado(
						 arvore.get(p[0]).getData().getCodigo_estruturado()
						.substring(1));
		}
	}
	
	public static String concatenaCodigo(Galho<Estabelecimento> g, String s) {
		if (g.getPai() == null)
			return s;
		else {
			s += g.getPai().getData().getCodigo_reduzido() + ".";
			return concatenaCodigo(g.getPai(),s);
		}
	}
	
	public static void arquivar(File f, List<Galho<Estabelecimento>> arvore) {
		try {
			FileWriter fw = new FileWriter(f,false);
			for (int i = 0; i < arvore.size()-1; i++) {
				fw.write(arvore.get(i).getData().toString()  + "\r\n\n");
			}
			fw.write(arvore.get(arvore.size()-1).toString());
			fw.close();
		}
		catch(FileNotFoundException exx) {
			System.out.println(exx);
		}
		catch(IOException ex) {
			System.out.println(ex);
		}
	}
	
	public static void leArquivo(File f, List<Galho<Estabelecimento>> arvore) {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader in = new BufferedReader(fr);
			
			String line = in.readLine();
			String allFile = line + "\n";
			while ((line = in.readLine()) != null) {
				allFile += line + "\n";
			}
			String nome,nivel,pai,estruturado,reduzido;
			String split[] = allFile.split("\n\n");
			for (int i = 0; i < split.length; i++) {
				String splitted[] = split[i].split("\n");
				
				nome = splitted[0].split(": ")[1];
				nivel = splitted[1].split(": ")[1];
				try {
					pai = splitted[2].split(": ")[1];
				}
				catch(Exception e) {
					pai = splitted[2];
				}
				estruturado = splitted[3].split(": ")[1];
				reduzido = splitted[4].split(": ")[1];
				
				Estabelecimento e = new Estabelecimento(nome, 
						Integer.parseInt(reduzido), estruturado,
						Integer.parseInt(nivel));
				Galho<Estabelecimento> g = new Galho<Estabelecimento>(e);
				
				arvore.add(g);
			}
			int i[] = {0};
			for (; i[0] < arvore.size(); i[0]++) {
				List<Galho<Estabelecimento>> sql = new ArrayList<Galho<Estabelecimento>>();
				List<Galho<Estabelecimento>> sql2 = new ArrayList<Galho<Estabelecimento>>();
				String verifica_filho[];
				sql.addAll(arvore);
				sql.removeIf(each -> each.getData().getNivel() !=
						arvore.get(i[0]).getData().getNivel()+1);
				for (int j = 0; j < sql.size(); j++) {
					String x = sql.get(j).getData().getCodigo_estruturado();
					verifica_filho = x.split(".");
					System.out.println(x);
					System.out.println(verifica_filho.length);
					// ESTOURA A MEMÓRIA AQUI!
					
					try {
						//System.out.println(verifica_filho[verifica_filho.length-2]);
						if (Integer.parseInt(verifica_filho[verifica_filho.length-2])
								== arvore.get(i[0]).getData().getCodigo_reduzido())
							sql2.add(sql.get(j));
					}
					catch(Exception eaa) {
						
					}
				}
				
				sql2.forEach(each -> arvore.get(i[0]).getFilhos().add(each));
				sql2.forEach(each -> each.setPai(arvore.get(i[0])));
				sql2.forEach(each -> each.getData().setPai(
						arvore.get(i[0]).getData()));
				
			}
			
		} 
		catch (FileNotFoundException ex) {
			
		}
		catch(IOException exx) {
			
		}
		
	}
	
	public static String swap(String s) {
		String ss = "";
		for (int i = 0; i < s.length(); i++) {
			ss += s.charAt(s.length()-1-i);
		}
		return ss;
	}
}
