package lab02.Filtros;

import java.util.ArrayList;
import java.util.List;

import lab02.Eventos.Evento;

public class EventoPorTipoFiltro implements Filtro {
    private Class<?> tipoFiltro;

    public EventoPorTipoFiltro(Class<?> tipoFiltro){
        this.tipoFiltro = tipoFiltro;
    }

    @Override
    public List<Evento> filtrar(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();
        for (Evento evento : eventos){
            if (evento.getClass().equals(this.tipoFiltro)){
                eventosFiltrados.add(evento);
            }
        }
        return eventosFiltrados;
    }
}
