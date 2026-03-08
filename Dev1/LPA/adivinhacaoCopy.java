package Dev1.LPA;
import java.util.Random;
import java.util.Scanner;
public class adivinhacaoCopy{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[100];
        for(int n = 1; n <= 100; n++){
            numeros[n - 1] = n;
        }
        String[] falasErro = {"Você é muito ruim! Tente denovo." , "Passou perto... ou será que não?" , "Hahaha, que burro!" , "Não vai acertar nunca?" , "A sorte mandou um abraço!" , "Tá mal, hein?"};
        String[] falasAcertoPrimeira = {"O que foi isso? Você burlou meu código? Onde eu errei??" , "DE PRIMEIRA?? Quero ver fazer denovo!" , "Sua cuequinha deve tá toda melada de bosta." , "Como assim você acertou de primeira???"};
        String[] falasAcerto = {"Sorte de principiante..." , "Quero ver dar sorte de novo!" , "É, não foi dessa vez(pra mim)." , "Parabéns! Você deu sorte!"};
        Random rnd = new Random();
        int s = 1;
        int num;
        System.out.println("==================================\n Bem-vindo ao jogo da adivinhação\n==================================");
        System.out.print("Você tem 10 tentativas para acertar o número escolhido de 0 a 100. Tente a sorte ou falhe miseravelmente.");
        while (s == 1) {
            int x = rnd.nextInt(numeros.length);
            int xS = numeros[x];
            for(int i = 1; i <= 10; i++){
                for(int tentativas = 1; tentativas <= 10; tentativas++){
                    System.out.println(xS);
                    System.out.println("Digite um número: ");
                    num = sc.nextInt();
                    if (num == xS && tentativas == 1) {
                        int indiceAcertoPrimeira = rnd.nextInt(falasAcertoPrimeira.length);
                        String sorteadoPrimeira = falasAcertoPrimeira[indiceAcertoPrimeira];
                        System.out.println("Acertou de primeira!");
                        System.out.println(sorteadoPrimeira);
                        i = 11;
                        tentativas = 11;
                    }else if (num == xS && tentativas > 1) {
                        int indiceAcerto = rnd.nextInt(falasAcerto.length);
                        String sorteadoAcerto = falasAcerto[indiceAcerto];
                        System.out.println("Acertou!");
                        System.out.println(sorteadoAcerto);
                        i = 11;
                        tentativas = 11;
                    }else{
                        int indice = rnd.nextInt(falasErro.length);
                        String sorteado = falasErro[indice];
                        System.out.println("Errou!");
                        System.out.println(sorteado);
                        if (tentativas == 9) {
                            System.out.println("Essa é sua ultima tentativa, pense bem antes de respoder...");
                            if (num == xS) {
                                int indiceAcerto = rnd.nextInt(falasAcerto.length);
                                String sorteadoAcerto = falasAcerto[indiceAcerto];
                                System.out.println(sorteadoAcerto);
                            }
                        }
                    }
                    if (tentativas == 10) {
                        System.out.println("Você perdeu!!");
                        i = 11;
                        tentativas = 11;
                    }
                    
                        
                }
            }
            for(int z = 1; z <= 2; z++){
                System.out.println("Jogar novamente? [1] Sim ou [0] Não");
                int res;
                res = sc.nextInt();
                if (res == 1) {
                    System.out.println("Reiniciando");
                    z = 3;
                    continue;
                }else if (res == 0){
                    System.out.println("Fechando...");
                    z = 3;
                    s = 0;
                    break;
                }else{
                    System.out.println("Sério que você me fez criar uma linha de código pra isso?");
                    z = 1;
                    continue;
                }
            }
        }
        sc.close();
    }
}