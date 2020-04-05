
public class Estadual extends Deputado{
	private String estado;

	public Estadual(String nome, short idade, String sexo, String partido, int numero, String projeto,String estado) {
		super(nome, idade, sexo, partido, numero, projeto);
		this.estado = estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		super.imprimeInfo();
		return "Deputado Estadual"  + "\nEstado: " + this.estado;
	}
}
