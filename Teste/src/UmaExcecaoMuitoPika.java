
public class UmaExcecaoMuitoPika extends Exception{
	String xex;
	public UmaExcecaoMuitoPika(String xex) {
		this.xex = xex;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return xex;
	}

}
