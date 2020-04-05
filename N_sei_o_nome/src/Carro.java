
public class Carro {
	private double maxcomb;
	private double lvlcomb = 0;
	private double quantkmlitro;
	
	public Carro(double maxcomb, double lvlcomb, double quantkmlitro) {
		
		this.maxcomb = maxcomb;
		this.quantkmlitro = quantkmlitro;
		
		try {
			this.lvlcomb = lvlcomb;
			if (this.lvlcomb > this.maxcomb) {
				throw new TanqueCheioException();
			}
		}
		catch (TanqueCheioException a) {
			System.out.println("Quantidade de combustível não cabe no tanque.");
		}
		if (this.maxcomb < 0) this.maxcomb = 0;
		if (this.lvlcomb < 0) this.lvlcomb = 0;
		if (this.quantkmlitro < 0) this.quantkmlitro = 0;
	}
	
	public double getMaxcomb() { return this.maxcomb;}
	public double getLvlcomb() { return this.lvlcomb;}
	public double getQuantkmlitro() { return this.quantkmlitro;}
	
	public void setMaxcomb(double mc) { this.maxcomb = mc;}
	public void setLvlcomb(double lc) { this.lvlcomb = lc;}
	public void setQuantkmlitro(double qkl) { this.quantkmlitro = qkl;}
	
	public void encherTanque (double quantComb) {
		try {
			this.lvlcomb += quantComb;
			if (this.lvlcomb > this.maxcomb) {
					throw new TanqueCheioException();
				}
			}
		catch (TanqueCheioException a) {
			System.out.println("Quantidade de combustível não cabe no tanque.");
		}
		
	}
	
	public double distanciaPossivel() {
		return this.quantkmlitro * this.lvlcomb;
	}
	
	public double combustivelGasto(double distancia) {		
		return (distancia / this.quantkmlitro);	
	}
	
	public void andar (double distancia) {
		double x = 0; boolean f = false;
		try {
			x = combustivelGasto(distancia);
		
			if (this.lvlcomb > this.maxcomb) {
				throw new TanqueCheioException();
			}
			
			else if (this.lvlcomb == 0) {
				throw new TanqueVazioException(x); 
			}
			
			else if (combustivelGasto(distancia) > this.lvlcomb) {
				throw new TanqueInsuficienteException();
			}
			
			else f = true;
		
		}
		catch (ArithmeticException c) {
			System.out.print("Quantidade de kilômetros por litro deve ser maior que 0");
		}
		catch (TanqueVazioException a) {
			System.out.println("Tanque vazio.");
		}
		catch (TanqueInsuficienteException b) {
			System.out.println("Combustível insuficiente para andar a distância.");
		}
		catch (TanqueCheioException d) {
			System.out.println("Quantidade de combustível não cabe no tanque.");
		}
		
		if (f) {
			System.out.print("O carro gastou " + x + " litros de gasolina");
			this.lvlcomb -= x;
		}
		
	}
}
