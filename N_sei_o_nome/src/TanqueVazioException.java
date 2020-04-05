
public class TanqueVazioException extends Exception {
	private double combustivel;

	public TanqueVazioException(double combustivel) {
		super();
		this.combustivel = combustivel;
	}

	@Override
	public String toString() {
		return "Tanque vazio";
	}
	
	
}
