
public class Deputado {
	private String nome;
	private short idade;
	private String sexo;
	private String partido;
	private int numero;
	private int votos;
	private String projeto;
	public Deputado(String nome, short idade, String sexo, String partido, int numero, String projeto) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.partido = partido;
		this.numero = numero;
		this.projeto = projeto;
		this.votos = 0;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public short getIdade() {
		return idade;
	}
	public void setIdade(short idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getVotos() {
		return votos;
	}
	public void setVotos(int votos) {
		this.votos = votos;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}
	public void imprimeInfo() {
		System.out.println("Deputado:" + this.nome
				+"\nIdade:" + this.idade +
				"\nSexo:" + this.sexo + "\nPartido:" + this.partido
				+"\nNúmero:"+ this.numero +"\nProjeto:"+ this.projeto
				+"\nQuantidade de votos:" + this.votos);
	}
}
