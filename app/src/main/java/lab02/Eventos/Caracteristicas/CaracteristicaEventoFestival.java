package lab02.Eventos.Caracteristicas;

import java.time.LocalDate;
import java.util.List;

import lab02.Organizadora;

public class CaracteristicaEventoFestival extends CaracteristicaDeEvento {
    private List<String> lineup;
    private int duracao;
    
    public CaracteristicaEventoFestival(String nome, double precoIngresso, Organizadora organizadora, LocalDate data, List<String> lineup, int duracao) {
        super(nome, precoIngresso, organizadora, data);
        this.lineup = lineup;
        this.duracao = duracao;
    } 

    /**
    * Retorna a lista com os nomes dos artistas que se apresentarão no Festival
    * @return a lista com os nomes dos artistas do Festival
    */
    public List<String> getLineup() {
        return this.lineup;
    }
    
    /**
    * Retorna a dura o do Festival em dias
    * @return a dura o do Festival
    */
    public int getDuracao() {
        return this.duracao;
    }
}
