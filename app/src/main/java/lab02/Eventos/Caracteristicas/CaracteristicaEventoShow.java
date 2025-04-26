package lab02.Eventos.Caracteristicas;

import java.time.LocalDate;

import lab02.Organizadora;

public class CaracteristicaEventoShow extends CaracteristicaDeEvento {
    private String artista;
    
    public CaracteristicaEventoShow(String nome, double precoIngresso, Organizadora organizadora, LocalDate data, String artista) {
        super(nome, precoIngresso, organizadora, data);
        this.artista = artista;
    }    

    public String getArtista(){
        return artista;
    }
}
