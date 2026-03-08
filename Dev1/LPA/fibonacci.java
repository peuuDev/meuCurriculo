package Dev1.LPA;
// Leia um número N e mostre os N primeiros números da sequência de Fibonacci.

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        
        int num = 5;
        int a = 0;
        int b = 1;
        int result = 0;

        Scanner sc = new Scanner(System.in);
        System.err.print("Digite um número");
        num = sc.nextInt();

        for(int i = 1; i <= num; i++){
            System.out.println(a);
            result = a + b;
            a = b;
            b = result;
        } 

        sc.close();
    }
}
