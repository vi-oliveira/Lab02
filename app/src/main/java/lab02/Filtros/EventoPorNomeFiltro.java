package lab02.Filtros;

import java.util.ArrayList;
import java.util.List;

import lab02.Eventos.Evento;

public class EventoPorNomeFiltro implements Filtro {
    private String nomeFiltro;

    public EventoPorNomeFiltro(String nomeFiltro){
        this.nomeFiltro = nomeFiltro;
    }

    @Override
    public List<Evento> filtrar(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();
        for (Evento evento : eventos){
            if (evento.getNome().equals(this.nomeFiltro)){
                eventosFiltrados.add(evento);
            }
        }
        return eventosFiltrados;
    }
}
