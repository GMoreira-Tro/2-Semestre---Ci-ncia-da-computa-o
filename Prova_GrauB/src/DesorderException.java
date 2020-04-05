
public class DesorderException extends Exception {
	String s;
	public DesorderException(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return s;
	}
}
