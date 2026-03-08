package Dev1.LPA;
import java.text.DecimalFormat;
import java.util.Scanner;

public class mercado3 {

    static String[] nomes = {"Arroz", "Feijao", "Macarrao", "Acucar",
            "Café", "Leite", "Óleo de Soja", "Farinha",
            "Sal", "Molho de Tomate", "Biscoito", "Papel Higiênico",
            "Sabonete", "Detergente", "Sabão em Pó", "Refrigerante",
            "Água Mineral", "Margarina", "Queijo", "Presunto"};

    static double[] precos = {24.90, 8.49, 4.59, 3.99, 12.90, 5.49, 6.29, 5.19, 2.49, 3.79,
            2.99, 8.90, 2.29, 2.99, 9.90, 8.49, 2.49, 7.29, 22.90, 18.90};

    static String[] carrinhoNome = new String[20];

    static double[] carrinhoPreco = new double[20];

    static double[] carrinhoQntd = new double[20];

    static double[] valorTotal = new double[20];

    static int[] estoque = {10, 15, 20, 25, 30, 15, 12, 20, 30, 20, 25, 14, 28, 36, 22, 16, 40, 26, 30, 20};

    static int itensCarrinho = 0;

    static Scanner sc = new Scanner(System.in);

    static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {
        int opcao;
        do {

            System.out.println("||");
            System.out.println("|>---------Bem-Vindo ao Mercado Java!---------<|");
            System.out.println("||");
            System.out.println(" ");
            System.out.println("O que deseja?: ");
            System.out.println("[1] - Visualizar catálogo.");
            System.out.println("[2] - Adicionar itens ao carrinho.");
            System.out.println("[3] - Exibir o carrinho de compras.");
            System.out.println("[4] - Remover algum item.");
            System.out.println("[5] - Finalizar compra e exibir o total geral.");
            System.out.println("[0] - Sair");
            System.out.println("Qual opção deseja escolher? ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Finalizando...");
                    break;
                case 1:
                    exibirCatalogo();
                    break;
                case 2:
                    adicionarItens();
                    break;
                case 3:
                    exibirCarrinho();
                    break;
                case 4:
                    removerItem();
                    break;
                case 5:
                    finalizarCompra();
                    break;
                default:
                    break;
            }

        } while (opcao != 0);
    }

    public static void exibirCatalogo() {
        System.out.println("\n===== CATÁLOGO DE PRODUTOS =====");

        for (int i = 0; i < nomes.length; i++) {
            System.out.println((i + 1) + " - " + nomes[i] + " | R$ " + String.format("%.2f", precos[i]) + "\n");
        }
    }

    public static void adicionarItens() {

        System.out.print("Digite o número do item que deseja adicionar: ");
        int escolha = sc.nextInt();

        if (escolha < 1 || escolha > nomes.length) {
            System.out.println("Numero inválido!");
            return;
        }
        System.out.print("\nQual quantidade de itens você deseja: ");
        int qntd = sc.nextInt();

        if (qntd > estoque[escolha - 1]) {
            System.out.println("O item não tem quantidade suficiente no estoque!\n");
            return;
        }

        String nome = nomes[escolha - 1];
        double precoUnitario = precos[escolha - 1];
        double total = precoUnitario * qntd;

        carrinhoNome[itensCarrinho] = nome;
        carrinhoPreco[itensCarrinho] = precoUnitario;
        carrinhoQntd[itensCarrinho] = qntd;
        itensCarrinho++;

        System.out.println("\n===== ITEM ADICIONADO AO CARRINHO =====");
        System.out.println("Nome do produto: " + nome + " | Quantidade: " + qntd + " x Valor unitário: R$ " + precoUnitario + " | Total a pagar R$: " + total + "\n");
    }

    public static void exibirCarrinho() {
        if (itensCarrinho == 0) {
            System.out.println("\nO carrinho está vazio!");
            return;
        }
        System.out.println("\n===== CARRINHO DE COMPRA ATUAL =====\n");

        double total = 0;
        // for(int i = 0; i < itensCarrinho; i++){
        //     if (carrinhoNome[i] == null && carrinhoPreco[i] == 0) {
        //         System.out.print(i);
        //     }
        // }
        for (int i = 0; i < itensCarrinho; i++) {
            if (carrinhoNome[i] != null && carrinhoPreco[i] != 0){
                System.out.print(i + 1 + " - " + carrinhoNome[i] + " Quantidade: " + carrinhoQntd[i] + " | Preço: R$ " + df.format(carrinhoPreco[i] * carrinhoQntd[i]) + "\n");
                valorTotal[i] = carrinhoPreco[i] * carrinhoQntd[i];
            }
        }
        System.out.println("Você pretende remover algum item? [1] Sim ou [0] Não");
        int op1 = sc.nextInt();
        sc.nextLine();
        if (op1 == 1) {
            System.out.println("Digite o nome do item que voce quer tirar?");
            String indice = sc.nextLine();
            for(int i = 0; i < itensCarrinho; i++){
                if (indice.equalsIgnoreCase(carrinhoNome[i])) {
                    for(int j = i; j < itensCarrinho; j++){
                        if (j == 20) {
                        carrinhoNome[19] = null;
                        carrinhoPreco[19] = 0.0;   
                        carrinhoQntd[19] = 0.0;   
                    }else{
                        carrinhoNome[j] = carrinhoNome[j + 1];
                        carrinhoPreco[j] = carrinhoPreco[j + 1];
                        carrinhoQntd[j] = carrinhoQntd[j + 1];
                    }
                    }
                }
            }
        }else if(op1 == 0){

        }
        for(int i = 0; i < itensCarrinho; i++){
            total += (carrinhoPreco[i] * carrinhoQntd[i]);
        }
        System.out.println("\nVALOR TOTAL: R$: " + df.format(total));
    }

    public static int removerItem() {
        if (itensCarrinho == 0) {
            System.out.println("Carrinho está vazio!");
        }
        exibirCarrinho();

        System.out.println("\nDigite o número do item que deseja remover: ");
        int numRemover = sc.nextInt();
        int indice = numRemover - 1;

        String nomeRemovido = carrinhoNome[indice];
        System.out.println("\nO item " + nomeRemovido + " foi removido com sucesso!\n");
        
        carrinhoNome[indice] = null;
        carrinhoPreco[indice] = 0.0;
        carrinhoQntd[indice] = 0.0;

        
        if (numRemover < 1 || numRemover > itensCarrinho) {
            System.out.println("Número de item invalido! Tente novamente, por favor: ");
        }
        return indice;
    }

    public static void finalizarCompra() {
        System.out.println("========FINALIZAR COMPRA========");
        System.out.println("");

        double desconto = 0.0;

        System.out.println("Você possui cupom de desconto? Digite: Sim ou Não");
        sc.nextLine();
        String usarCupom = sc.nextLine();

        if (usarCupom.equals("Sim")) {
            System.out.println("Digite qual o código de desconto (ex: mercado10 para 10% de desconto): ");
            String cupom = sc.nextLine();

            if (cupom.equals("mercado10")) {
                desconto = 0.10;
                System.out.println("Cupom inserido com sucesso!");
            } else {
                System.out.println("Cupom Invalído!");
            }
        }

        double valorP = 0;
        for (int i = 0; i<itensCarrinho; i++) {
            valorP = (carrinhoPreco[i] *carrinhoQntd[i]);
        }

        double valorDesconto = valorP * desconto;
        double valorTotal= valorP - valorDesconto;

        System.out.println("/n======== Recibo da Compra ========");

        System.out.println("----------------------------------------");
        System.out.println("Item            Quantidade      Preço");
        System.out.println("----------------------------------------");
        for(int i = 0; i < carrinhoNome.length; i++){
            if (carrinhoNome[i] != null && carrinhoPreco[i] != 0){
                System.out.println(carrinhoNome[i] + "    " + carrinhoQntd[i] +  "    R$ " + carrinhoPreco[i]);
            }
            }
        System.out.println("----------------------------------------");
        System.out.println("Total sem desconto: " +df.format(valorP));
        System.out.println("Valor final com desconto: " +df.format(valorTotal));
        System.out.println("-------------------------------");

        System.out.println("Compra Finalizada!");
    }
}