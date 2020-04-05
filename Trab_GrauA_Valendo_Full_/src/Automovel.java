public class Automovel extends Produto{
	private String tipo;
	private double potencia;
	
	public Automovel(int ID, String nome, String marca, double preco, String tipo, double pot) {
		super(ID, nome, marca, preco);
		this.tipo = tipo;
		this.potencia = pot;
	}
	public double getPotencia() {
		return potencia;
	}
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	@Override
	public String toString() {
		return "\nAutom�vel: \n{\n" + super.toString() + "\nTipo: "+ this.tipo + "\nPot�ncia: "+ this.potencia
				+ "\n}"; 
	}
	
	public String armazena() {
		return "ID\t" + this.ID +
				"\r\nNome\t" + this.nome +
				"\r\nMarca\t" + this.marca +
				"\r\nPre�o(R$)\t" + this.preco +
				"\r\nTipo\t" + this.tipo +
				"\r\nPot�ncia do motor\t" + this.potencia; 
	}
}