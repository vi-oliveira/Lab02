package lab02.Eventos.Caracteristicas;

import java.time.LocalDate;

import lab02.Organizadora;

public class CaracteristicaEventoEmBar extends CaracteristicaDeEvento {
    private String nomeDoBar;
    private String inicioHappyHour;
    private int duracaoHappyHour;

    public CaracteristicaEventoEmBar(String nome, double precoIngresso, Organizadora organizadora,
     LocalDate data, String nomeDoBar, String inicioHappyHour, int duracaoHappyHour){
        super(nome, precoIngresso, organizadora, data);
        this.nomeDoBar = nomeDoBar;
        this.inicioHappyHour = inicioHappyHour;
        this.duracaoHappyHour = duracaoHappyHour;
    }

    public String getNomeDoBar(){
        return nomeDoBar;
    }

    public String getInicioHappyHour(){
        return inicioHappyHour;
    }

    public int getDuracaoHappyHour(){
        return duracaoHappyHour;
    }
}
