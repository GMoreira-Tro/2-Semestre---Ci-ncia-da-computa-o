import java.util.Comparator;

public class SortByRoll implements Comparator<Produto>{
	public int compare (Produto a, Produto b) {
		return (int) (a.getPreco() - b.getPreco());
	}
}
