import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class Main {
	//#========== Guilherme e Luiz Alfredo==========#
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		boolean flag =  true;
		char opMenu;
		File f = new File ("Produtos");
		
			controleProdutos.leTudo(f);
		
		while (flag) {
			
			mainMenu();
			try {
				opMenu = scan.nextLine().charAt(0);
			} catch(Exception e) {
				opMenu = ' ';
			}
			
			switch(opMenu) {
			case '1':
				System.out.print("\nCadastro de Produto"
						+ "\n1 - Alimento"
						+ "\n2 - Automovel"
						+ "\n3 - Eletronico"
						);
				char op1;
				try {
					op1 = scan.nextLine().charAt(0);
				} catch(Exception e) {
					op1 = ' ';
				}
				
				System.out.println();
				switch (op1) {
				case '1':
					/* Cadastro Alimento */
					System.out.println("Cadastro de Alimento");
					cadastraAlimento(true,0);
					System.out.println("\nAlimento cadastrado!");
			    	break;
			    case '2':
			    	/* Cadastro Automovel */
			    	System.out.println("Cadastro de Automovel");
			    	cadastraAutomovel(true,0);
			    	System.out.println("\nAutomóvel cadastrado!");
			    	break;
			    case '3':
			    	/* Cadastro Eletronico */
			    	System.out.println("Cadastro de Eletronico");
			    	cadastraEletronico(true,0);
			    	System.out.println("\nEletrônico cadastrado!");
			    	break;
			    default:
			    	System.out.println("Opção inválida.");
			    	break;			    		
			    }
			    break;
			case '2':
				System.out.print("\nDigite o nome ou ID de um produto: ");
				deletaProduto();
				break;
			case '3':
				char cd;
				System.out.println("\n1 - Ordem direta"
						+ "\n2 - Ordem inversa");
				do {
					cd = scan.nextLine().charAt(0);
				} while (cd != '1' && cd != '2');
				
				System.out.println("\nProdutos existentes:");
				if (cd == '1')
					controleProdutos.listaProdutos(true);
				else
					controleProdutos.listaProdutos(false);
				break;
			case '4':
				System.out.print("\nDigite o nome ou ID de um produto: ");
				atualizaProduto(); //Implementar
				break;
			case '5':
				System.out.println("\nOrdenar por:"
						+ "\n1 - Nome" +
						"\n2 - Marca" +
						"\n3 - Preço");
				char op2;
				try {
					op2 = scan.nextLine().charAt(0);
				} catch(Exception e) {
					op2 = ' ';
				}
				
				switch(op2) {
				case '1':
					controleProdutos.ordenaProdutos(1);
					break;
				case '2':
					controleProdutos.ordenaProdutos(2);
					break;
				case '3':
					controleProdutos.ordenaProdutos(3);
					break;
				default:
					System.out.println("\nOpção inválida!");
					break;
				}
				break;
			case '6':    
				flag = false;
				controleProdutos.escreveTudo(f);
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
	public static void mainMenu() {
		System.out.print("#========== Guilherme e Luiz ==========#"
				+ "\nMenu Principal"
				+ "\n  1 - Cadastrar produto"
				+ "\n  2 - Deletar produto"
				+ "\n  3 - Listar produtos"
				+ "\n  4 - Atualizar informações"
				+ "\n  5 - Ordenar produtos (ID's mudarão!)"
				+ "\n  6 - Sair"
				+ ": ");
	}
	public static void cadastraAutomovel(boolean AddOrUp, int id) {
		String nome, marca, tipo;
		double preco, pot;
		
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("Marca: ");
		marca = scan.nextLine();
		
		while (true) {
			System.out.println("Preço(R$): ");
			try {
				preco = Double.parseDouble(scan.nextLine());
				if (preco < 0)
					throw new PrecoException("Preço inválido!");
				break;
			} 
			catch(PrecoException p) {
				System.out.println(p);
				preco = 0;
			}
			catch(NumberFormatException n) {
				preco = 0.0;
			}
		}
		System.out.println("Tipo: ");
		tipo = scan.nextLine();
		System.out.println("Potência: ");
		try {
			pot = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException n) {
			pot = 0.0;
		}
		if (AddOrUp)
			controleProdutos.adicionaProduto((new Automovel(0, nome, marca, preco, tipo, pot)));
		else {
			controleProdutos.getProdutos().get(id).setMarca(marca);
			controleProdutos.getProdutos().get(id).setNome(nome);
			controleProdutos.getProdutos().get(id).setPreco(preco);
			((Automovel) controleProdutos.getProdutos().get(id)).setPotencia(pot);
		}
	}
	public static void cadastraEletronico(boolean AddOrUp, int id) {
		String nome, marca;
		double preco, V, A, W;
		
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("Marca: ");
		marca = scan.nextLine();
		
		while (true) {
			System.out.println("Preço(R$): ");
			try {
				preco = Double.parseDouble(scan.nextLine());
				if (preco < 0)
					throw new PrecoException("Preço inválido!");
				break;
			} 
			catch(PrecoException p) {
				System.out.println(p);
				preco = 0;
			}
			catch(NumberFormatException n) {
				preco = 0.0;
			}
		}
		System.out.println("Tensão Maxima: ");
		try {
			V = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException n) {
			V = 0.0;
		}
		System.out.println("Corrente Maxima: ");
		try {
			A = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException n) {
			A = 0.0;
		}
		System.out.println("Potência Maxima: ");
		try {
			W = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException n) {
			W = 0.0;
		}
		if (AddOrUp)
			controleProdutos.adicionaProduto((new Eletronico(0, nome, marca, preco, V, A, W)));
		else {
			controleProdutos.getProdutos().get(id).setMarca(marca);
			controleProdutos.getProdutos().get(id).setNome(nome);
			controleProdutos.getProdutos().get(id).setPreco(preco);
			((Eletronico) controleProdutos.getProdutos().get(id)).setCorrenteMaxima(A);
			((Eletronico) controleProdutos.getProdutos().get(id)).setPotenciaMaxima(W);
			((Eletronico) controleProdutos.getProdutos().get(id)).setTensaoMaxima(V);
		}
	}
	public static void cadastraAlimento(boolean AddOrUp, int id) {
		String nome, marca, validade;
		double preco;
		
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("Marca: ");
		marca = scan.nextLine();
		
		while (true) {
			System.out.println("Preço(R$): ");
			try {
				preco = Double.parseDouble(scan.nextLine());
				if (preco < 0)
					throw new PrecoException("Preço inválido!");
				break;
			} 
			catch(PrecoException p) {
				System.out.println(p);
				preco = 0;
			}
			catch(NumberFormatException n) {
				preco = 0.0;
			}
		}
		System.out.println("Validade: (mm/dd/aaaa)");
		try {
			validade = controleProdutos.converteData((new Date(scan.nextLine())));
		} catch(IllegalArgumentException e) {
		    validade = controleProdutos.converteData((new Date("12/31/2099")));
		}
		if (AddOrUp)
			controleProdutos.adicionaProduto((new Alimento(0, nome, marca, preco, validade)));
		else {
			controleProdutos.getProdutos().get(id).setMarca(marca);
			controleProdutos.getProdutos().get(id).setNome(nome);
			controleProdutos.getProdutos().get(id).setPreco(preco);
			((Alimento) controleProdutos.getProdutos().get(id)).setValidade(validade);
		}
	}
	public static void deletaProduto() {
		
		Produto produtoDel = controleProdutos.localizaProduto(scan.nextLine());
		
		if(produtoDel != null) {
			System.out.println(produtoDel);
			System.out.print("\nDeseja deletar? (s/n): ");
			if(scan.nextLine().charAt(0) == 's') {
				controleProdutos.reduzIDs(produtoDel.getID());
				controleProdutos.deletaProduto(produtoDel);
				System.out.println("\nProdutos cujos ID's eram maiores do que o "
						+ "produto deletado foram reduzidos em 1!");
			}
		}
		else 
			System.out.println("\nNão foi possível localizar o produto.");
		
	}
	public static void atualizaProduto() {
		Produto produtoUpd = controleProdutos.localizaProduto(scan.nextLine());
		
		if(produtoUpd != null) {
			System.out.println(produtoUpd);
			System.out.print("\nDeseja atualizar? (s/n): ");
			if(scan.nextLine().charAt(0) == 's') {
				if (produtoUpd instanceof Automovel)
					cadastraAutomovel(false,produtoUpd.getID());
				else if (produtoUpd instanceof Eletronico)
					cadastraEletronico(false, produtoUpd.getID());
				else
					cadastraAlimento(false, produtoUpd.getID());
			}
		}
	}
}