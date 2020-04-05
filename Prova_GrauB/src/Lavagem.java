import java.io.*;

public class Lavagem {
	private DoublyLinkedList<Veiculo> v;

	public Lavagem(DoublyLinkedList<Veiculo> v) {
		this.v = v;
	}

	public DoublyLinkedList<Veiculo> getV() {
		return v;
	}

	public void setV(DoublyLinkedList<Veiculo> v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return v.toString();
	}
	
	public void  insereVeiculo(Veiculo vei) {
		v.insertLast(vei);
	}
	
	public StaticQueue<Veiculo> filaLavagem() throws OverflowException {
		StaticQueue<Veiculo> q = new StaticQueue<Veiculo>(v.numElements);
		int pos = 0;
		for (int i = 0; i < v.numElements; i++) {
				if (v.get(i).getTipo().equals("Veículo de aplicativo"))
					q.enqueue(v.get(i));
		}
		for (int i = 0; i < v.numElements; i++) {
			if (!(v.get(i).getTipo().equals("Caminhão")) && 
					!(v.get(i).getTipo().equals("Veículo de aplicativo")))
				q.enqueue(v.get(i));
		}
		return q;
	}
	
	public void salvaFila(File fil) throws Exception {
		StaticQueue<Veiculo> q = filaLavagem();
		//System.out.println(q.get(0).getNome());
		try {
			FileWriter fw = new FileWriter(fil,false);
			for (int i = 0; i < q.numElements(); i++) {
				fw.write(q.get(i).getNome() +"\t" + q.get(i).getMarca() 
						+ "\t" + q.get(i).getTipo() + "\r\n");
			}
			fw.close();
		}
		catch (FileNotFoundException f) {
			System.out.println(f);
		}
		catch (IOException i) {
			System.out.println(i);
		}
	}
}
