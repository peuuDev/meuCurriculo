// 9) Faça um programa que receba um valor n e em seguida informe o valor de S.
package Dev1.LPA;

import java.util.ArrayList;
import java.util.Scanner;

public class exercicios {
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        banco();
    }
    public static void banco(){
        // 11) Escreva um programa para ler o nome do cliente e o saldo inicial de uma conta bancária. A seguir ler um
        // número indeterminado de pares de valores indicando respectivamente o tipo da operação (codificado da
        // seguinte forma: 1.Depósito 2.Retirada 3.Fim) e o valor. Quando for informado para o tipo o código 3, o
        // programa deve ser encerrado e impresso o saldo final da conta com as seguintes mensagens: CONTA ZERADA,
        // CONTA ESTOURADA(se o saldo for negativo) ou CONTA PREFERENCIAL (se o saldo for positivo).
        ArrayList<String> nomeUsuario = new ArrayList<>();
        ArrayList<Double> saldoUsuario = new ArrayList<>();
        
        System.out.println("\n\n- - - - Bem-Vindo(a) ao banco Java! - - - -\n\n- - - - Pressione [1] para iniciar! - - - -");
        int n = sc.nextInt(); boolean changer = false;
        if (n != 1) {
            System.out.println("Erro...");
            return;
        }
        do{
            saldoUsuario.add(1.621);
            if (changer == false) {
                System.out.println("\n\n- - - - Menu Principal - - - -\n--> Saldo atual: R$ 1.621,00 <--\n\n[1] Cadastro*\n[2] Depósito\n[3] Retirada\n[4] Situação da conta\n[5] Finalizar programa");
                int op = sc.nextInt();
                sc.nextLine();
                switch(op){
                    // Gerar um novo menu atualizado sem o asterisco no cadastro e possibilitando o uso de todas as outras opçoes do menu
                    case 1: System.out.println("- - - - Menu de Cadastro - - - -\n1) Digite o seu nome e sobrenome: ");
                    String nomeCompleto = sc.nextLine();
                    nomeUsuario.add(nomeCompleto);
                    System.out.println("\n2) Digite sua idade, " +  nomeCompleto + ":");
                    int idade = sc.nextInt();
                    if (idade <= 17) {
                        System.out.println("Desculpe, você é menor de idade, não poderá abrir uma conta bancária.");
                        n = 0;
                    }else{
                        System.out.println("Cadastro realizado com sucesso! Voltando para o menu...");
                        changer = true;
                    }
                    break;
                    case 2: System.out.println("Realize o cadastro primeiro!");
                    break;
                    case 3: System.out.println("Realize o cadastro primeiro!");
                    break;
                    case 4: System.out.println("Realize o cadastro primeiro!");
                    break;
                    case 5: n = 0;
                    break;
                    default:
                }
            }else if (changer == true) {
                
            }

        }while(n == 1);
        
    }
    public static void a(){
        // a) s=1+1/2+1/3+...+1/n
        double n = sc.nextInt(), s = 0, num = 1;
        
        for(int i = 1; i <= n; i++){
            s += num / i;
        }
        System.out.println(s);
    }
    public static void b(){
        // b) s=1/n + 2/(n-1) + 3/(n-2) +...+ (n-1)/2+n
        double n = sc.nextInt(), s = 0, cont = 0;
        
        for(int i = 1; i <= n; i++){
            s += i / (n - cont);
            cont++;
            System.out.println(s);
        }
    }
    public static void c(){
        // c) s = 1 - 1/2 + 1/3 - 1/4 +...+ 1/n
        double n = sc.nextInt(), s = 0, num = 1, verif = 0;

        for(int i = 1; i <= n; i++){
            verif = i % 2;
            if (verif == 0) {
                s += (- 1) * (num / i); 
            }else{
                s += num / i;
            }
            verif = 0;
            System.out.println(s);
        }
    }
    public static void fibonacci(){
        
        int sum = 0, t1 = 1, t2 = 0; ArrayList<Integer> fibonacci = new ArrayList<>();
        
        for(int i = 1; i <= 10; i++){
            sum = t1 + t2;
            if (i % 2 == 0) {
                t1 = sum;
            }
            if (i % 2 != 0) {
                t2 = sum;
            }
            fibonacci.add(sum);
            // System.out.println(sum);
        }
        int n = sc.nextInt();

        if(fibonacci.contains(n)){
            System.out.println("Este número faz parte da sequência de Fibonacci!");
        }else{
            System.out.println("Este número não faz parte da sequência de Fibonacci.");
        }
    }
}
