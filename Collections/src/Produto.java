
public class Produto implements Comparable{
	private String nome;
	private double preco;
	
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "\nProduto: " + this.nome + "\nPreço: " + this.preco + "\n";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int compareTo(Object p) {
		return this.getNome().compareTo(((Produto) p).getNome());
	}
}
