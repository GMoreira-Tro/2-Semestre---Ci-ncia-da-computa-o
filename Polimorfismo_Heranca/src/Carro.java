
public class Carro extends Veiculo{
	private int anoFab;
	
	public Carro(double vM, double p, int aF) {
		super(vM,p);
		this.anoFab = aF;
	}
	public void setAnoFab(int aF) { this.anoFab = aF;}
	public int getAnoFab() { return this.anoFab;}
	
	public String toString() {
		return "Carro\nAno de fabricação: " + this.anoFab +"\n" + super.toString();
	}

}
