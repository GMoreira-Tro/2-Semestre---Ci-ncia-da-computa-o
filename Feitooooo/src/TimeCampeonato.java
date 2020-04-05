
public class TimeCampeonato {
	private String nome;
	private int saldo;
	
	public TimeCampeonato(String n, int s) {
		this.nome = n;
		this.saldo = s;
	}

	@Override
	public String toString() {
		return "TimeCampeonato [nome=" + nome + ", saldo=" + saldo + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
}
