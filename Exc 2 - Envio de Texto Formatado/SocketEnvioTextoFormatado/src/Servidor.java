import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        int porta = 12345;

        //1 Passo - Definir o serverSocket (abrir a porta de conexão)
        ServerSocket serverSocket = new ServerSocket(porta);
        System.out.println("Porta esta aberta.");
        System.out.println("Aguardando a conexão do cliente.");

        //2 Passo - aguardar solicitação de conexão de cliente
        Socket clienteSocket = serverSocket.accept();
        System.out.println("Cliente conectado: " + clienteSocket.getInetAddress().getHostAddress()); // mostrando o endereço do cliente

        //3 Passo - Definir stream de saida de dados do servidor
        DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
        String mensagemCliente = entrada.readUTF(); //receber mensagem em mnusculo do cliente
        String mensagemFormatada = mensagemCliente.toUpperCase(); //converte mensagem para maiusculo

        //4 Passo - Definir stream dde saida de dados do servidor
        DataOutputStream saida = new DataOutputStream(clienteSocket.getOutputStream());
        saida.writeUTF(mensagemFormatada);
        System.out.print("Mensagem formatada com sucesso!");
        System.out.print("Conexão encerrada.");

        //5 Passo - Fechar streams de entrada e saida de dados
        entrada.close();
        saida.close();

        //6 Passo - Fechar sockets de comunicação e conexão
        clienteSocket.close();
        serverSocket.close();

    }
}
