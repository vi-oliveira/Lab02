/*

 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02.Eventos;

import java.time.LocalDate;

import lab02.Local;
import lab02.Organizadora;

public class EventoShow extends Evento {
        
    private String artista;
    
    /**
    * Construtor da classe EventocShow
    * @param nome o nome do Evento
    * @param precoIngresso o preço do Ingresso do Evento
    * @param organizadora a organizadora do Evento
    * @param data a data do Evento
    * @param artista o artista do Evento
    */
    public EventoShow(String nome, double precoIngresso, Organizadora organizadora, LocalDate data, String artista) {
        super(nome, precoIngresso, organizadora, data);
        this.artista = artista;
    }

    /**
    * Retorna a descrição do Evento
    * @return a descrição do Evento
    */
    public String getDescricao() {
        if (this.local != null){
            return "Show: " + this.nome + " - Artista: " + this.artista  + " - Local: " + this.local.getNome() + " - Data: " + this.data;
        } else {
            return "Show: " + this.nome + " - Artista: " + this.artista  + " - Local: Indefinido - Data: " + this.data;
        }
    }
    
    /**
    * Retorna o preço do Ingresso do Evento
    * @return o preço do Ingresso do Evento
    */
    public double getPrecoIngresso() {
        return this.precoIngresso;
    }
}
