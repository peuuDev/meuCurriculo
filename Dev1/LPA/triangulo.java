package Dev1.LPA;
import java.util.Scanner;

public class triangulo {
    public static void main(String[] args) {
        trinanguloMetade();
    }

    public static void trinanguloMetade(){
        Scanner sc = new Scanner(System.in);
        int count = 0; int valor = 0;
        System.out.println("Valor: ");
        valor = sc.nextInt();
        for(int i = 1; i <= valor; i++){
            while (count < i) {
                System.out.print("* ");
                count++;
            }
            count = 0;
            System.out.println(" ");
        }
        sc.close(); 
    }
}    
