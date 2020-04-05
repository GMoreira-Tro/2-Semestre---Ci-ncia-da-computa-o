import java.util.ArrayList;
import java.util.List;

public class Galho<T> {
	private T data;
	private Galho<T> pai;
	private List<Galho<T>> filhos = new ArrayList<Galho<T>>();
	private int Id;
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public Galho<T> search(int nivel, List<Galho<Estabelecimento>> arvore, int ID) {
		List<Galho<Estabelecimento>> a2 = new ArrayList<Galho<Estabelecimento>>();
		a2.addAll(arvore);
		a2.removeIf(each -> each.getData().getNivel() != nivel);
		for (int i = 0; i < a2.size(); i++) {
			if (a2.get(i).getId() == ID)
				return (Galho<T>) a2.get(i);
		}
		throw new NullPointerException();
	}

	@Override
	public String toString() {
		return this.data.toString() + "\n";
	}

	public Galho(T data, Galho<T> pai, List<Galho<T>> filhos) {
		this.data = data;
		this.pai = pai;
		this.filhos = filhos;
	}
	
	public Galho(T data) {
		this.data = data;
	}
	
	public Galho(T data, Galho<T> pai) {
		this.data = data;
		this.pai = pai;
	}
	
	public Galho(T data,List<Galho<T>> filhos) {
		this.data = data;
		this.filhos = filhos;
	}

	public Galho<T> getPai() {
		return pai;
	}

	public void setPai(Galho<T> pai) {
		this.pai = pai;
	}

	public List<Galho<T>> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<Galho<T>> filhos) {
		this.filhos = filhos;
	}
	
	public T getData() {
		return data;
	}
		 
	public void setData(T data) {
		this.data = data;
	}
	
	public Galho<T> addFilho(Galho<T> g) {
		g.setPai(this);
		this.filhos.add(g);
		return g;
	}
	
	public List<Galho<T>> addFilho(List<Galho<T>> g) {
		g.forEach(each -> each.setPai(this));
		this.filhos.addAll(g);
		return g;
	}
	
	public void printTree(Galho<T> g) {
		 System.out.println(g + "\n");
		 g.getFilhos().forEach(each ->  printTree(each));
	}
	
	public void deleteGalho(Galho<T> g) {
		if (!g.getFilhos().isEmpty())
			System.out.println("Não se pode deletar um " + g.getClass() + " com filhos");
		else {
			int i = g.getPai().getFilhos().indexOf(g);
			g.getPai().getFilhos().remove(i);
		}
	}
	 
}
