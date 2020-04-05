
public class Onibus extends Veiculo {
	private int cPassageiros;
	
	public Onibus (double vM, double p, int cP) {
		super(vM,p);
		this.cPassageiros = cP;
	}
	public void setCPassageiros (int cP) { this.cPassageiros = cP;}
	public int getCPassageiros() { return this.cPassageiros;}
	
	public String toString() {
		return "Ônibus\nCapacidade de passageiros: " + this.cPassageiros + "\n" + super.toString();
	}

}
