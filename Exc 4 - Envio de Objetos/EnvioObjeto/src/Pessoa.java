import java.io.Serializable;

public class Pessoa implements Serializable {

    //serializable diz que os objetos dessa classe podem ser cconvertidos
    // em bytes e assim podem ser trafegados via rede

    private String nome;
    private  int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
