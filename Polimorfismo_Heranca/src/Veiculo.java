
public class Veiculo {
	private double vMax;
	private double preco;
	public Veiculo (double vM, double p) {
		this.vMax = vM;
		this.preco = p;
	}
	public void setVMax(double vM) { this.vMax = vM;}
	public void setPreco(double p) { this.preco = p;}
	public double getVMax() { return this.vMax;}
	public double getPreco() { return this.preco;}
	
	public String toString() {
		return "Velocidade m�xima: " + this.vMax + "\nPre�o: " + this.preco + "R$";
	}

}
