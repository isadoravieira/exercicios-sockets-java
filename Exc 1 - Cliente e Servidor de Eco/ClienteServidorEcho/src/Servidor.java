import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static  void main(String[] args) throws IOException {

        int porta = 12345;

        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Servidor aguardando conexões na porta: " + porta);

        while (true){
            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clienteSocket.getInetAddress());

            PrintWriter out = new PrintWriter(clienteSocket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));

            String mensagemCliente;

            while ((mensagemCliente = in.readLine()) != null){
                System.out.println("Recebido: " + mensagemCliente);
                out.println("Recebido: " + mensagemCliente);
            }

            clienteSocket.close();
        }
    }
}

//O servidor continua a aceitar novas conexões de clientes e a realizar a comunicação de eco enquanto estiver em execução.
// Isso é um exemplo simples de um servidor de eco que recebe mensagens dos clientes e envia as mesmas mensagens de volta para eles.