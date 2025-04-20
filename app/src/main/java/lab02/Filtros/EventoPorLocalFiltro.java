package lab02.Filtros;

import java.util.ArrayList;
import java.util.List;

import lab02.Local;
import lab02.Eventos.Evento;

public class EventoPorLocalFiltro implements Filtro {
    private Local localFiltro;

    public EventoPorLocalFiltro(Local localFiltro){
        this.localFiltro = localFiltro;
    }

    @Override
    public List<Evento> filtrar(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();
        for (Evento evento : eventos){
            if (evento.getLocal() != null && evento.getLocal().equals(this.localFiltro)){
                eventosFiltrados.add(evento);
            }
        }
        return eventosFiltrados;
    }
}
