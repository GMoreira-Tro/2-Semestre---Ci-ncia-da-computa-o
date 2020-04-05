import java.io.*;
import java.util.*;
public class Campeonato {
	private TimeCampeonato[] times;
	
	public Campeonato() {
		
	}

	public TimeCampeonato[] getTimes() {
		return times;
	}

	public void setTimes(TimeCampeonato[] times) {
		this.times = times;
	}
	
	public void leArquivo(String file) {
		try {
			FileReader fr = new FileReader (file);
			BufferedReader in = new BufferedReader(fr);
			String line = in.readLine();
			String lil = line;
			while ((line = in.readLine()) != null) {
				lil += "\n" + line;
			}
			String[] lines = lil.split("\n");
			in.close();
			String[][] parts = new String[lines.length][5];
			for (int i = 0; i < lines.length; i++) {
				parts[i] = lines[i].split(" ");
			}
			/*for (int i = 0; i < parts.length; i++) {
				System.out.println(parts[i][0]);
				System.out.println(parts[i][1]);
				System.out.println(parts[i][2]);
				System.out.println(parts[i][3]);
				System.out.println(parts[i][4]);
			}*/
			int c = parts.length;
			int t = 0, gols = 0, gols2 = 0;
			times = new TimeCampeonato[100];
			int count;
			boolean flag = false,flag2 = false;
			times[0] = new TimeCampeonato(parts[0][0],0);
			for (count = 0; count < c; count++) {
				//if(parts[count] == null) break;
				for (int j = count-1; j >= 0; j--) {
					//if(parts[j] == null) break;
					 	
						if(parts[count][0].equals(parts[j][0]) || parts[count][0].equals(parts[j][4])) {
							//times[t] = new TimeCampeonato(parts[count][0],0);
							flag = true;
							/*if (times[t] != null){
								times[t].setSaldo(Integer.parseInt(parts[count][1])-Integer.parseInt((parts[count][3]) + times[t].getSaldo()));
								}*/
							//t++;
						}
						if(parts[count][4].equals(parts[j][4]) || parts[count][4].equals(parts[j][0])) {
							//times[t] = new TimeCampeonato(parts[count][4],0);
							flag2 = true;
							/*if (times[t] != null){
								times[t].setSaldo(Integer.parseInt(parts[count][3])-Integer.parseInt((parts[count][1]) + times[t].getSaldo()));
								}*/
							//t++;
						}
						//if(flag && flag2) break;
					
					 /*if (times[t] != null){
						times[t].setSaldo(Integer.parseInt(parts[count][1])-Integer.parseInt((parts[count][3]) + times[t].getSaldo()));
					}*/
				} 
				if (!flag) {
					times[t] = new TimeCampeonato(parts[count][0],Integer.parseInt(parts[count][1]) - Integer.parseInt(parts[count][3]));
					t++;
				}
				if (!flag2) {
					times[t] = new TimeCampeonato(parts[count][4],Integer.parseInt(parts[count][3]) - Integer.parseInt(parts[count][1]));
					t++;
				}
				flag = flag2 = false;
			}
			
			for (int i = 0; times[i] != null; i++) {
				for (int j = i+1; times[j] != null; j++) {
					if(times[i].getNome().equals(parts[j][0])) {
						times[i].setSaldo(times[i].getSaldo()+Integer.parseInt(parts[j][1])-Integer.parseInt(parts[j][3]));
					}
					if(times[i].getNome().equals(parts[j][4])) {
						times[i].setSaldo(times[i].getSaldo()+Integer.parseInt(parts[j][3])-Integer.parseInt(parts[j][1]));
					}
				} 
			}
			TimeCampeonato aux;
			for (int i = 0; times[i] != null; i++) {
				for (int j = 0; times[j+i+1] != null; j++) {
					if (times[j].getSaldo() > times[j+1].getSaldo()) {
						aux = times[j];
						times[j] = times[j+1];
						times[j+1] = aux;
					}
				}
			}
			
			
			for (int i = 0; times[i] != null; i++) {
				System.out.println(times[i]);
			}
		}
		catch(FileNotFoundException s) {
			System.out.println("Arquivo não encontrado");
		}
		catch(IOException e) {
			System.out.println("Erro na leitura do arquivo");
		}
	}
}
