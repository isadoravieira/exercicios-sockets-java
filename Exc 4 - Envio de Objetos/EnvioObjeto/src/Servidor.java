import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public  static  void  main(String[] args) throws IOException, ClassNotFoundException {

        int porta = 12345;

        //1 Passso - Definir serverSocket (abrir porta de conexão)
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Porta aberta:  " + porta);
        System.out.println("Aguardando conexão de cliente");

        //2 Passo - Aguardar solicitação de conexão de cliente
        Socket clienteSocket = serverSocket.accept();
        System.out.println("Cliente conectado: " + clienteSocket.getInetAddress().getHostAddress());

        //3 Passo - Definir stream de entraa de dados no servidor
        ObjectInputStream entrada = new ObjectInputStream(clienteSocket.getInputStream());
        Pessoa pessoa1 = (Pessoa) entrada.readObject();
        System.out.println("--- PESSOA ---\n" + "Nome: " + pessoa1.getNome() + "\nIdade: " + pessoa1.getIdade() + " anos");

        //4 Passo - Fechar stream de entrada de dados
        entrada.close();

        //5 Passo - Fechar sockets de comunicação e conexão
        clienteSocket.close();
        serverSocket.close();
    }
}
