/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lab02.Eventos.EventoFestival;
import lab02.Eventos.EventoJogo;
import lab02.Eventos.EventoShow;
import lab02.Eventos.ImobiliariaDeEventos;
import lab02.Exceptions.CancelamentoNaoPermitidoException;
import lab02.Exceptions.CapacidadeInsuficienteException;
import lab02.Exceptions.IngressoNaoEncontradoException;
import lab02.Exceptions.LocalIndisponivelException;
import lab02.Exceptions.LocalNaoEncontradoException;

/**
 * Contém a estrutura de implementação da aplicação.
 * 
 * @author Vinícius de Oliveira - 251527
 */
public class App {

    /**
     * Aplicação principal
     * @param args
     */
    public static void main(String[] args) {

        /*
        // Desenvolvimento de Cenário de Uso

        // Criação de ingressos, locais e organizadora que serão usados nos exemplos de uso:
        Local teatroArena = new Local("Teatro de Arena", 100);
        Local ibirapuera = new Local("Ibirapuera", 300);
        Local teatroMunicipal = new Local("Teatro Municipal de São Paulo", 400);
        
        Organizadora superEventos = new Organizadora("Super Eventos",
        12345678, "Rua Adalberto Einstein nº321");

        // Eventos para exemplos:
        EventoShow showAzul = superEventos.criarEvento("Caneta Azul", teatroArena,
        200, LocalDate.of(2025, 4, 29), "Manoel Gomes");
        EventoShow show2 = superEventos.criarEvento("Biridin", teatroArena,
        400, LocalDate.of(2025,12, 15), "Michael Jackson");

        // Ingressos para exemplos:
        Ingresso ingresso1 = new Ingresso(showAzul, showAzul.getPrecoIngresso());
        Ingresso ingresso2 = new Ingresso(show2, show2.getPrecoIngresso());


        // DEMONSTRAÇÃO PASSO 1:
        System.out.println("DEMONSTRAÇÃO DO CLIENTE:");
        Cliente Alonso = new Cliente("Alonso", "Alonso@gmail.com");
        Alonso.adicionarIngresso(ingresso1);
        Alonso.adicionarIngresso(ingresso2);

        System.out.println("Ingressos antes: " + Alonso.getIngressos());
        Alonso.removerIngresso(ingresso2);
        System.out.println("Ingressos depois: " + Alonso.getIngressos());


        // DEMONSTRAÇÃO PASSO 2:
        System.out.println("\nDEMONSTRAÇÃO DA SOBRECARGA:");
        
        // Criação de eventos (EventoShow já criado no passo 1): 
        List<String> lineupFestival = new ArrayList<String>();
        lineupFestival.add("lineup1");
        EventoFestival eventoFestival = superEventos.criarEvento("Festival",
        teatroArena, 20, LocalDate.of(2025, 9, 14), lineupFestival, 4);

        List<String> times = new ArrayList<String>();
        times.add("time1");
        times.add("time2");
        EventoJogo eventoJogo = superEventos.criarEvento("Campeonato",
        teatroArena, 950, LocalDate.of(2026, 2, 20), lineupFestival);

        // Sobrecarga nos ingressos dos clientes:
        Cliente Ana = new Cliente("Ana", "anana@unicamp.com");
        Ingresso ingresso3 = new Ingresso(showAzul, showAzul.getPrecoIngresso());
        Ingresso ingressoFest = new Ingresso(eventoFestival, eventoFestival.getPrecoIngresso());
        Ingresso ingressoJogo = new Ingresso(eventoJogo, eventoJogo.getPrecoIngresso());
        List<Ingresso> ingressos = new ArrayList<Ingresso>();
        ingressos.add(ingressoFest);
        ingressos.add(ingressoJogo);

        Ana.adicionarIngresso(ingresso3);
        Ana.adicionarIngresso(ingressos);

        System.out.println("Ingressos sobrecarga: ");
        System.out.println(Ana.getIngressos());

        // Sobrecarga na busca por locais:

        ImobiliariaDeEventos imobiliaria = new ImobiliariaDeEventos("ImobiVentos");
        imobiliaria.adicionarLocal(teatroArena);
        imobiliaria.adicionarLocal(ibirapuera);
        imobiliaria.adicionarLocal(teatroMunicipal);

        System.out.println("Busca de locais:");
        try {
            Local localEncontrado = imobiliaria.buscarLocal("Ibirapuera");
            System.out.println("Local por nome: " + localEncontrado.getNome());
        } catch (LocalNaoEncontradoException eMessage) {
            System.out.println("Nenhum local encontrado");
        }

        try {
            List<Local> locaisEncontrados = imobiliaria.buscarLocal(200);
            System.out.printf("Local por capacidade: ");
            for (Local local : locaisEncontrados){
                System.out.printf(local.getNome() + "; ");
            }
        } catch (LocalNaoEncontradoException eMessage) {
            System.out.println("Nenhum local encontrado");
        } */
        Local teatroArena = new Local("Teatro de Arena", 100);
        List<String> lineupFestival = new ArrayList<String>();
        lineupFestival.add("lineup1");
        Organizadora superEventos = new Organizadora("Super Eventos",
        12345678, "Rua Adalberto Einstein nº321");

        EventoFestival eventoFestival = superEventos.criarEvento("Festival",
        20, LocalDate.of(2025, 9, 14), lineupFestival, 1);

        EventoShow eventoShow = superEventos.criarEvento("show", 20, LocalDate.of(2025, 9, 16), "Manoel Gomes");

        try{
            teatroArena.alocarParaEvento(eventoFestival);
        } catch (CapacidadeInsuficienteException e) {
            System.out.println("sem espaço");
        } catch (LocalIndisponivelException e){
            System.out.println("indisponivel");
        }

        try{
            teatroArena.alocarParaEvento(eventoShow);
        } catch (CapacidadeInsuficienteException e) {
            System.out.println("sem espaço 2");
        } catch (LocalIndisponivelException e){
            System.out.println("indisponivel 2");
        }

        EventoShow eventoShow2 = superEventos.criarEvento("2", 20, LocalDate.of(2025, 4, 21), "Manoel Gomes");
        Cliente Ana = new Cliente("Ana", "anana@unicamp.com");
        Ingresso ingresso3 = new Ingresso(eventoShow2, eventoShow2.getPrecoIngresso());
        Ana.adicionarIngresso(ingresso3);
        try{
            Ana.cancelarIngresso(ingresso3);
        } catch (CancelamentoNaoPermitidoException e){
            System.out.println(e);
        } catch (IngressoNaoEncontradoException e){
            System.out.println(e);
        }
    }
}
