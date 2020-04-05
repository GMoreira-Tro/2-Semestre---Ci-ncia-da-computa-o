
public class Universidade {
	private String nome, endereco;
	private int qAlunos, qProfessores;
	
	public Universidade (String n, String e, int A, int P) { 
		this.nome = n;
		this.endereco = e;
		this.qAlunos = A;
		this.qProfessores = P;
	}
	
	public String getNome() { return this.nome;}
	public String getEndereco() { return this.endereco;}
	public int getQAlunos() { return this.qAlunos;}
	public int getQProfessores( ) { return this.qProfessores;}
	
	public void setNome(String n) { this.nome = n;}
	public void setEndereco(String e) { this.endereco = e;}
	public void setQAlunos(int A) { this.qAlunos = A;}
	public void setQProfessores(int P) { this.qProfessores = P;}
	
	public String toString() { 
		return "Universidade: " + this.nome +"\nEndereço: " + this.endereco 
				+ "\nQuantidade de alunos: " + this.qAlunos + "\nQuantidade de professores: "
				+ this.qProfessores;
	}
}
