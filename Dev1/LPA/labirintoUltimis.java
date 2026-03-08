package Dev1.LPA;
import java.util.Random;
public class labirintoUltimis {
	
	static Random r = new Random();
	static String[][] labirinto = new String[10][12];
	static String[] caracteres = {"#", "."};
	static String[] posicao = new String[100];
	static int[] posicaoLinha = new int[100];
	static int[] posicaoColuna = new int[100];
	static int count = 0;
	
	public static void main(String[] args) {
		verificadorViabilidade();
    }
	public static void verificadorViabilidade(){
		geradorLabirinto();
        int contador = 0;
        for(int i = 0; i < labirinto.length; i++){
            for(int j = 0; j < labirinto[i].length; j++){
                if (labirinto[i][j] == ".") {
					posicao[contador] = labirinto[i][j];
					posicaoLinha[contador] = i;
					posicaoColuna[contador] = j;
                    contador++;
					System.out.println("Fora do array: " + i + " : " + j);
					System.out.println("Dentro do array: " + posicaoLinha[contador] + " : " + posicaoColuna[contador]); 
					// System.out.println(contador + "º: " + posicao[i] + " -> " + i + " : " + j);
                }
            } 
        }
		contador = 0;
		for(int i = 0; i < labirinto.length; i++){
			for(int j = 0; j < labirinto[i].length; j++){
				// if (condition) {
		
				// }
			}
		}
	}
    public static void geradorLabirinto(){
        labirinto[0][1] = "P";

        labirinto[9][10] = "S";
		
		for(int i = 0; i < 10; i++){
            labirinto[i][0] = "|";
            labirinto[i][11] = "|\n";
        }
		
		for(int i = 0; i < labirinto.length; i++) {
			for(int j = 0; j < labirinto[i].length; j++) {		
				if(labirinto[i][j] == null) {
					labirinto[i][j] = caracteres[r.nextInt(caracteres.length)];
					if(labirinto[i][j] == "#") {
						count++;
						if(count == 8) {
							for(int k = j; k < labirinto.length; k++) {
								labirinto[i][k] = ".";													
							}
							count = 0;
						}
					}
					if(labirinto[0][2] == "#" || labirinto[1][1] == "#" || labirinto[1][2] == "#" || labirinto[8][9] == "#" || labirinto[8][10] == "#" || labirinto[9][9] == "#") {
						labirinto[0][2] = ".";
						labirinto[1][1] = ".";
						labirinto[1][2] = ".";
                        labirinto[8][9] = ".";
                        labirinto[8][10] = ".";
                        labirinto[9][9] = ".";

					}
				}
			}
		}
		visualizador();
    }        
	public static void visualizador() {
		for(int i = 0; i < labirinto.length; i++) {
			for(int j = 0; j < labirinto[i].length; j++) {
				System.out.print(" "+ labirinto[i][j]);
			}
		}
	}
}
