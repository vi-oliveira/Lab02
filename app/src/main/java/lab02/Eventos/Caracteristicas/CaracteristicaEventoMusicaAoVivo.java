package lab02.Eventos.Caracteristicas;

public class CaracteristicaEventoMusicaAoVivo extends CaracteristicaDeEvento {
    private String nomeDoArtista;
    private String generoMusical;

    public CaracteristicaEventoMusicaAoVivo(String nomeDoArtista, String generoMusical){
        this.nomeDoArtista = nomeDoArtista;
        this.generoMusical = generoMusical;
    }

    public String getNomeDoArtista(){
        return nomeDoArtista;
    }

    public String getGeneroMusical(){
        return generoMusical;
    }

    @Override
    public String descricao(){
        return "Música ao vivo com " + nomeDoArtista + " (" + generoMusical + ")";
    }
}
