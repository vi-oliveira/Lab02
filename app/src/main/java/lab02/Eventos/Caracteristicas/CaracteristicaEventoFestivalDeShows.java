package lab02.Eventos.Caracteristicas;

import java.util.List;

import lab02.Eventos.EventoShow;

public class CaracteristicaEventoFestivalDeShows {
    private List<EventoShow> shows;
    
    public CaracteristicaEventoFestivalDeShows(List<EventoShow> shows) {
        this.shows = shows;
    } 

    public List<EventoShow> getShows(){
        return shows;
    }
}
