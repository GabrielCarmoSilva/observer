package alertatempestade;

import java.util.Observable;

public class Bairro extends Observable {

    private String nome;
    private String cidade;
    private String estado;

    public Bairro(String nome, String cidade, String estado) {
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void emitirAlertaTempestade() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}