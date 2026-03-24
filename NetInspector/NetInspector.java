package NetInspector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class NetInspector {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Uso: java NetInspector <dominio>");
            return;
        }

        String dominio = args[0];

        try {
            // =========================
            // PARTE 1 - DNS
            // =========================
            long inicioDNS = System.currentTimeMillis();
            InetAddress endereco = InetAddress.getByName(dominio);
            long fimDNS = System.currentTimeMillis();

            String ip = endereco.getHostAddress();
            long tempoDNS = fimDNS - inicioDNS;

            System.out.println("===== NETINSPECTOR =====");
            System.out.println("Domínio: " + dominio);
            System.out.println("IP: " + ip);
            System.out.println("Tipo: A");
            System.out.println("Tempo DNS: " + tempoDNS + " ms");

            // =========================
            // PARTE 2 - PORTAS TCP
            // =========================
            System.out.println("\n--- Teste de Portas TCP ---");
            testarPorta(ip, 80);
            testarPorta(ip, 443);
            testarPorta(ip, 21);

            // =========================
            // PARTE 3 - HTTP
            // =========================
            System.out.println("\n--- Requisição HTTP ---");
            requisicaoHTTP(dominio);

        } catch (Exception e) {
            System.out.println("Erro geral: " + e.getMessage());
        }
    }

    public static void testarPorta(String ip, int porta) {
        try {
            Socket socket = new Socket(ip, porta);
            socket.setSoTimeout(2000);
            System.out.println("Porta " + porta + ": aberta");
            socket.close();
        } catch (Exception e) {
            System.out.println("Porta " + porta + ": fechada");
        }
    }

    public static void requisicaoHTTP(String dominio) {
        try {
            Socket socket = new Socket(dominio, 80);
            socket.setSoTimeout(5000);

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            out.println("GET / HTTP/1.1");
            out.println("Host: " + dominio);
            out.println("Connection: close");
            out.println();
            out.flush();

            String linha;
            int contentLength = 0;

            while ((linha = in.readLine()) != null) {

                if (linha.startsWith("HTTP/")) {
                    String[] partes = linha.split(" ");
                    System.out.println("HTTP Status: " + partes[1]);
                }

                if (linha.startsWith("Server:")) {
                    System.out.println(linha);
                }

                if (linha.startsWith("Content-Type:")) {
                    System.out.println(linha);
                }

                if (linha.startsWith("Content-Length:")) {
                    System.out.println(linha);
                    String[] partes = linha.split(" ");
                    contentLength = Integer.parseInt(partes[1]);
                }

                if (linha.startsWith("Date:")) {
                    System.out.println(linha);
                }
            }

            if (contentLength > 0) {
                System.out.println("Tamanho da resposta: " + contentLength + " bytes");
            }

            socket.close();

        } catch (Exception e) {
            System.out.println("Erro HTTP: " + e.getMessage());
        }
    }
}