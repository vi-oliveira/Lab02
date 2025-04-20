package lab02.Filtros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lab02.Eventos.Evento;

public class EventoPorDataFiltro implements Filtro {
    private LocalDate dataFiltro;

    public EventoPorDataFiltro(LocalDate dataFiltro){
        this.dataFiltro = dataFiltro;
    }

    @Override
    public List<Evento> filtrar(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();
        for (Evento evento : eventos){
            if (evento.getData().equals(this.dataFiltro)){
                eventosFiltrados.add(evento);
            }
        }
        return eventosFiltrados;
    }
}
