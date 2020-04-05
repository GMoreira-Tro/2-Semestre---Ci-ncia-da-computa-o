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
		return "\nAlimento: \n{\n" + super.toString() + "\nValidade: "+ this.validade + "\n}";
	}
	
	public String armazena() {
		return "ID\t" + this.ID +
				"\r\nNome\t" + this.nome +
				"\r\nMarca\t" + this.marca +
				"\r\nPreço(R$)\t" + this.preco +
				"\r\nValidade\t" + this.validade;
	}
}