import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Cliente {

    public  static  void  main(String[] args) throws IOException {

        String host = "localhost";
        int porta = 12345;

        //1 Passo - abrir conexão
        Socket socket = new Socket(host,porta);

        //2 Passo - Definir stream de saida  de dados do cliente
        ObjectOutputStream saida = new ObjectOutputStream(socket.getOutputStream());
        Pessoa pessoa1 = new Pessoa("Isadora", 20);
        saida.writeObject(pessoa1);

        System.out.println("Objeto enviado com sucesso!");

        //3 Passo - fechar stream de saida de dados
        saida.close();

        //4 Passo - Fechar socket de canexão
        socket.close();

    }
}
