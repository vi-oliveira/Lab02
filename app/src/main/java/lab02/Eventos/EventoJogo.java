/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */


package lab02.Eventos;

import java.time.LocalDate;
import java.util.List;

import lab02.Local;
import lab02.Organizadora;

public class EventoJogo extends Evento {
        
    private List<String> times;
    /**
    * Construtor da classe EventoEsporte
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    */
    public EventoJogo(String nome, double precoIngresso, Organizadora organizadora, LocalDate data, List<String> times) {
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

    /**
     * Retorna uma string contendo a descri o do Evento, com seu nome, times, local e data
     * @return uma string com a descri o do Evento
     */
    @Override
    public String descricao() {
        if (this.local != null){
            return "Esporte: " + this.nome + " - Times: " + this.times + " - Local: " + this.local.getNome();
        } else {
            return "Esporte: " + this.nome + " - Times: " + this.times + " - Local: Indefinido";
        }
    }
    
    /**
    * Retorna o preço do Ingresso do Evento
    * @return o preço do Ingresso do Evento
    */
    @Override
    public double getPrecoIngresso() {
        return this.precoIngresso;
    }
}
