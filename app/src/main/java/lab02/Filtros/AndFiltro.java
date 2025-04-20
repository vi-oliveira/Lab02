package lab02.Filtros;

import java.util.List;

import lab02.Eventos.Evento;

public class AndFiltro implements Filtro {
    private List<Filtro> filtros;
    
    public AndFiltro(List<Filtro> filtros){
        this.filtros = filtros;
    }

    /**  A cada iteração nos filtros, apenas os eventos que
     *  atendem aos critérios de cada filtro continua armazenado
    */
    @Override
    public List<Evento> filtrar(List<Evento> eventos){
        List<Evento> eventosFiltrados = eventos;
        for (Filtro filtro : this.filtros){
            eventosFiltrados = filtro.filtrar(eventosFiltrados);
        }
        return eventosFiltrados;
    }
}
