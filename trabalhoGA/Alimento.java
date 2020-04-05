package trabalhoGA;

import java.util.*;

public class Alimento extends Produto{
	private String validade;

	public Alimento(int ID, String nome, String marca, double preco, String validade) {
		super(ID, nome, marca, preco);
		this.validade = validade;
	}
	public String getValidade() {
		return validade;
	}
	public void setValidade(String validade) {
		this.validade = validade;
	}
	@Override
	public String toString() {
		return super.toString() +" "+ this.validade;
	}
}