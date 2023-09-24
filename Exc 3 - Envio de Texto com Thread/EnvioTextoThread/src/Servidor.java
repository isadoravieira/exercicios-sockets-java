import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public  static void main(String[] args) throws IOException {

        int porta = 12345;

        //1 Passo - Definir conexão serverSocket (abrir porta de conexão)
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("A porta 12345 foi aberta.");
        System.out.println("Aguardando conexões de clientes...");

        while (true){

            //2 Passo - Aguardar solicitações de conexão de clientes
            Socket clienteSocket = serverSocket.accept();

            //mostrar IP do cliente conectado
            System.out.println("Cliente conectado: " + clienteSocket.getInetAddress().getHostAddress());

            //3 Passo - Definir uma thread para cada cliente conectado
            ThreadSockets thread = new ThreadSockets(clienteSocket);
            thread.start();
        }

    }
}
