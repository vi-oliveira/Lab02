/*
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 */
package lab02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lab02.Exceptions.CancelamentoNaoPermitidoException;
import lab02.Exceptions.IngressoNaoEncontradoException;

public class Cliente {

    private String nome;
    private String email;
    private List<Ingresso> ingressos;

    /**
     * Construtor da classe cliente
     * @param nome o nome do cliente
     * @param email o email do cliente
     */
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.ingressos = new ArrayList<Ingresso>();
    }

    /**
     * Retorna o nome do cliente
     * @return o nome do cliente
     */
    public String getNome(){
        return nome;
    }

    /**
     * Altera o nome do evento para `nome` 
     * @param nome o novo nome do cliente
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o email do cliente
     * @return o email do cliente
     */
    public String getEmail(){
        return email;
    }

    /**
     * Altera o email do cliente para `email` 
     * @param email o novo email do cliente
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Adiciona um ingresso à lista;
     * @param ingressooO ingresso a ser adicionado.
     */
    public void adicionarIngresso(Ingresso ingresso){
        this.ingressos.add(ingresso);
    }
    
    /**
     * Adiciona uma lista ingressos à outra;
     * @param ingressos a lista de ingressos a serem adicionados.
     */
    public void adicionarIngresso(List<Ingresso> ingressos){
        this.ingressos.addAll(ingressos);
    }
    
    /**
     * Remove um ingresso da lista;
     * @param ingresso o ingresso a ser removido.
     */
    public void removerIngresso(Ingresso ingresso){
        this.ingressos.remove(ingresso);
    }

    /**
     * Retorna a lista de ingressos registrados.
     * @return lista de ingressos.
     */
    public List<Ingresso> getIngressos(){
        return ingressos;
    }

    /**
     * Cancela um ingresso comprado
     * Um ingresso só será removido com até 24 horas de antecedência
     * do início do evento. Caso contrário, será lançada uma exceção.
     * @param ingresso o ingresso a ser removido dos ingressos.
     * @throws IngressoNaoEncontradoException Exceção para quando o ingresso não foi comprado pelo cliente
     * @throws CancelamentoNaoPermitidoException Exceção para quando a data limite para o cancelamento do ingresso já foi ultrapassada
     */
    public void cancelarIngresso(Ingresso ingresso) throws IngressoNaoEncontradoException, CancelamentoNaoPermitidoException {
        if (ingressos.contains(ingresso)){
            LocalDate dataLimiteCancelamento = ingresso.getEvento().getData().minusDays(2);
            if (LocalDate.now().isAfter(dataLimiteCancelamento)){
                throw new CancelamentoNaoPermitidoException("A data limite para o cancelamento já foi ultrapassada");
            }
            ingressos.remove(ingresso);
        } else {
            throw new IngressoNaoEncontradoException("O ingresso não foi encontrado");
        }
    }
}