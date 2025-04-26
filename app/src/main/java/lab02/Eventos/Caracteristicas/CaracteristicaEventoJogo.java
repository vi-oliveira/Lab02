package lab02.Eventos.Caracteristicas;

import java.time.LocalDate;
import java.util.List;

import lab02.Organizadora;

public class CaracteristicaEventoJogo extends CaracteristicaDeEvento {
    private List<String> times;

    public CaracteristicaEventoJogo(String nome, double precoIngresso, Organizadora organizadora, LocalDate data, List<String> times) {
        super(nome, precoIngresso, organizadora, data);
        this.times = times;
    }    

    /**
     * Retorna a lista com os nomes dos times que se enfrentam no Evento
     * @return a lista com os nomes dos times do Evento
     */
    public List<String> getTimes() {
        return times;
    }
}
