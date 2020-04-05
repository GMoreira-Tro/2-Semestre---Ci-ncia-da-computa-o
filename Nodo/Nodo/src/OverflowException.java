
public class OverflowException extends Exception{
	String s;
	public OverflowException(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return s;
	}
}
