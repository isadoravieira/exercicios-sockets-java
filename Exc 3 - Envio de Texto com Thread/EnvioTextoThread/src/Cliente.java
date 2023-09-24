import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {

    public  static void main(String[] args) throws IOException {

        String host = "localhost";
        int porta = 12345;

        //1 Paasso - Abrir conexão
        Socket socket = new Socket(host,porta);

        //2 Passo - Definir stream de saida do cliente
        DataOutputStream saida = new DataOutputStream(socket.getOutputStream());
        saida.writeUTF("erickito");

        //3 Passo - Definir stream de entrada de dados do servidor no cliente
        DataInputStream entrada = new DataInputStream(socket.getInputStream());
        String mensagemFormatada = entrada.readUTF();//receber mensagem em maiusculo do servidor
        System.out.print("Mensagem do servidor: " + mensagemFormatada);//mostrar mensagem em maiusculo

        //4 Passo - Fechar streams de entrada e saida
        saida.close();
        entrada.close();

        //5 Passo - Fechar conexão socket
        socket.close();
    }
}
