package lab02.Eventos.Caracteristicas;

public class CaracteristicaEventoEmBar extends CaracteristicaDeEvento {
    private String nomeDoBar;
    private String inicioHappyHour;
    private int duracaoHappyHour;

    public CaracteristicaEventoEmBar(String nomeDoBar, String inicioHappyHour, int duracaoHappyHour){
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

    @Override
    public String descricao(){
        return "Evento no bar: " + nomeDoBar + ", Happy Hour Inicio: " +
         inicioHappyHour + ", Duração: " + duracaoHappyHour;
    }
}
