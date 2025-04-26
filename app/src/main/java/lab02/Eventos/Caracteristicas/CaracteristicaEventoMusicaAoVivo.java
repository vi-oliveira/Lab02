package lab02.Eventos.Caracteristicas;

import java.time.LocalDate;

import lab02.Organizadora;

public class CaracteristicaEventoMusicaAoVivo extends CaracteristicaDeEvento {
    private String nomeDoArtista;
    private String generoMusical;

    public CaracteristicaEventoMusicaAoVivo(String nome, double precoIngresso, Organizadora organizadora, LocalDate data, String nomeDoArtista, String generoMusical) {
        super(nome, precoIngresso, organizadora, data);
        this.nomeDoArtista = nomeDoArtista;
        this.generoMusical = generoMusical;
    }

    public String getNomeDoArtista(){
        return nomeDoArtista;
    }

    public String getGeneroMusical(){
        return generoMusical;
    }
}
