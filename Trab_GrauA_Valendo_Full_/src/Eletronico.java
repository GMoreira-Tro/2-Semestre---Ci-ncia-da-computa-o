public class Eletronico extends Produto{
	private double tensaoMaxima;
	private double correnteMaxima;
	private double potenciaMaxima;
	
	public Eletronico(int ID, String nome, String marca, double preco, double V, double A, double W) {
		super(ID, nome, marca, preco);
		this.tensaoMaxima = V;
		this.correnteMaxima = A;
		this.potenciaMaxima = W;
	}
	public double getTensaoMaxima() {
		return tensaoMaxima;
	}
	public void setTensaoMaxima(double tensaoMaxima) {
		this.tensaoMaxima = tensaoMaxima;
	}
	public double getCorrenteMaxima() {
		return correnteMaxima;
	}
	public void setCorrenteMaxima(double correnteMaxima) {
		this.correnteMaxima = correnteMaxima;
	}
	public double getPotenciaMaxima() {
		return potenciaMaxima;
	}
	public void setPotenciaMaxima(double potenciaMaxima) {
		this.potenciaMaxima = potenciaMaxima;
	}
	@Override
	public String toString() {
		return  "\nEletrônico: \n{\n" + super.toString() +
				"\nTensão Máxima: "+ this.tensaoMaxima +
				"\nCorrente Máxima: "+ this.correnteMaxima +
				"\nPotência Máxima: "+ this.potenciaMaxima + "\n}";
	}
	
	public String armazena() {
		return "ID\t" + this.ID +
				"\r\nNome\t" + this.nome +
				"\r\nMarca\t" + this.marca +
				"\r\nPreço(R$)\t" + this.preco +
				"\r\nTensão(V)\t" + this.tensaoMaxima +
				"\r\nCorrente(A)\t" + this.correnteMaxima +
				"\r\nPotência(W)\t" + this.potenciaMaxima;
	}
}