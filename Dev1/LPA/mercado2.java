package Dev1.LPA;
//como fazer o somatorio das quantidades de produtos selecionado mais de uma vez na opçao 2
import java.text.DecimalFormat;
import java.util.Scanner;
public class mercado2 {
    static Scanner sc = new Scanner(System.in); 

    static DecimalFormat df = new DecimalFormat("#.###");

    static String nomeProdutos[] = {"Arroz 5kg", "Feijão Carioca 1kg",
    "Macarrão Espaguete 500g", 
    "Açúcar Refinado 1kg", 
    "Café Torrado 500g",
    "Leite Integral 1L"};
    
    static double precoProdutos[] = {24.90,
    8.49,
    4.59,
    3.99, 
    12.90,
    5.49};   
    
    // static int opcoesUsuario[] = {};         array para caso exista uma opcao repetida de um mesmo item

    static int opcoesUsuario[] = new int [20];

    static String carrinhoNomeProdutos[] = new String [20];
    
    static double carrinhoPrecoProdutos[] = new double [20];
    
    static int qntdProdutos[] = new int[20];
    
    static int contaCompras = 0;
    public static void main(String[] args){
        int op1 = 1;
        while (op1 != 0) {
            System.out.println("|======================================|");
            System.out.println("|----->Bem-vindo ao mercado Java!<-----|");
            System.out.println("|======================================|");
            System.out.println(" ");
            System.out.println("|------------Menu principal------------|");
            System.out.println(" ");
            System.out.println("[1] - Visualizar catálogo.");
            System.out.println("[2] - Adicionar itens ao carrinho.");
            System.out.println("[3] - Exibir o carrinho de compras.");
            System.out.println("[4] - Finaizar compra e exibir o total geral.");
            System.out.println("[0] - Sair.");
            op1 = sc.nextInt();
            if(op1 == 1){
                visualizarCatalogo();
            }
            if(op1 == 2){
                adicionarItens();
            }
            if (op1 == 3) {
                mostrarCarrinho();
            }
            if(op1 == 4){
                exibirCarrinho();
            }


        }
    }

    public static void visualizarCatalogo(){
        int op1 = 0;
        while (op1 != 1) {
            System.out.println("================CATÁLOGO================");
            for(int i = 0; i < nomeProdutos.length; i++){
                System.out.println(i + 1 + " - " + nomeProdutos[i] + " R$" + precoProdutos[i]);
            }
            System.out.println("\n[1] - Voltar para o menu.");
            op1 = sc.nextInt();
            if(op1 == 1){
                System.out.println("Voltando...");
                op1 = 1;
            }else{
            }
        }
    }

    public static void adicionarItens(){   
        for(int j = 0; j <= 20; j++){ 
            System.out.println("================CATÁLOGO================");
            System.out.println("==========> ADICIONAR ITENS <===========\n" + j);
            for(int i = 0; i < nomeProdutos.length; i++){
                System.out.println(i + 1 + " - " + nomeProdutos[i] + ": R$" + precoProdutos[i]);
            }
            System.out.println("Selecione o número do produto que deseja e aperte [0] para Sair(não se preocupe, seu carrinho será salvo!).");
            int p1 = sc.nextInt();
            if (p1 == 0) {
                break;
            }else if(p1 != 0){
                for(int k = 0; k <= nomeProdutos.length; k++){ 
                    if (p1 == k) {
                        int index = k - 1;
                        System.out.println("Quantas unidades deseja?");
                        int qntd = sc.nextInt();
                        for(int i = 0; i < 20; i++){
                            opcoesUsuario[i] = p1;
                            if (p1 == opcoesUsuario[i]) {
                                System.out.println((j + 1) + " - " + qntdProdutos[i + qntd] + "x unidade(s) de " + carrinhoNomeProdutos[j] + " | Valor: R$" + df.format(carrinhoPrecoProdutos[j] * qntd));
                            }
                        }
                        carrinhoNomeProdutos[contaCompras] = nomeProdutos[index];  
                        carrinhoPrecoProdutos[contaCompras] = precoProdutos[index];
                        qntdProdutos[contaCompras] = qntd;
                        contaCompras++;
                        System.out.println("============================================================");
                        System.out.println("Item adicionado ao carrinho!\n");
                        System.out.println((j + 1) + " - " + qntdProdutos[j] + "x unidade(s) de " + carrinhoNomeProdutos[j] + " | Valor: R$" + df.format(carrinhoPrecoProdutos[j] * qntd));
                        System.out.println("============================================================\n");
                    }if (p1 != k) {
                        continue;
                    }
                }
            }
        } 
    }
    
    public static void mostrarCarrinho(){
        System.out.println("================CARRINHO================");
        System.out.println("");
        for(int i = 0; i < carrinhoNomeProdutos.length; i++){
            if (carrinhoNomeProdutos[i] != null && carrinhoPrecoProdutos[i] != 0) {
                System.out.println(i + 1 + " - " + qntdProdutos[i] + "x " + carrinhoNomeProdutos[i] + " : R$" + df.format((double)qntdProdutos[i] * carrinhoPrecoProdutos[i]));
                
            }
        }
    }

    public static void exibirCarrinho(){
        System.out.println("========FINALIZAR COMPRA========");
        System.out.println("");
        double valorTotal = 0;
        for(int i = 0; i < carrinhoNomeProdutos.length; i++){
            valorTotal = valorTotal + (carrinhoPrecoProdutos[i] * qntdProdutos[i]);
            if (carrinhoNomeProdutos[i] != null && carrinhoPrecoProdutos[i] != 0) {
                System.out.println(i + 1 + " - " + qntdProdutos[i] + "x " + carrinhoNomeProdutos[i] + " : R$" + df.format((double)qntdProdutos[i] * carrinhoPrecoProdutos[i]));
            }
        } 
        System.out.println("\nValor total da compra: R$" + df.format(valorTotal) + "\n");
    }
}
