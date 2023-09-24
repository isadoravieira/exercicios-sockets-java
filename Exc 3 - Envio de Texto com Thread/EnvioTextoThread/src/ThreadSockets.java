import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadSockets extends  Thread {

    private Socket clienteSocket;

    public ThreadSockets(Socket s){
        this.clienteSocket = s;
    }

    public  void run(){
        System.out.println("Thread atual: " + Thread.currentThread().getName()); // imprime o nome da thread atual


        try {
            //1 Passo - Definir stream de entrada de dados no servidor
            DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
            String mensagem =  entrada.readUTF(); //recebendo mensagem em minusculo do cliente
            String mensagemFormatada = mensagem.toUpperCase(); // converte mensaegm para maiusculo

            //2 Passo - Define stream de saida de dados do servidor
            DataOutputStream saida = new DataOutputStream(clienteSocket.getOutputStream());
            saida.writeUTF(mensagemFormatada);

            //3 Passo - Fechar streams dde entrada e saida de dados
            entrada.close();
            saida.close();

            //4 Passo - Fechar socket de comunicação
            clienteSocket.close();

        } catch (IOException e) {
            System.out.println("Erro: " + e.toString());
        }
    }
}
