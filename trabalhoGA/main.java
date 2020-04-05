package trabalhoGA;

import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.*;

public class main {
	private static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception {
		boolean flag =  true;
		char opMenu;
		
		while (flag) {
			
			mainMenu();	
			opMenu = scan.nextLine().charAt(0);
			
			switch(opMenu) {
			case '1':
				System.out.print("\nCadastro de Produto"
						+ "\n1 - Alimento"
						+ "\n2 - Automovel"
						+ "\n3 - Eletronico"
						+ ": ");
				char op1 = scan.nextLine().charAt(0);
				
				switch (op1) {
				case '1':
					/* Cadastro Alimento */
					System.out.println("Cadastro de Alimento");
					cadastraAlimento();
			    	break;
			    case '2':
			    	/* Cadastro Automovel */
			    	System.out.println("Cadastro de Automovel");
			    	cadastraAutomovel();			    	
			    	break;
			    case '3':
			    	/* Cadastro Eletronico */
			    	System.out.println("Cadastro de Eletronico");
			    	cadastraEletronico();
			    	break;
			    default:
			    	System.out.println("Opção inválida.");
			    	break;			    		
			    }
			    break;
			case 2:
				System.out.print("\nDigite o nome ou ID de um produto: ");
				deletaProduto();
				break;
			case 3:
				System.out.println("\nProdutos existentes:");
				controleProdutos.listaProdutos();
				break;
			case 4:
				System.out.print("\nDigite o nome ou ID de um produto: ");
				atualizaProduto(); //Implementar
				break;
			case '6':    
				flag = false;
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
		}
	}
	public static void mainMenu() {
		System.out.print("#=============================#"
				+ "\nMenu Principal"
				+ "\n  1 - Cadastrar produto"
				+ "\n  2 - Deletar produto"
				+ "\n  3 - Listar produtos"
				+ "\n  4 - Atualizar informações"
				+ "\n  5 - Não sei ainda"
				+ "\n  9 - Sair"
				+ ": ");
	}
	public static void cadastraAutomovel() {
		String nome, marca, tipo;
		double preco, pot;
		
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("Marca: ");
		marca = scan.nextLine();
		System.out.println("Preço(R$): ");
		try {
			preco = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException n) {
			preco = 0.0;
		}
		System.out.println("Tipo: ");
		tipo = scan.nextLine();
		System.out.println("Potência: ");
		try {
			pot = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException n) {
			pot = 0.0;
		}
		
		controleProdutos.adicionaProduto((new Automovel(0, nome, marca, preco, tipo, pot)));
	}
	public static void cadastraEletronico() {
		String nome, marca;
		double preco, V, A, W;
		
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("Marca: ");
		marca = scan.nextLine();
		System.out.println("Preço(R$): ");
		try {
			preco = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException n) {
			preco = 0.0;
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
		
		controleProdutos.adicionaProduto((new Eletronico(0, nome, marca, preco, V, A, W)));
	}
	public static void cadastraAlimento() {
		String nome, marca, validade;
		double preco;
		
		System.out.println("Nome: ");
		nome = scan.nextLine();
		System.out.println("Marca: ");
		marca = scan.nextLine();
		System.out.println("Preço(R$): ");
		try {
			preco = Double.parseDouble(scan.nextLine());
		} catch(NumberFormatException n) {
			preco = 0.0;
		}
		System.out.println("Validade: (dd/mm/aaaa)");
		try {
			validade = controleProdutos.converteData((new Date(scan.nextLine())));
		} catch(IllegalArgumentException e) {
		    validade = controleProdutos.converteData((new Date("31/12/2099")));
		}
		
		controleProdutos.adicionaProduto((new Alimento(0, nome, marca, preco, validade)));
	}
	public static void deletaProduto() {
		
		Produto produtoDel = controleProdutos.localizaProduto(scan.nextLine());
		
		if(produtoDel != null) {
			System.out.println(produtoDel);
		}
		System.out.print("\nDeseja deletar? (s/n): ");
		if(scan.nextLine().charAt(0) == 's') {
			controleProdutos.deletaProduto(produtoDel);
		}
		
	}
	public static void atualizaProduto() {
		Produto produtoUpd = controleProdutos.localizaProduto(scan.nextLine());
		
		if(produtoUpd != null) {
			System.out.println(produtoUpd);
		}
		System.out.print("\nDeseja atualizar? (s/n): ");
		if(scan.nextLine().charAt(0) == 's') {
			controleProdutos.atualizaProduto(); //Implementar
		}
	}
}