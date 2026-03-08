package Dev1.LPA;

import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class banco {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> nomeUsuario = new ArrayList<>();
    static ArrayList<Integer> idadeUsuario = new ArrayList<>();
    static ArrayList<Double> saldoUsuario = new ArrayList<>();
    public static void main(String args[]){
        bancoPrime();
    }
    public static void bancoPrime(){
        // 11) Escreva um programa para ler o nome do cliente e o saldo inicial de uma conta bancária. A seguir ler um
        // número indeterminado de pares de valores indicando respectivamente o tipo da operação (codificado da
        // seguinte forma: 1.Depósito 2.Retirada 3.Fim) e o valor. Quando for informado para o tipo o código 3, o
        // programa deve ser encerrado e impresso o saldo final da conta com as seguintes mensagens: CONTA ZERADA,
        // CONTA ESTOURADA(se o saldo for negativo) ou CONTA PREFERENCIAL (se o saldo for positivo).
        
        System.out.println("\n\n- - - - Bem-Vindo(a) ao banco Java! - - - -\n\n- - - - Pressione [1] para iniciar! - - - -");
        int n = sc.nextInt(); boolean changer = false;
        if (n != 1) {
            System.out.println("Erro...");
            return;
        }
        do{
            if (saldoUsuario.isEmpty()) {
                saldoUsuario.add(1621.0);
            }
            if (changer == false) {
                printMenuPrincipal(null);
                int op = sc.nextInt();
                sc.nextLine();
                switch(op){
                    case 1: System.out.println("- - - - Menu de Cadastro - - - -\n1) Digite o seu nome e sobrenome: ");
                    String nomeCompleto = sc.nextLine();
                    nomeUsuario.add(nomeCompleto);
                    System.out.println("\n2) Digite sua idade, " +  nomeCompleto + ":");
                    int idade = sc.nextInt();
                    idadeUsuario.add(idade);
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
                printMenuPrincipal(nomeUsuario.get(0));
                int op = sc.nextInt();
                sc.nextLine();
                switch (op) {
                    case 1: 
                    int s = 0;
                    do{
                        printSection("Menu de Cadastro");
                        System.out.println("Nome do usuário: " + nomeUsuario.get(0)+"\nIdade do usuário: " + idadeUsuario.get(0) + "\n\nDeseja alterar alguma informação?\n[1] para alterar Nome\n[2] para alterar a idade\n[3] Voltar para o menu principal");
                        int op2 = sc.nextInt();
                        sc.nextLine();
                        if (op2 == 1) {
                            System.out.println("Digite o novo nome: ");
                            String nomeCompleto = sc.nextLine();
                            nomeUsuario.remove(0);
                            nomeUsuario.add(nomeCompleto);
                            System.out.println("Nome alterado para: " + nomeUsuario.get(0)); 
                            s = 0;
                        }else if (op2 == 2) {
                            System.out.println("Digite a nova idade: ");
                            int idade = sc.nextInt();
                            if (idade >= 18) {
                                idadeUsuario.remove(0);
                                idadeUsuario.add(idade);
                                System.out.println("Idade alterada para: " + idadeUsuario.get(0) + " anos.");
                                s = 0;
                            }else if(idade <= 17){
                                System.out.println("Não é possível mudar para uma idade menor que 18 anos, deseja prosseguir com esta idade ou continuar com a atual? Se prosseguir, o programa será finalizado. [1] Permanecer com a idade atual [0] Mudar para a nova" );
                                int op3 = sc.nextInt();
                                if (op3 == 1) {
                                }else if (op3 == 0){
                                    System.out.println("Finalizando programa...");
                                    return;
                                }
                            }
                        }else if(op2 == 3){
                            System.out.println("Voltando para o menu principal...");
                            s = 1;
                        }
                    } while (s == 0);
                        break;
                    case 2: 
                    s = 0;
                    do{
                        printSection("Depósito e Retirada");
                        System.out.println("--> Saldo atual: " + formatBR(saldoUsuario.get(0)) + " <--\n\n[1] Fazer depósito\n[2] Fazer retirada\n[3] Sair");
                        int op1 = sc.nextInt();
                        sc.nextLine();
                        if (op1 == 1) {
                            System.out.println("Digite o valor para depósito:");
                            double valorDepositado = sc.nextDouble();
                            sc.nextLine();
                            double saldoUsuarioAtual = saldoUsuario.get(0);
                            System.out.println("Valor depositado com sucesso!\nSaldo antigo: " + formatBR(saldoUsuarioAtual));
                            saldoUsuarioAtual += valorDepositado;
                            saldoUsuario.set(0, saldoUsuarioAtual);
                            System.out.println("Saldo atual: " + formatBR(saldoUsuario.get(0)));
                        } else if (op1 == 2) {
                            System.out.println("Digite o valor de retirada: ");
                            double valorRetirada = sc.nextDouble();
                            sc.nextLine();
                            double saldoUsuarioAtual = saldoUsuario.get(0);
                            System.out.println("Valor retirado com sucesso!\nSaldo antigo: " + formatBR(saldoUsuarioAtual));
                            saldoUsuarioAtual -= valorRetirada;
                            saldoUsuario.set(0, saldoUsuarioAtual);
                            System.out.println("Saldo atual: " + formatBR(saldoUsuario.get(0)));
                        }else if(op1 == 3){
                            System.out.println("Voltando para o menu...");
                            s = 1;
                        }
                    }while (s == 0);
                        break;
                    case 3:
                        printSection("Situação da Conta");
                        if(saldoUsuario.get(0) == 0.0){
                            System.out.println("Conta zerada -> Seu saldo é R$00,00.");
                        }else if(saldoUsuario.get(0) > 0.0){
                            System.out.println("Conta preferencial -> Seu saldo está positivo (" + formatBR(saldoUsuario.get(0)) + ")");
                        }else if(saldoUsuario.get(0) < 0.0){
                            System.out.println("Conta estourada -> Seu saldo está negativo (" + formatBR(saldoUsuario.get(0)) + ")");
                        }
                        break;
                    case 4:
                        n = 0;
                    default:
                        break;
                }
            }
        }while(n == 1);
    }

    private static String formatBR(double value) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return nf.format(value);
    }

    private static void printMenuPrincipal(String nomeUsuario) {
        printHeader("Menu Principal");
        if (nomeUsuario != null) {
            System.out.println("Olá, " + nomeUsuario + "!");
            System.out.println("Saldo atual: " + formatBR(saldoUsuario.get(0)));
            System.out.println();
        }
        System.out.println("[1] Cadastro" + (nomeUsuario == null ? "*" : ""));
        System.out.println("[2] Depósito e retirada");
        System.out.println("[3] Situação da conta");
        System.out.println("[4] Finalizar programa");
    }

    private static void printHeader(String title) {
        System.out.println("\n========================================");
        System.out.println("             " + title);
        System.out.println("========================================\n");
    }

    private static void printSection(String title) {
        System.out.println("\n--- " + title + " ---\n");
    }
} 