package alertatempestade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HabitanteTest {

    @Test
    void deveNotificarUmHabitante() {
        Bairro bairro = new Bairro("São Pedro", "Juiz de Fora", "Minas Gerais");
        Habitante habitante = new Habitante("Habitante 1");
        habitante.cadastrar(bairro);
        bairro.emitirAlertaTempestade();
        assertEquals("Habitante 1, alerta de tempestade emitido no Bairro{nome='São Pedro', cidade='Juiz de Fora', estado='Minas Gerais'}", habitante.getUltimaNotificacao());
    }

    @Test
    void deveNotificarHabitantes() {
        Bairro bairro = new Bairro("São Pedro", "Juiz de Fora", "Minas Gerais");
        Habitante habitante1 = new Habitante("Habitante 1");
        Habitante habitante2 = new Habitante("Habitante 2");
        habitante1.cadastrar(bairro);
        habitante2.cadastrar(bairro);
        bairro.emitirAlertaTempestade();
        assertEquals("Habitante 1, alerta de tempestade emitido no Bairro{nome='São Pedro', cidade='Juiz de Fora', estado='Minas Gerais'}", habitante1.getUltimaNotificacao());
        assertEquals("Habitante 2, alerta de tempestade emitido no Bairro{nome='São Pedro', cidade='Juiz de Fora', estado='Minas Gerais'}", habitante2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarHabitante() {
        Bairro bairro = new Bairro("São Pedro", "Juiz de Fora", "Minas Gerais");
        Habitante habitante = new Habitante("Habitante 1");
        bairro.emitirAlertaTempestade();
        assertEquals(null, habitante.getUltimaNotificacao());
    }

    @Test
    void deveNotificarHabitanteSaoPedro() {
        Bairro bairroSaoPedro = new Bairro("São Pedro", "Juiz de Fora", "Minas Gerais");
        Bairro bairroAeroporto = new Bairro("Aeroporto", "Juiz de Fora", "Minas Gerais");
        Habitante habitante1 = new Habitante("Habitante 1");
        Habitante habitante2 = new Habitante("Habitante 2");
        habitante1.cadastrar(bairroSaoPedro);
        habitante2.cadastrar(bairroAeroporto);
        bairroSaoPedro.emitirAlertaTempestade();
        assertEquals("Habitante 1, alerta de tempestade emitido no Bairro{nome='São Pedro', cidade='Juiz de Fora', estado='Minas Gerais'}", habitante1.getUltimaNotificacao());
        assertEquals(null, habitante2.getUltimaNotificacao());
    }
}