
public class TanqueCheioException extends Exception {
	public TanqueCheioException() {
		super();
	}

	@Override
	public String toString() {
		return "Limite da capacidade do tanque excedido";
	}

}
