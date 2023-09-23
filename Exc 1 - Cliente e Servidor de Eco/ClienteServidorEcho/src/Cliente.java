import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws IOException {

        // Configuração do host (servidor) e porta a serem usados
        String host = "localhost";  // O servidor está na mesma máquina (localhost)
        int porta = 12345; // Porta em que o servidor está ouvindo

        // Tenta estabelecer uma conexão com o servidor usando um Socket
        try(Socket socket = new Socket(host,porta)) {

            // Cria um PrintWriter para enviar dados para o servidor por meio do OutputStream do Socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            // Cria um BufferedReader para receber dados do servidor por meio do InputStream do Socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Cria um BufferedReader para ler entrada do console (usuário)
            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in));

            String entradaUsuario;

            // Entra em um loop para ler e enviar mensagens para o servidor
            while ((entradaUsuario = consoleIn.readLine()) != null){
                // Envia a mensagem digitada pelo usuário para o servidor
                out.println(entradaUsuario);

                // Lê a resposta do servidor e a imprime no console
                System.out.println("Resposta do servidor: " + in.readLine());
            }
        }
    }
}

//O resultado é que o cliente lê mensagens do usuário a partir do console, envia essas mensagens para o servidor e
// imprime as respostas do servidor no console. Este é um exemplo de comunicação cliente-servidor simples usando sockets em Java.
// O servidor de echo simplesmente retorna o que é enviado pelo cliente.
