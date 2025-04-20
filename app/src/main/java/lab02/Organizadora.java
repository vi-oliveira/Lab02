package lab02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lab02.Eventos.Evento;
import lab02.Eventos.EventoFestival;
import lab02.Eventos.EventoJogo;
import lab02.Eventos.EventoShow;
import lab02.Filtros.Filtro;

public class Organizadora {

    private String nome;
    private int cnpj;
    private String endereco;
    private List<Evento> eventosOrganizados;

    /**
     * Construtor da classe Organizadora
     * @param nome o nome da organizadora
     * @param cnpj o CNPJ da organizadora
     * @param endereco o endereço da organizadora
     */
    public Organizadora(String nome, int cnpj, String endereco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.eventosOrganizados = new ArrayList<Evento>();
    }

    /**
    * Criador de eventos organizados por esta organizadora
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Evento
    * @param artista o artista do Evento
    * @return o evento criado
    */
    public EventoShow criarEvento(String nome, double precoIngresso, LocalDate data, String artista){
        EventoShow eventoCriado = new EventoShow(nome, precoIngresso, this, data, artista);
        eventosOrganizados.add(eventoCriado);
        return eventoCriado;
    }

    /**
    * Criador de eventos organizados por esta organizadora
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Evento
    * @param lineup o lineup do festival
    * @param duracao a duracao do Evento
    * @return o evento criado
    */
    public EventoFestival criarEvento(String nome, double precoIngresso, LocalDate data, List<String> lineup, int duracao){
        EventoFestival eventoCriado = new EventoFestival(nome, precoIngresso, this, data, lineup, duracao);
        eventosOrganizados.add(eventoCriado);
        return eventoCriado;
    }
    
    /**
    * Criador de eventos organizados por esta organizadora
    * @param nome o nome do Evento
    * @param local o local do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Evento
    * @param times os times do jogo
    * @return o evento criado
    */
    public EventoJogo criarEvento(String nome, double precoIngresso, LocalDate data, List<String> times){
        EventoJogo eventoCriado = new EventoJogo(nome, precoIngresso, this, data, times);
        eventosOrganizados.add(eventoCriado);
        return eventoCriado;
    }

    public List<Evento> buscarEventos(Filtro filtro){
        List<Evento> eventosFiltrados = filtro.filtrar(this.eventosOrganizados);
        return eventosFiltrados;
    }
}
