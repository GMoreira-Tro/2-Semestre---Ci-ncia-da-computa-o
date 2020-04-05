import java.util.ArrayList;
import java.util.List;

public class Estabelecimento {
	private String nome;
	private String codigo_estruturado;
	private int codigo_reduzido;
	private int nivel;
	private Estabelecimento pai;
	
	public Estabelecimento getPai() {
		return pai;
	}

	public void setPai(Estabelecimento pai) {
		this.pai = pai;
	}
	
	public Estabelecimento search(int nivel, List<Galho<Estabelecimento>> arvore, int ID) {
		List<Galho<Estabelecimento>> a2 = new ArrayList<Galho<Estabelecimento>>();
		a2.addAll(arvore);
		a2.removeIf(each -> each.getData().getNivel() != nivel);
		for (int i = 0; i < a2.size(); i++) {
			if (a2.get(i).getId() == ID)
				return (Estabelecimento) a2.get(i).getData();
		}
		throw new NullPointerException();
	}

	public Estabelecimento(String nome, int codigo_reduzido, int nivel) {
		this.nome = nome;
		this.codigo_reduzido = codigo_reduzido;
		this.nivel = nivel;
		this.codigo_estruturado = "";
	}
	
	public Estabelecimento(String nome, int codigo_reduzido, String codigo_estruturado,
			int nivel) {
		this.nome = nome;
		this.codigo_reduzido = codigo_reduzido;
		this.nivel = nivel;
		this.codigo_estruturado = codigo_estruturado;
	}
	
	public Estabelecimento(String nome, int codigo_reduzido, String codigo_estruturado, 
			int nivel, Estabelecimento pai) {
		this.nome = nome;
		this.codigo_reduzido = codigo_reduzido;
		this.nivel = nivel;
		this.codigo_estruturado = codigo_estruturado;
		this.pai = pai;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo_estruturado() {
		return codigo_estruturado;
	}

	public void setCodigo_estruturado(String codigo_estruturado) {
		this.codigo_estruturado = codigo_estruturado;
	}

	public int getCodigo_reduzido() {
		return codigo_reduzido;
	}

	public void setCodigo_reduzido(int codigo_reduzido) {
		this.codigo_reduzido = codigo_reduzido;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public String toString() {
		String pai = "";
		if (this.pai == null)
			pai = "Patriarcal";
		else
			pai = "Estabelecimento pai: " + this.pai.getNome();
		return "Estabelecimento: " + this.nome +
				"\nNível: " + this.nivel + "\n" +
				pai + 
				"\nCódigo estruturado: " + this.codigo_estruturado +
				"\nCódigo reduzido: " + this.codigo_reduzido;
	}
}
