package Dev1.LPA;
import java.util.Scanner;

public class losango {
    
    public static void main(String[] args) {
        
        String ast = "*";
        String vazio = " ";
        int astCounter = 0;
        int valor;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        valor = sc.nextInt();
        int vazioCounter = valor;
        
        for(int i = 1; i <= valor; i++){
            while (astCounter < i) {
                while (vazioCounter > i) {
                    System.out.print(vazio);
                    vazioCounter--;
                }
                System.out.print(vazio + ast);
                astCounter++;
            }
            System.out.println("");
            astCounter =  0;
            vazioCounter = valor;
        }

        int vazioCounter2 = valor;
        int astCounter2 = 0;

        for(int j = valor - 1; j >= 1; j--){//  -1
            while (astCounter2 <  j) {
                while(vazioCounter2 > j) {
                    System.out.print(vazio);
                    vazioCounter2--;
                }
                System.out.print(vazio + ast);
                astCounter2++;
            }
            System.out.println("");
            astCounter2 = 0;
            vazioCounter2 = valor;
        }
        
        sc.close(); 
    }
}
