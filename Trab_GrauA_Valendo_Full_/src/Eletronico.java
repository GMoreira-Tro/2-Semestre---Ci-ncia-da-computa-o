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
		return  "\nEletr�nico: \n{\n" + super.toString() +
				"\nTens�o M�xima: "+ this.tensaoMaxima +
				"\nCorrente M�xima: "+ this.correnteMaxima +
				"\nPot�ncia M�xima: "+ this.potenciaMaxima + "\n}";
	}
	
	public String armazena() {
		return "ID\t" + this.ID +
				"\r\nNome\t" + this.nome +
				"\r\nMarca\t" + this.marca +
				"\r\nPre�o(R$)\t" + this.preco +
				"\r\nTens�o(V)\t" + this.tensaoMaxima +
				"\r\nCorrente(A)\t" + this.correnteMaxima +
				"\r\nPot�ncia(W)\t" + this.potenciaMaxima;
	}
}