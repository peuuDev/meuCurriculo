//Faça um programa em Java que receba uma temperatura em
//centígrados e transforme para fahrenheit. Sabe-se que a fórmula
//para conversão é F=((9.C)+160)/5.

// import java.text.DecimalFormat;
package Dev1.LPA;
import java.util.Scanner;

public class conversorAdv {
    
    public static void main(String[] args){
                
        int inicio;
        int op1;
        int op2;
        double grausC; 
        double grausF;
        double grausK;

        
        Scanner sc = new Scanner(System.in);
        // DecimalFormat deci = new DecimalFormat("#.00°");

        System.out.println("Bem vindo ao conversor de Temperaturas! ");
        System.out.println("Deseja iniciar? Digite [1] para SIM e [2] para NÃO.");
        inicio = sc.nextInt();
        while(inicio == 1){;
            System.out.println("Qual conversão deseja operar? \n [1] Celsius -> Fahrenheit \n [2] Celsius -> Kelvin \n [3] Fahrenheit -> Celsius \n [4] Fahrenheit -> Kelvin \n [5] Kelvin -> Celsius \n [6] Kelvin -> Fahrenheit");
            op1 = sc.nextInt();
            if (op1 == 1) {
                System.out.println("Digite a temperatura em Graus Celsius: ");
                grausC = sc.nextDouble();
                grausF = (9 * grausC + 160) / 5;
                System.out.println("A conversão de " + grausC + "° Celcius para Fahrenheit é igual a: " + grausF + "° Fahrenheit!");                                
                }    

            if (op1 == 2) {
                System.out.println("Digite a temperatura em Graus Celcius: ");
                grausC = sc.nextDouble();
                grausK = grausC + 273; 
                System.out.println("A conversão de " + grausC + "° Celcius para Kelvin é igual a: " + grausK + "° Kelvin!");
            }
            
            if (op1 == 3) {
                System.out.println("Digite a temperatura em graus Fahrenheit: ");
                grausF = sc.nextDouble();
                grausC = (grausF - 32) / 1.8;
                System.out.println("A conversão de " + grausF + "° Fahrenheit para Celsius é igual a: " + grausC + "° Celcius!");
            }

            if (op1 == 4) {
                System.out.println("Digite a temperatura em graus Fahrenheit: ");
                grausF = sc.nextDouble();
                grausK = (grausF - 32) * 5 / 9 + 273; 
                System.out.println("A conversão de " + grausF + "° Fahrenheit para Kelvin é igual a: " + grausK + "° Kelvin!");
            }
            if (op1 == 5) {
                System.out.println("Digite a temperatura em graus Kelvin: ");
                grausK = sc.nextDouble();
                grausC = grausK - 273;
                System.out.println("A conversão de " + grausK + "° Kelvin para Celsius é igual a: " + grausC + "° Celcius!");
            }

            if (op1 == 6) {
                System.out.println("Digite a temperatura em graus Kelvin: ");
                grausK = sc.nextDouble();
                grausF = (grausK - 273) * 1.8 +  32;
                System.out.println("A conversão de " + grausK + "° Kelvin para Fahrenheit é igual a: " + grausF + "° Fahrenheit!");
            } 


            System.out.println("Deseja começar outra conversão? Digite [1] para SIM e [2] para NÃO. ");
            op2 = sc.nextInt();
            if (op2 == 1) {
                System.out.println("Recomeçando...");
            }else if(op2 == 2){
                System.out.println("Encerrando programa...");
                break;
            }
        }


        sc.close();
        
    }
}
