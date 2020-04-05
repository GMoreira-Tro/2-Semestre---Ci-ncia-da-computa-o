
public class UnderflowException extends Exception {
	String s;
	public UnderflowException(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return s;
	}
}
