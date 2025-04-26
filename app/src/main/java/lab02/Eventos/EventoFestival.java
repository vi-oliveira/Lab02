/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02.Eventos;

import lab02.Eventos.Caracteristicas.CaracteristicaEventoFestival;

public class EventoFestival extends Evento implements Duravel {     

    /**
    * Construtor da classe EventoFestival
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param dataInicio a data de início do Festival
    * @param dataFim a data de fim do Festival
    */
    public EventoFestival(CaracteristicaEventoFestival caracteristicas) {
        super(caracteristicas);
    }
    
    /**
    * Retorna a dura o do Festival em dias
    * @return a dura o do Festival
    */
    public int getDuracao() {
        CaracteristicaEventoFestival caracteristicas = (CaracteristicaEventoFestival) super.getCaracteristicas();
        return caracteristicas.getDuracao();
    }


    /**
     * Retorna uma string contendo a descri o do Festival, com seu nome, lineup, local e dura o
     * @return uma string com a descri o do Festival
     */
    @Override
    public String descricao() {
        CaracteristicaEventoFestival caracteristicas = (CaracteristicaEventoFestival) super.getCaracteristicas();
        if (caracteristicas.getLocal() != null){
            return "Festival: " + caracteristicas.getNome() + " - Lineup: " + caracteristicas.getLineup() + " - Local: " + caracteristicas.getLocal().getNome() + " - Duração: " + caracteristicas.getDuracao();
        } else {
            return "Festival: " + caracteristicas.getNome() + " - Lineup: " + caracteristicas.getLineup() + " - Local: Indefinido - Duração: " + caracteristicas.getDuracao();
        }
    }
}
