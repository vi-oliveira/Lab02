/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 * 
 * O atributo data foi alterado de String para LocalDate para que seja possível
 * analisar mais facilmente se o local estará disponível para ser alocado para o
 * evento na data ou, principalmente, nas datas em que determinado evento ocorre.
 * 
 * Para criar um objeto de algum tipo de evento, não é mais necessário fornecer o local,
 * visto que ele será alocado para o evento posteriormente. Pela implementação original,
 * o local na criação do evento, agora a relação entre os dois objetos se dá no caso da
 * disponibilidade do local na data do evento.
 */

package lab02.Eventos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lab02.Ingresso;
import lab02.Local;
import lab02.Organizadora;
import lab02.Clientes.Cliente;
import lab02.Exceptions.IngressoEsgotadoException;

public abstract class Evento {
    protected String nome;
    protected Local local;
    protected double precoIngresso; // preço base do ingresso
    protected Organizadora organizadora;
    protected LocalDate data;
    private List<Ingresso> ingressosVendidos;

    /**
     * Construtor da classe Evento
     * @param nome o nome do Evento
     * @param precoIngresso o preço do Ingresso do Evento
     * @param organizadora a organizadora do Evento
     * @param data a data do Evento
     */
    public Evento(String nome, double precoIngresso, Organizadora organizadora, LocalDate data) {
        this.nome = nome;
        this.local = null;
        this.precoIngresso = precoIngresso; // modificar para representar o preço base do ingresso
        this.organizadora = organizadora;
        this.data = data;
        this.ingressosVendidos = new ArrayList<Ingresso>();
    }

    /**
     * Retorna o nome do Evento
     * @return o nome do Evento
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do Evento para `nome` 
     * @param nome o novo nome do Evento
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o Local do Evento
     * @return o local do Evento
     */
    public Local getLocal() {
        return local;
    }

    /**
     * Altera o local do Evento para `local` 
     * @param local o novo local do Evento
     */
    public void setLocal(Local local) {
        this.local = local;
    }

    /**
     * Retorna o preço do ingresso do Evento
     * @return o precoIngresso do Evento
     */
    public double getPrecoIngresso(){
        return this.precoIngresso;
    }

    /**
     * Altera o precoIngresso do Evento para `precoIngresso` 
     * @param precoIngresso o novo precoIngresso do Evento
     */
    public void setPrecoIngresso(double precoIngresso){
        this.precoIngresso = precoIngresso;
    }

    public String descricao(){
        return "Evento: " + this.nome + " - Local: " + this.local;
    }

    /**
     * Retorna a data do Evento
     * @return a data do Evento
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Retorna a lista de ingressos vendidos
     * @return a a lista de ingressos vendidos
     */
    public List<Ingresso> getIngressosVendidos(){
        return ingressosVendidos;
    }

    /**
     * Retorna a organizadora do Evento
     * @return a organizadora do Evento
     */
    public Organizadora getOrganizadora(){
        return this.organizadora;
    }

    /**
     * Adiciona um novo ingresso à lista de ingressos vendidos
     * @param ingresso o ingresso que foi vendido
     * @param cliente o cliente que comprou o ingresso
     * @throws IngressoEsgotadoException se a capacidade máxima do local do evento for atingida,
     * é lançado o erro de ingresso esgotado
     */
    public void venderIngresso(Cliente cliente, Ingresso ingresso) throws IngressoEsgotadoException {
        if (this.local.getCapacidade() == ingressosVendidos.size()){
            throw new IngressoEsgotadoException("Os ingressos esgotaram");
        }
        this.ingressosVendidos.add(ingresso);
        cliente.adicionarIngresso(ingresso);
    }
}