
public class Jogador {
	private String nome;
	private int pts;
	public Jogador (String n) {
		this.nome = n;
		this.pts = 0;
	}
	public String getNome() {
		return this.nome;
	}
	public int getPts() {
		return this.pts; 
	}
	public void setNome(String n) { 
		this.nome = n;
	}
	public void setPts () {
		this.pts++;
	}
	public String toString() {
		return "Jogador:" + this.nome + "\nPontos:" + this.pts + "\n";
	}
}
