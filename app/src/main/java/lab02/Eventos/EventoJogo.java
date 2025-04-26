/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */


package lab02.Eventos;

import lab02.Eventos.Caracteristicas.CaracteristicaEventoJogo;

public class EventoJogo extends Evento {
    /**
    * Construtor da classe EventoEsporte
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    */
    public EventoJogo(CaracteristicaEventoJogo caracteristicas) {
        super(caracteristicas);
    }
    
    /**
     * Retorna uma string contendo a descri o do Evento, com seu nome, times, local e data
     * @return uma string com a descri o do Evento
     */
    @Override
    public String descricao() {
        CaracteristicaEventoJogo caracteristicas = (CaracteristicaEventoJogo) super.getCaracteristicas();
        if (caracteristicas.getLocal() != null){
            return "Nome: " + caracteristicas.getNome() + " - Times: " + caracteristicas.getTimes() + " - Local: " + caracteristicas.getLocal().getNome();
        } else {
            return "Nome: " + caracteristicas.getNome() + " - Times: " + caracteristicas.getTimes() + " - Local: Indefinido";
        }
    }
}
