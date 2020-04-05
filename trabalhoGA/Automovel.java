package trabalhoGA;

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
		return super.toString() +" "+ this.tipo +" "+ this.potencia; 
	}
}