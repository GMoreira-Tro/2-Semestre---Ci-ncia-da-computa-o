
public class TestaVeiculo {
	public static void main (String[] args) {
		Veiculo v = new Carro(-2505214, 1, -5000);
		System.out.println(v);
		((Carro)v).setAnoFab(2000);
		System.out.println("\nAno de fabricação: " + ((Carro)v).getAnoFab());
		
		Veiculo v2 = new Onibus (-928, 10000000, 20);
		System.out.println(v2);
		((Onibus)v2).setCPassageiros(40);
		System.out.println("\nQuantidade de passageiros: " + ((Onibus)v2).getCPassageiros());  
	}
}
