import java.io.*;
import java.util.*;

public class Main {
	public static String allfile;
	public static String[] database;
	public static String[][] data;
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws InvalidTokenException{
		File f = new File ("tokens");
		File f2 = new File("Log");
		Date date = new Date();
		Calendar cal = new GregorianCalendar();
		String x = "";
		boolean existe = true;
		
		int num_rand = 0;
		if (!f.exists()) {
			geraOsCem(f);
			existe = false;
		}
		int in_tk;
		
			try {
			FileReader fr = new FileReader (f);
			BufferedReader in = new BufferedReader(fr);
			
			String line = in.readLine();
			allfile = line + "\n";
			while (true) {
				if ( (line = in.readLine()) != null)
					allfile += line + "\n";
				
				else {
					break;
				}
			}
			database = allfile.split("\n");
			/*for (int i = 0; i < database.length; i++)
				System.out.println(database[i]);*/
			
			String y_or_n;
			boolean sub = false;
			while (!x.equals("3")) {
				System.out.println("1 - Gerar tokens" +
						"\n2 - Ver logs" +
						"\n3 - Sair");
				x = scan.nextLine();
			switch(x) {
			
			case "1":
				FileWriter log = new FileWriter(f2,existe);
				while (true) {
					System.out.println("Índice do token para gerar cartão: (0 a 99 ou maior para sair)" );
					while (true) {
						try {
							
							in_tk = Integer.parseInt(scan.nextLine());
							if ( in_tk < 0)
								throw new InvalidTokenException("Índice de 0 a 99 (ou maior para sair):");
							else if (in_tk < 100) {
								num_rand = (int)(Math.random() * 10000);
								if (database[in_tk].length() > 6) {
									database[in_tk] = database[in_tk].substring(0, database[in_tk].length()-4);
									sub = true;
								}
								if (num_rand > 999)
									database[in_tk] += String.valueOf(num_rand);
								else if (num_rand > 99)
									database[in_tk] += "0" + String.valueOf(num_rand);
								else if (num_rand > 9) 
									database[in_tk] += "00" + String.valueOf(num_rand);
								else
									database[in_tk] += "000" + String.valueOf(num_rand);
								cal.setTime(date);
								if (sub)
									log.write(database[in_tk] + " " + date + " (sobrescrito)\n");
								else 
									log.write(database[in_tk] + " " + date + "\n");
								sub = false;
								break;							
							}
							else
								break;
						}
						catch(NumberFormatException n) {
							System.out.println("Digite um número:");
						}
						catch(InvalidTokenException i) {
							System.out.println(i);
						}
					}
					
					if (in_tk >= 100) {
						reescreveFile(f);
						log.close();
						break;
					}
				}
				break;
			case "2":
				try {
					FileReader fr2 = new FileReader(f2);
					BufferedReader out = new BufferedReader(fr2);
					String outsystem = "";
					String linha;
					while ((linha = out.readLine()) != null) {
						outsystem += linha + "\n";
					}
					System.out.println(outsystem);
				} catch(Exception e) {System.out.println(e);}
				break;
			default:
				break;
			
			
		}}} catch(FileNotFoundException e) {System.out.println(e);}
		catch(IOException e) {System.out.println(e);}	
		
	}
	
	public static void geraOsCem(File f) {
		String cardnumber = "";
		try {
			FileWriter fw = new FileWriter(f,false);
			for(int i = 0; i < 100; i++) {
				for (int j = 0; j < 6; j++) {
					cardnumber += String.valueOf((int)(Math.random()*10));
				}
				fw.write(cardnumber + "\r\n");
				cardnumber = "";
			}
			fw.close();
		} catch(FileNotFoundException e) {System.out.println(e);}
		catch (IOException e) {System.out.println(e);}		
	}
	
	public static void reescreveFile (File f) {
		try {
			FileWriter fw = new FileWriter(f,false);
			for (int i = 0; i < database.length; i ++)
				fw.write(database[i] + "\n");
			fw.close();
		}
		catch(FileNotFoundException e) {System.out.println(e);}
		catch(IOException e) {System.out.println(e);}
	}

}
