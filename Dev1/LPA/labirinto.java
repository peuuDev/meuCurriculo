package Dev1.LPA;
import java.util.*;
public class labirinto {
	
	static Random r = new Random();
	static String[][] labirinto = new String[10][12];
	static String[] caracteres = {"#", "."};
	static String[][] posicao = {};
	static int count = 0;
	
	public static void main(String[] args) {
		verificadorViabilidade();
    }
	public static void verificadorViabilidade(){
		geradorLabirinto();

		int pr = -1, pc = -1, sr = -1, sc = -1;
		for (int i = 0; i < labirinto.length; i++) {
			for (int j = 0; j < labirinto[i].length; j++) {
				if ("P".equals(labirinto[i][j])) { pr = i; pc = j; }
				if ("S".equals(labirinto[i][j])) { sr = i; sc = j; }
			}
		}

		if (pr == -1 || sr == -1) {
			System.out.println("Posição inicial ou final não encontrada.");
			return;
		}

		boolean[][] visited = new boolean[labirinto.length][labirinto[0].length];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { pr, pc });
		visited[pr][pc] = true;

		int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int[] d : dirs) {
				int nr = cur[0] + d[0];
				int nc = cur[1] + d[1];
				if (nr < 0 || nr >= labirinto.length || nc < 0 || nc >= labirinto[0].length) continue;
				if (visited[nr][nc]) continue;
				String cell = labirinto[nr][nc];
				if (cell == null) continue;
				if (".".equals(cell) || "S".equals(cell)) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}

		boolean alcançou = visited[sr][sc];

		int totalAndavel = 0;
		int inacessiveis = 0;
		for (int i = 0; i < labirinto.length; i++) {
			for (int j = 0; j < labirinto[i].length; j++) {
				String c = labirinto[i][j];
				if (c == null) continue;
				if (".".equals(c) || "P".equals(c) || "S".equals(c)) {
					totalAndavel++;
					if (!visited[i][j]) inacessiveis++;
				}
			}
		}

		System.out.println("Resultado da verificação:");
		System.out.println(" - Posição inicial: (" + pr + "," + pc + ")");
		System.out.println(" - Posição final:   (" + sr + "," + sc + ")");
		System.out.println(" - S alcançável a partir de P: " + alcançou);
		System.out.println(" - Total de células caminháveis: " + totalAndavel);
		System.out.println(" - Células caminháveis inacessíveis a partir de P: " + inacessiveis);
		if (alcançou && inacessiveis == 0) {
			System.out.println("Labirinto jogável: SIM - P pode alcançar S e não há áreas isoladas.");
		} else if (alcançou) {
			System.out.println("Labirinto parcialmente jogável: S alcançável, mas existem áreas isoladas.");
		} else {
			System.out.println("Labirinto não jogável: S não é alcançável a partir de P.");
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
