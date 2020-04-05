
public class InvalidTokenException extends Exception {
	String s;
	public InvalidTokenException(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return this.s;
	}
	
}
