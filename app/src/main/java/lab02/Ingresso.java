/*
 * Ingresso.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */

package lab02;

import lab02.Eventos.Evento;

/**
 * Contém a estrutura de implementação de um Ingresso.
 */
public class Ingresso {

    private Evento evento;
    private double preco;

    /**
     * Construtor da classe Ingresso
     * @param evento o evento associado ao Ingresso
     * @param preco o preço do Ingresso
     */
    public Ingresso(Evento evento, double preco) {
        this.evento = evento;
        this.preco = preco;
    }

    /**
     * Retorna o preço do Ingresso
     * @return o preço do Ingresso
     */
    public double getPreco() {
        return this.preco;
    }

    /**
     * Retorna o evento associado ao ingresso
     * @return o evento associado ao ingresso
     */
    public Evento getEvento(){
        return evento;
    }

    /**
     * Define o evento associado ao Ingresso
     * @param evento o evento associado ao Ingresso
     */
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
}
