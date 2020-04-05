
public class PrecoException extends Exception{
	String msg;
	public PrecoException (String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return msg;
	}
}
