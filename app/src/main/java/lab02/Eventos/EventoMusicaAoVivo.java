package lab02.Eventos;

import lab02.Eventos.Caracteristicas.CaracteristicaEventoMusicaAoVivo;

public class EventoMusicaAoVivo extends Evento {    
    public EventoMusicaAoVivo(CaracteristicaEventoMusicaAoVivo caracteristicas){
        super(caracteristicas);
    }

    @Override
    public String descricao(){
        CaracteristicaEventoMusicaAoVivo caracteristicas = (CaracteristicaEventoMusicaAoVivo) super.getCaracteristicas();
        return "Música ao vivo com " + caracteristicas.getNomeDoArtista() + " (" + caracteristicas.getGeneroMusical() + ")";
    }
}
