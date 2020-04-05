
public class Federal extends Deputado {
	@Override
	public String toString() {
		super.imprimeInfo();
		return "Deputado Federal" + "\nAnos de política: "
				+ this.anos_politica;
	}

	private short anos_politica;

	public Federal(String nome, short idade, String sexo, String partido, int numero, String projeto, short anos) {
		super(nome, idade, sexo, partido, numero, projeto);
		this.anos_politica = anos;
	}

	public short getAnos_politica() {
		return anos_politica;
	}

	public void setAnos_politica(short anos_politica) {
		this.anos_politica = anos_politica;
	}
}
