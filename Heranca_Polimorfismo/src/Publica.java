
public class Publica extends Universidade {
	private int qConcursados;
	public Publica (String n, String e, int A, int P,int C) {
		super(n,e,A,P);
		this.qConcursados = C;
	}
	public int getQConcursados() { return this.qConcursados;}
	public void setQConcursados(int C) { this.qConcursados = C;}
	public void setConcursados () { this.qConcursados++;}
	
	public String toString() {
		return super.toString() + "\nQuantidade de professores concursados: " + this.qConcursados;
	}

} 
