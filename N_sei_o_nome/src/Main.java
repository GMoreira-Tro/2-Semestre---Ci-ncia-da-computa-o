
public class Main {
	public static void main (String[] args) {
		Carro carro = new Carro (Teclado.leDouble("M�ximo de combust�vel(litros):"),
				Teclado.leDouble("\nN�vel de combust�vel(litros):"),
				Teclado.leDouble("\nQuantidade de kil�metros por litro:"));
		//carro.encherTanque(1.4);
		System.out.println(carro.getLvlcomb() + "\n");
		carro.andar(20);
		System.out.println("\n"+ carro.getLvlcomb() + " litros"  + "\n");
		carro.andar(20);
		System.out.println("\n"+ carro.getLvlcomb() + " litros"  + "\n"); 
	}

}
