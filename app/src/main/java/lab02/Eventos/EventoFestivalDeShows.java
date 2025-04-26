package lab02.Eventos;

import java.util.List;

import lab02.Eventos.Caracteristicas.CaracteristicaEventoFestival;
import lab02.Eventos.Caracteristicas.CaracteristicaEventoFestivalDeShows;

public class EventoFestivalDeShows extends Evento implements Duravel {
    private CaracteristicaEventoFestivalDeShows caracteristicasShows;

    public EventoFestivalDeShows(CaracteristicaEventoFestival caracteristicas, CaracteristicaEventoFestivalDeShows caracteristicasShows){
        super(caracteristicas);
        this.caracteristicasShows = caracteristicasShows;
    }

    /**
    * Retorna a dura o do Festival em dias
    * @return a dura o do Festival
    */
    public int getDuracao() {
        CaracteristicaEventoFestival caracteristicas = (CaracteristicaEventoFestival) super.getCaracteristicas();
        return caracteristicas.getDuracao();
    }

    public List<EventoShow> getShows(){
        return caracteristicasShows.getShows();
    }

    /**
     * Retorna uma string contendo a descri o do Festival, com seu nome, lineup, local e dura o
     * @return uma string com a descri o do Festival
     */
    @Override
    public String descricao() {
        CaracteristicaEventoFestival caracteristicas = (CaracteristicaEventoFestival) super.getCaracteristicas();
        return "Festival: " + caracteristicas.getNome() + " - Lineup: " + caracteristicas.getLineup() + " - Duração: " + caracteristicas.getDuracao() + "Shows: " + caracteristicasShows.getShows();
    }
}
