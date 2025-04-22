package lab02.Eventos;

import java.util.ArrayList;
import java.util.List;

import lab02.Filtros.Filtro;

public class HistoricoEventos {
    private List<Evento> eventos;

    /**
     * Construtor que inicializa a lista de eventos.
     */
    public HistoricoEventos(){
        this.eventos = new ArrayList<Evento>();
    }

    /**
     * Adiciona um evento ao histórico.
     *
     * @param evento O evento a ser adicionado.
     */
    public void adicionarEvento(Evento evento){
        this.eventos.add(evento);
    }

    /**
     * Retorna a lista de eventos registrados.
     *
     * @return Lista de eventos.
     */
    public List<Evento> getEventos(){
        return eventos;
    }
    
    public List<Evento> buscarEventos(Filtro filtro){
        List<Evento> eventosFiltrados = filtro.filtrar(this.eventos);
        return eventosFiltrados;
    }
}
