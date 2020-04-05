public abstract class Produto {
	protected int ID = 0;
	protected String nome;
	protected String marca;
	protected double preco;	
	
	public Produto(int ID, String nome, String marca, double preco) {
		this.ID = ID;
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
	}
	@Override
	public String toString() {
		return "ID: " + this.ID + "\nNome: "+ this.nome +
				"\nMarca: "+ this.marca + "\nPreço: "+ this.preco; 
	}
	public int getID() {
		return ID;
	}
	public void incrementaID(int ID) {
		this.ID = ID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public abstract String armazena();
}