package lab02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import lab02.Clientes.Cliente;
import lab02.Eventos.Evento;
import lab02.Eventos.EventoEmBar;
import lab02.Eventos.EventoShow;
import lab02.Eventos.HistoricoEventos;
import lab02.Exceptions.CancelamentoNaoPermitidoException;
import lab02.Exceptions.EventoNaoEncontradoException;
import lab02.Exceptions.IngressoEsgotadoException;
import lab02.Exceptions.IngressoNaoEncontradoException;
import lab02.Notificacoes.NotificacaoEmail;
import lab02.Notificacoes.Notificavel;

public class Lab02Test {
    @Test
    public void notificar() {
        Cliente daniel = new Cliente("Daniel Franco", "shaolinMatadorDePorco@gmail.com", "4002-8922");
        Notificavel danielNotificacaoEmail = new NotificacaoEmail(
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

        EventoEmBar eventoBar = javaEventos.criarEvento("SUPER BAR",
        20, LocalDate.of(2025, 12, 14), barzinho.getNome(), "22:00", 2, historico);
        try {
            barzinho.alocarParaEvento(eventoBar);
        } catch (Exception e) {
            System.out.println(e);
        }

        String descricaoEsperada = "Evento no bar: Bar Tolomeu, Happy Hour Inicio: 22:00, Duração: 2";
        String descricaoBar = eventoBar.descricao();

        assertEquals(descricaoEsperada, descricaoBar);
        
    }

    @Test
    public void tratamentoCancelamentoNaoPermitido(){
        Local teatroArena = new Local("Teatro de Arena", 100);

        HistoricoEventos historico = new HistoricoEventos();

        Organizadora javaEventos = new Organizadora("Java Eventos ltda",
        12345678, "Rua que brilha nº123");
        
        /*A regra para que o cancelamento não seja permitido é para quando
         * se tenta cancelar o evento após uma data limite. A data limite é
         * o dia anterior do Evento.
         * Para que o teste funcione, a data do evento está definida como hoje.
         * Assim, como a tentativa de cancelamento vai ser no dia do evento,
         * será lançada a exceção.
         */
        EventoShow showGoogle = javaEventos.criarEvento("Músicas IA",
        150, LocalDate.now(), "Chat Gemini", historico);
        
        try{
            teatroArena.alocarParaEvento(showGoogle);
        } catch (Exception e){}

        Cliente daniel = new Cliente("Daniel Franco", "shaolinMatadorDePorco@gmail.com", "4002-8922");

        Ingresso ingressoShowGoogle = new Ingresso(showGoogle, showGoogle.getPrecoIngresso());

        try{
            showGoogle.venderIngresso(daniel, ingressoShowGoogle);
        } catch (Exception e){}

        String mensagemDeErroEsperada = "A data limite para o cancelamento já foi ultrapassada";
        String mensagemDeErroRecebida = null;

        try {
            daniel.cancelarIngresso(ingressoShowGoogle);
        } catch (CancelamentoNaoPermitidoException e){
            mensagemDeErroRecebida = e.getMessage();
        } catch (IngressoNaoEncontradoException e){
            mensagemDeErroRecebida = e.getMessage();
        }

        assertEquals(mensagemDeErroEsperada, mensagemDeErroRecebida);
    }

    @Test
    public void tratamentoEventoNaoEncontradoUmIngresso(){
        Local teatroArena = new Local("Teatro de Arena", 100);

        HistoricoEventos historico = new HistoricoEventos();

        Organizadora javaEventos = new Organizadora("Java Eventos ltda",
        12345678, "Rua que brilha nº123");
        
        EventoShow showGoogle = javaEventos.criarEvento("Músicas IA",
        150, LocalDate.of(2025, 12, 14), "Chat Gemini", historico);

        EventoShow showLinux = javaEventos.criarEvento("Músicas OS",
        0, LocalDate.of(2025, 12, 15), "Chat Gemini", historico);
        
        try{
            teatroArena.alocarParaEvento(showGoogle);
            teatroArena.alocarParaEvento(showLinux);
        } catch (Exception e){}

        Cliente daniel = new Cliente("Daniel Franco", "shaolinMatadorDePorco@gmail.com", "4002-8922");

        Ingresso ingressoShowGoogle = new Ingresso(showGoogle, showGoogle.getPrecoIngresso());

        String mensagemDeErroEsperada = "O evento do ingresso e o evento fornecido são diferentes: Músicas IA != Músicas OS";
        String mensagemDeErroRecebida = null;
        
        try{
            showLinux.venderIngresso(daniel, ingressoShowGoogle);
        } catch (IngressoEsgotadoException e){
            mensagemDeErroRecebida = e.getMessage();
        } catch (EventoNaoEncontradoException e){
            mensagemDeErroRecebida = e.getMessage();
        }

        assertEquals(mensagemDeErroEsperada, mensagemDeErroRecebida);
    }

    @Test
    public void tratamentoEventoNaoEncontradoListIngressos(){
        Local teatroArena = new Local("Teatro de Arena", 100);

        HistoricoEventos historico = new HistoricoEventos();

        Organizadora javaEventos = new Organizadora("Java Eventos ltda",
        12345678, "Rua que brilha nº123");
        
        EventoShow showGoogle = javaEventos.criarEvento("Músicas IA",
        150, LocalDate.of(2025, 12, 14), "Chat Gemini", historico);

        EventoShow showLinux = javaEventos.criarEvento("Músicas OS",
        0, LocalDate.of(2025, 12, 15), "Chat Gemini", historico);
        
        try{
            teatroArena.alocarParaEvento(showGoogle);
            teatroArena.alocarParaEvento(showLinux);
        } catch (Exception e){}

        Cliente daniel = new Cliente("Daniel Franco", "shaolinMatadorDePorco@gmail.com", "4002-8922");

        Ingresso ingressoShowGoogle = new Ingresso(showGoogle, showGoogle.getPrecoIngresso());
        Ingresso ingressoShowLinux = new Ingresso(showLinux, showLinux.getPrecoIngresso());
        
        List<Ingresso> ingressosEventosDiferentes = new ArrayList<Ingresso>(Arrays.asList(
            ingressoShowGoogle, ingressoShowLinux
        ));

        String mensagemDeErroEsperada = "O evento de algum ingresso e o evento fornecido são diferentes (Nenhum ingresso vendido)";
        String mensagemDeErroRecebida = null;

        try{
            showLinux.venderIngresso(daniel, ingressosEventosDiferentes);
        } catch (IngressoEsgotadoException e){
            mensagemDeErroRecebida = e.getMessage();
        } catch (EventoNaoEncontradoException e){
            mensagemDeErroRecebida = e.getMessage();
        }

        assertEquals(mensagemDeErroEsperada, mensagemDeErroRecebida);
    }
}
