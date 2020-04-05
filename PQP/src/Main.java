
public class Main {
	public static void main(String[] args) {
        char[][] lab = new char[(int)(Math.random()*9+2)][(int)(Math.random()*9+2)];

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {

                if (i == lab.length-1 && j == lab[0].length-1) {
                    lab[i][j] = 'D';
                } 
                else {
                    if (Math.random() < 0.6) {
                        lab[i][j] = 'X';
                    } 
                    else {
                        lab[i][j] = ' ';
                    }
                }
                System.out.print(lab[i][j] + " ");
            } 
            System.out.print("\n");
        }

        System.out.println(testaLabirinto(lab));
        System.out.println("");

        for (int i = 0; i < lab.length; i++) {
            for (int j = 0; j < lab[0].length; j++) {

                System.out.print(lab[i][j] + " ");
            }
            System.out.println("");
        }

    }
	
	public static boolean testaLabirinto(char[][] lab) {
        try {
            for(int y = 0; y < lab.length; y++) {
                if(lab[0][y] == ' ') {
                    lab[0][y] = '!';
                    return seraQPassa(lab, 0, y);
                }
            }
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Não deu no testaLabirinto!");
        }
        return false;
    }
private static boolean seraQPassa(char[][] lab, int x, int y) {
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {

                //if(x != 1 && y != 1) {
                    try {
                        if (lab[x+i][y+j] == ' ' 
                        &&  lab[x+i][y+j] != '!') {
                            lab[x+i][y+j] = '!';
                            return seraQPassa(lab, x+i, y+j);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                           System.out.println("Não deu no seraQPassa +!");
                    }

                    try {
                        if (lab[x-i][y-j] == ' ' 
                        &&  lab[x-i][y-j] != '!') {
                            lab[x-i][y-j] = '!';
                            return seraQPassa(lab, x-i, y-j);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                           System.out.println("Não deu no seraQPassa -!");
                    }

                    try {
                        if (lab[x+i][y+j] == 'D') {
                            System.out.println("achei o D");
                            return true;
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e) {
                           System.out.println("Não deu no seraQPassa D!");
                    }
                //}
            }
        }
        return false;
    }


}
