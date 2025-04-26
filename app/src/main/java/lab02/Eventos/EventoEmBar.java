package lab02.Eventos;

import lab02.Eventos.Caracteristicas.CaracteristicaEventoEmBar;

public class EventoEmBar extends Evento {
    public EventoEmBar(CaracteristicaEventoEmBar caracteristicas){
        super(caracteristicas);
    }

    @Override
    public String descricao(){
        CaracteristicaEventoEmBar caracteristicas = (CaracteristicaEventoEmBar) super.getCaracteristicas();
        return "Evento no bar: " + caracteristicas.getNomeDoBar() + ", Happy Hour Inicio: " +
         caracteristicas.getInicioHappyHour() + ", Duração: " + caracteristicas.getDuracaoHappyHour();
    }
}
