package lab02.Eventos;

import java.time.LocalDate;

import lab02.Organizadora;
import lab02.Eventos.Caracteristicas.CaracteristicaEventoEmBar;

public class EventoEmBar extends Evento {
    private CaracteristicaEventoEmBar caracteristicas;

    public EventoEmBar(String nome, double precoIngresso, Organizadora organizadora,
     LocalDate data, CaracteristicaEventoEmBar caracteristicas){
        super(nome, precoIngresso, organizadora, data);
        this.caracteristicas = caracteristicas;
    }

    public CaracteristicaEventoEmBar getCaracteristicas(){
        return caracteristicas;
    }
}
