package lab02.Eventos;

import java.time.LocalDate;

import lab02.Organizadora;
import lab02.Eventos.Caracteristicas.CaracteristicaEventoMusicaAoVivo;

public class EventoMusicaAoVivo extends Evento {
    private CaracteristicaEventoMusicaAoVivo caracteristicas;
    
    public EventoMusicaAoVivo(String nome, double precoIngresso, Organizadora organizadora,
     LocalDate data, CaracteristicaEventoMusicaAoVivo caracteristicas){
        super(nome, precoIngresso, organizadora, data);
        this.caracteristicas = caracteristicas;
    }

    public CaracteristicaEventoMusicaAoVivo getCaracteristicas(){
        return caracteristicas;
    }
}
