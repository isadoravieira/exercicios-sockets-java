import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int porta = 12345;

        //1 Passo - Abrir conexão
        Socket socket = new Socket(host,porta);

        //2 Passo - Definir stream de entrada de dados do cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("isadora"); //Enviar mensagem em minusculo para o servidor

        //3 Passo - Definir stream de entrada de dados do cliente
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String novaMensagem = entrada.readUTF(); //Receber mensagem em maiusculo do servidor
        System.out.println("Mensagem do servidor: " + novaMensagem); // mostrar a mensagem em maiusculo no cliente

        System.out.print("Conexão encerrada.");

        //4 Passo - Fechar streams de entrada e saida de dados
        entrada.close();
        saida.close();

        //5 Passo - Fechar o socket
        socket.close();

    }
}
