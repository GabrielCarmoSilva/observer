package alertatempestade;

import java.util.Observable;
import java.util.Observer;

public class Habitante implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Habitante(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void cadastrar(Bairro bairro) {
        bairro.addObserver(this);
    }

    public void update(Observable grupo, Object arg1) {
        this.ultimaNotificacao = this.nome + ", alerta de tempestade emitido no " + grupo.toString();
        // System.out.println(this.ultimaNotificacao);
    }
}