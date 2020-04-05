import java.io.*;
import java.util.*;
public class Candidatos {
	private Deputado[] deputados;
	
	public Candidatos (String nomeArquivo) {
		try {
			FileReader f = new FileReader(nomeArquivo);
			BufferedReader in = new BufferedReader(f);
			
			String line = in.readLine();
			ArrayList<String[]> splitted = new ArrayList<String[]>();
			splitted.add(line.split(": "));
			
			while ((line = in.readLine()) != null) {
				splitted.add(line.split(": "));
			}
			
			deputados = new Deputado[splitted.size()];
			int t = 0;
			for (int i = 0; i < splitted.size(); i+=9) {
				if (splitted.get(i)[1].equals("Estadual")) {
					deputados[t] = new Estadual(splitted.get(i+2)[1],
							Short.parseShort(splitted.get(i+3)[1]),
							splitted.get(i+4)[1],
							splitted.get(i+5)[1],
							Integer.parseInt(splitted.get(i+6)[1]),
							splitted.get(i+7)[1],
							splitted.get(i+1)[1]);
							//System.out.println(deputados[t] + "\n");
							t++;
				}
				else {
					deputados[t] = new Federal(splitted.get(i+2)[1],
							Short.parseShort(splitted.get(i+3)[1]),
							splitted.get(i+4)[1],
							splitted.get(i+5)[1],
							Integer.parseInt(splitted.get(i+6)[1]),
							splitted.get(i+7)[1],
							Short.parseShort(splitted.get(i+1)[1]));
							//System.out.println(deputados[t] + "\n");
							t++;
				}
			}
			
			
		} catch (FileNotFoundException f) {
			System.out.println(f);
		}
		catch (IOException i) {
			System.out.println(i);
		}
	}

	public Deputado[] getDeputados() {
		return deputados;
	}

	public void setDeputados(Deputado[] deputados) {
		this.deputados = deputados;
	}
}
