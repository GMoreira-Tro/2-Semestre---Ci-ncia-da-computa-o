package trabalhoGA;

import java.text.*;
import java.util.*;

public class controleProdutos {
	private static ArrayList<Produto> produtos = new ArrayList<Produto>();
	private static DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
	
	public controleProdutos() {
		
	}
	public static void adicionaProduto(Produto produto) {
		produto.incrementaID(produtos.get(produtos.size() - 1).getID() + 1);
		produtos.add(produto);
		System.out.println("\n" + produto.getClass() + " cadastrado!");
	}
	public static void deletaProduto(Produto produto) {
		produtos.remove(produto);
		System.out.println("\nProduto deletado!");
	}
	public static void atualizaProduto() {
		//Implementar
	}
	public static void listaProdutos() {
		for(Produto produto : produtos) {
			System.out.println(produto);
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
}