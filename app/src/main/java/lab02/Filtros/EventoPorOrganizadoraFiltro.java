package lab02.Filtros;

import java.util.ArrayList;
import java.util.List;

import lab02.Organizadora;
import lab02.Eventos.Evento;

public class EventoPorOrganizadoraFiltro implements Filtro {
    private Organizadora organizadoraFiltro;

    public EventoPorOrganizadoraFiltro(Organizadora organizadoraFiltro){
        this.organizadoraFiltro = organizadoraFiltro;
    }

    @Override
    public List<Evento> filtrar(List<Evento> eventos){
        List<Evento> eventosFiltrados = new ArrayList<Evento>();
        for (Evento evento : eventos){
            if (evento.getOrganizadora().equals(this.organizadoraFiltro)){
                eventosFiltrados.add(evento);
            }
        }
        return eventosFiltrados;
    }
}
