
public class DeputadosException extends Exception{
	
	public DeputadosException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.getMessage() + ":(";
	}
	
}
