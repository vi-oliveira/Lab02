/*
 * Organizadora.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lab02.Eventos.Evento;
import lab02.Eventos.EventoEmBar;
import lab02.Eventos.EventoFestival;
import lab02.Eventos.EventoJogo;
import lab02.Eventos.EventoMusicaAoVivo;
import lab02.Eventos.EventoShow;
import lab02.Eventos.HistoricoEventos;
import lab02.Eventos.Caracteristicas.CaracteristicaEventoEmBar;
import lab02.Eventos.Caracteristicas.CaracteristicaEventoMusicaAoVivo;

/**
 * Contém a estrutura de implementação de uma organizadora.
 * 
 * @author Vinícius de Oliveira - 251527
 */
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
     * Retorna o nome da organizadora
     * @return o nome da organizadora
     */
    public String getNome(){
        return nome;
    }

    /**
     * Retorna o CNPJ da organizadora
     * @return o CNPJ da organizadora
     */
    public int getCnpj(){
        return cnpj;
    }

    /**
     * Retorna o endereço da organizadora
     * @return o endereço da organizadora
     */
    public String getEndereco(){
        return endereco;
    }

    /**
     * Retorna os eventos organizados pela organizadora
     * @return os eventos organizados pela organizadora
     */
    public List<Evento> getEventosOrganizados(){
        return eventosOrganizados;
    }

    /**
    * Criador de eventos organizados por esta organizadora
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Evento
    * @param artista o artista do Evento
    * @param historico o historico que contém todos os eventos
    * @return o evento criado
    */
    public EventoShow criarEvento(String nome, double precoIngresso,
    LocalDate data, String artista, HistoricoEventos historico){
        EventoShow eventoCriado = new EventoShow(nome, precoIngresso, this, data, artista);
        eventosOrganizados.add(eventoCriado);
        historico.adicionarEvento(eventoCriado);
        return eventoCriado;
    }

    /**
    * Criador de eventos organizados por esta organizadora
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Evento
    * @param lineup o lineup do festival
    * @param duracao a duracao do Evento
    * @param historico o historico que contém todos os eventos
    * @return o evento criado
    */
    public EventoFestival criarEvento(String nome, double precoIngresso,
    LocalDate data, List<String> lineup, int duracao, HistoricoEventos historico){
        EventoFestival eventoCriado = new EventoFestival(nome, precoIngresso, this, data, lineup, duracao);
        eventosOrganizados.add(eventoCriado);
        historico.adicionarEvento(eventoCriado);
        return eventoCriado;
    }
    
    /**
    * Criador de eventos organizados por esta organizadora
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Evento
    * @param times os times do jogo
    * @param historico o historico que contém todos os eventos
    * @return o evento criado
    */
    public EventoJogo criarEvento(String nome, double precoIngresso,
    LocalDate data, List<String> times,HistoricoEventos historico){
        EventoJogo eventoCriado = new EventoJogo(nome, precoIngresso, this, data, times);
        eventosOrganizados.add(eventoCriado);
        historico.adicionarEvento(eventoCriado);
        return eventoCriado;
    }
    
    /**
    * Criador de eventos organizados por esta organizadora
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Evento
    * @param caracteristicas as caracteriticas de um EventoEmBar
    * @param historico o historico que contém todos os eventos
    * @return o evento criado
    */
    public EventoEmBar criarEvento(String nome, double precoIngresso,
    LocalDate data, CaracteristicaEventoEmBar caracteristicas, HistoricoEventos historico){
        EventoEmBar eventoCriado = new EventoEmBar(nome, precoIngresso, this, data, caracteristicas);
        eventosOrganizados.add(eventoCriado);
        historico.adicionarEvento(eventoCriado);
        return eventoCriado;
    }

    /**
    * Criador de eventos organizados por esta organizadora
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param data a data do Evento
    * @param caracteristicas as caracteriticas de um EventoMusicaAoVivo
    * @param historico o historico que contém todos os eventos
    * @return o evento criado
    */
    public EventoMusicaAoVivo criarEvento(String nome, double precoIngresso,
    LocalDate data, CaracteristicaEventoMusicaAoVivo caracteristicas, HistoricoEventos historico){
        EventoMusicaAoVivo eventoCriado = new EventoMusicaAoVivo(nome, precoIngresso, this, data, caracteristicas);
        eventosOrganizados.add(eventoCriado);
        historico.adicionarEvento(eventoCriado);
        return eventoCriado;
    }
}
