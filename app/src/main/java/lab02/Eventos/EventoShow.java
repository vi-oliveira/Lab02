/*

 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02.Eventos;

import lab02.Eventos.Caracteristicas.CaracteristicaEventoShow;

public class EventoShow extends Evento {
    /**
    * Construtor da classe EventocShow
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param organizadora a organizadora do Evento
    * @param data a data do Evento
    * @param artista o artista do Evento
    */
    public EventoShow(CaracteristicaEventoShow caracteristicas) {
        super(caracteristicas);
    }

    /**
    * Retorna a descrição do Evento
    * @return a descrição do Evento
    */
    @Override
    public String descricao() {
        CaracteristicaEventoShow caracteristicas = (CaracteristicaEventoShow) super.getCaracteristicas();
        if (caracteristicas.getLocal() != null){
            return "Show: " + caracteristicas.getNome() + " - Artista: " + caracteristicas.getArtista()  + " - Local: " + caracteristicas.getLocal().getNome() + " - Data: " + caracteristicas.getData();
        } else {
            return "Show: " + caracteristicas.getNome() + " - Artista: " + caracteristicas.getArtista()  + " - Local: Indefinido - Data: " + caracteristicas.getData();
        }
    }
}
