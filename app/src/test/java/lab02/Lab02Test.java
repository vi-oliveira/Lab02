package lab02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lab02.Clientes.Cliente;
import lab02.Eventos.Evento;
import lab02.Eventos.EventoEmBar;
import lab02.Eventos.EventoShow;
import lab02.Eventos.HistoricoEventos;
import lab02.Eventos.Caracteristicas.CaracteristicaEventoEmBar;
import lab02.Notificacoes.Notificacao;
import lab02.Notificacoes.NotificacaoEmail;

public class Lab02Test {
    @Test
    public void notificar() {
        Cliente daniel = new Cliente("Daniel Franco", "shaolinMatadorDePorco@gmail.com", "4002-8922");
        Notificacao danielNotificacaoEmail = new NotificacaoEmail(
            "Houve uma tentativa de login na sua conta recentemente.",
            "Login desconhecido");

        daniel.adiconarNotificacao(danielNotificacaoEmail);
        daniel.enviarNotificacoes();
        assertEquals(0, daniel.getNotificaoPendentes().size());
        assertEquals(1, daniel.getNotificaoEnviadas().size());
    }

    @Test
    public void compararClientes() {
        Local teatroArena = new Local("Teatro de Arena", 100);

        HistoricoEventos historico = new HistoricoEventos();

        Organizadora javaEventos = new Organizadora("Java Eventos ltda",
        12345678, "Rua que brilha nº123");
    
        EventoShow showGoogle = javaEventos.criarEvento("Músicas IA",
        150, LocalDate.of(2025, 7, 29), "Chat Gemini", historico);
        
        try{
            teatroArena.alocarParaEvento(showGoogle);
        } catch (Exception e){}

        Cliente daniel = new Cliente("Daniel Franco", "shaolinMatadorDePorco@gmail.com", "4002-8922");
        Cliente gabriela = new Cliente("Gabriela", "EEEMAIL@gmail.com", "9999-1111");

        Ingresso ingressoShowGoogle = new Ingresso(showGoogle, showGoogle.getPrecoIngresso());
        Ingresso ingressoShowGoogle2 = new Ingresso(showGoogle, showGoogle.getPrecoIngresso());

        try{
            showGoogle.venderIngresso(daniel, ingressoShowGoogle);
            showGoogle.venderIngresso(gabriela, ingressoShowGoogle2);
        } catch (Exception e){}

        Set<Evento> eventosEmComum = daniel.compararA(gabriela);

        assertEquals(1, eventosEmComum.size());
    }

    @Test
    public void testarEventoBar(){
        Local barzinho = new Local("Bar Tolomeu", 10);

        HistoricoEventos historico = new HistoricoEventos();

        Organizadora javaEventos = new Organizadora("Java Eventos ltda",
        12345678, "Rua que brilha nº123");

        CaracteristicaEventoEmBar caracteristicasBar = new CaracteristicaEventoEmBar(barzinho.getNome(), "22:00", 2);
        EventoEmBar eventoBar = javaEventos.criarEvento("SUPER BAR",
        20, LocalDate.of(2025, 12, 14), caracteristicasBar, historico);
        try {
            barzinho.alocarParaEvento(eventoBar);
        } catch (Exception e) {
            System.out.println(e);
        }

        String descricaoEsperada = "Evento no bar: Bar Tolomeu, Happy Hour Inicio: 22:00, Duração: 2";
        String descricaoBar = eventoBar.getCaracteristicas().descricao();

        assertEquals(descricaoEsperada, descricaoBar);
        
    }

    @Test
    public void tratamentoCancelamentoNaoPermitido(){
        
    }
}
