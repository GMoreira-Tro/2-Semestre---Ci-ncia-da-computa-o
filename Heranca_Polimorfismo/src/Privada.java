
public class Privada extends Universidade{
	private double mensalidade;
	public Privada (String n, String e, int A, int P, int M) {
		super(n, e, A, P);
		this.mensalidade = M;
	}
	public double getMensalidade() { return this.mensalidade;}
	public void setMensalidade(double M) { this.mensalidade = M;}
	public void addMensalidade(double M) { this.mensalidade += M;}
	
	public String toString() {
		return super.toString() + "\nValor da mensalidade: " + this.mensalidade;
	}
	

}
