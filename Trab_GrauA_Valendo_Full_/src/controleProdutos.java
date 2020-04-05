
import java.io.*;
import java.text.*;
import java.util.*;

public class controleProdutos {
	private static String allfile;
	private static String database[];
	private static String data[][];
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
	
	public static ArrayList<Produto> getProdutos() {
		return produtos;
	}
	
	public static void leTudo(File f) {
		
		String marca, nome, tipo, validade;
		double preco, V, A, W, pot;
		int id;
		marca = nome = tipo = validade = "";
		preco = V = A = W = pot = id = 0;
		char stats = ' ';
		
		try {
			FileReader fr = new FileReader (f);
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			allfile = line +  "\n";
			while ((line = in.readLine()) != null) {
				allfile += line + "\n";
			}
			try {
				database = allfile.split("\n");
				data = new String[database.length][];
				for (int i = 0; i < database.length; i++) {
					data[i] = database[i].split("\t");
				}
				for (int i = 0; i < database.length; i++) {
					try {
					while(data[i].length > 1) {
						
							
								if (data[i][0].equals("ID"))
									id = Integer.parseInt(data[i][1]);
								else if (data[i][0].equals("Nome"))
									nome = data[i][1];
								else if (data[i][0].equals("Marca"))
									marca = data[i][1];
								else if (data[i][0].equals("Tipo"))
									tipo = data[i][1];
								else if (data[i][0].equals("Validade")) {
									validade = data[i][1];
									stats = '0';
								}
								else if (data[i][0].equals("Preço(R$)"))
									preco = Double.parseDouble(data[i][1]);
								else if (data[i][0].equals("Tensão(V)")) {
									V = Double.parseDouble(data[i][1]);
									stats = '1';
								}
								else if (data[i][0].equals("Corrente(A)"))
									A = Double.parseDouble(data[i][1]);
								else if (data[i][0].equals("Potência(W)"))
									W = Double.parseDouble(data[i][1]);
								else if (data[i][0].equals("Potência do motor")) {
									pot = Double.parseDouble(data[i][1]);
									stats = '2';
								}
							
							i++;
						}
					}
				catch(ArrayIndexOutOfBoundsException ex) {
				}
					if (stats == '2') {
						produtos.add(new Automovel(
								id,
								nome,marca,preco,tipo,pot));
					}
					else if (stats == '0') {

							produtos.add(new Alimento(
									id,
									nome,marca,preco,validade));
					}
					else {
							produtos.add(new Eletronico(
									id,
									nome,marca,preco,V,A,W));
						}
				}
			} catch(Exception ex) {
				System.out.println(ex);
			}
		}
		catch(FileNotFoundException faa) {
			//System.out.println(faa);
		}
		catch(IOException i) {
			System.out.println(i);
		}
	}
	
	public static void escreveTudo(File f) {
		try {
			FileWriter fw = new FileWriter(f,false);
			for (Produto produto : produtos) {
				fw.write(produto.armazena() + "\n\n");
			}
			fw.close();
		}
			catch(FileNotFoundException fn) {
				System.out.println(fn);
			}
		catch(IOException i) {
			System.out.println(i);
		}
	}
	public static void adicionaProduto(Produto produto) {
		if (produtos.size() > 0)
			produto.incrementaID(produtos.get(produtos.size() - 1).getID() + 1);
		produtos.add(produto);
		//System.out.println("\n" + produto.getClass() + " cadastrado!");
	}
	public static void deletaProduto(Produto produto) {
		produtos.remove(produto);
		System.out.println("\nProduto deletado!");
	}
	public static void atualizaProduto() {
		//Implementar
	}
	public static void listaProdutos(boolean CresceDesce) {
		if (CresceDesce) {
			for(Produto produto : produtos) {
				System.out.println(produto);
			}
		}
		else {
			for (int i = produtos.size()-1; i >= 0; i--) {
				System.out.println(produtos.get(i));
			}
		}
	}
	public static Produto localizaProduto(String id) {
		for(Produto produto : produtos) {
			if(String.valueOf(produto.getID()).equals(id) || produto.getNome().equals(id)) {
				return produto;
			}
		}
		return null;
	}
	public static String converteData(Date data) {
		return df.format(data);
	}
	
	public static void reduzIDs(int id) {
		for (int i = id; i < produtos.size(); i++) {
			produtos.get(i).incrementaID(produtos.get(i).getID()-1);
		}
	}
	
	public static void ordenaProdutos(int type) {
		
		int min, aux2;
		Produto auxiliar;
		
		switch(type) {
		case 3:
			for (int i = 0; i < produtos.size(); i++) {
				min = i;
				for (int  j = i+1; j < produtos.size(); j++) {
					if (produtos.get(i).getPreco() > produtos.get(j).getPreco())
						min = j;
				}
				if (i != min) {
					
					aux2 = produtos.get(i).getID();
					produtos.get(i).incrementaID(produtos.get(min).getID());
					produtos.get(min).incrementaID(aux2);
					
					auxiliar = produtos.get(i);
					produtos.set(i, produtos.get(min));
					produtos.set(min, auxiliar);
				}
			}
			System.out.println("Produtos ordenados!");
			break;
			
		case 2:
			for (int i = 0; i < produtos.size(); i++) {
				min = i;
				for (int  j = i+1; j < produtos.size(); j++) {
					if (recursivaNome(0,i,j))
						min = j;
				}
				if (i != min) {
					
					aux2 = produtos.get(i).getID();
					produtos.get(i).incrementaID(produtos.get(min).getID());
					produtos.get(min).incrementaID(aux2);
					
					auxiliar = produtos.get(i);
					produtos.set(i, produtos.get(min));
					produtos.set(min, auxiliar);
				}
			}
			System.out.println("Produtos ordenados!");
			break;
		case 1:
			for (int i = 0; i < produtos.size(); i++) {
				min = i;
				for (int  j = i+1; j < produtos.size(); j++) {
					if (recursivaMarca(0,i,j))
						min = j;
				}
				if (i != min) {
					
					aux2 = produtos.get(i).getID();
					produtos.get(i).incrementaID(produtos.get(min).getID());
					produtos.get(min).incrementaID(aux2);
					
					auxiliar = produtos.get(i);
					produtos.set(i, produtos.get(min));
					produtos.set(min, auxiliar);
				}
			}
			System.out.println("Produtos ordenados!");
			break;
		default:
			System.out.println("Opção Inválida!");
		}
	}
	
	private static boolean recursivaNome(int index, int i, int j) {
			
			if ((produtos.get(i).getNome().length() == index)
					|| (produtos.get(j).getNome().length() == index)) {
				if (produtos.get(i).getNome().length() >= 
						produtos.get(j).getNome().length())
					return false;
				else
					return true;
			}
				
			if (produtos.get(i).getNome().charAt(index) > 
			produtos.get(j).getNome().charAt(index))
				return true;
			else if (produtos.get(i).getNome().charAt(index) < 
			produtos.get(j).getNome().charAt(index))
				return false;
			
			else {
					return recursivaNome(++index,i,j);
			}
		
	}
	
	private static boolean recursivaMarca(int index, int i, int j) {
			
		if ((produtos.get(i).getMarca().length() == index)
				|| (produtos.get(j).getMarca().length() == index)) {
			if (produtos.get(i).getMarca().length() >= 
					produtos.get(j).getMarca().length())
				return false;
			else
				return true;
		}
			if (produtos.get(i).getMarca().charAt(index) > 
			produtos.get(j).getMarca().charAt(index))
				return true;
			else if (produtos.get(i).getMarca().charAt(index) < 
			produtos.get(j).getMarca().charAt(index))
				return false;
			else {
					return recursivaNome(++index,i,j);
				}	
	}
}