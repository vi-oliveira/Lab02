/*
 * Notificacao.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 * 
 * A documentação para javadoc deste arquivo foi feita com o uso do
 * ChatGPT e posteriormente revisada e/ou corrigida.
 */
package lab02.Notificacoes;

/**
 * Classe abstrata que representa uma notificação genérica.
 * 
 * Serve como base para diferentes tipos de notificações (ex: e-mail, SMS, etc.)
 * que implementam o método {@code notificar}. Armazena uma mensagem que pode ser
 * acessada e modificada.
 * 
 * Esta classe implementa a interface {@link Notificavel}.
 * 
 * @author Vinícius de Oliveira - 251527
 */
public abstract class Notificacao implements Notificavel {
    private String mensagem;

    /**
     * Construtor da notificação.
     *
     * @param mensagem a mensagem a ser associada à notificação
     */
    public Notificacao(String mensagem){
        this.mensagem = mensagem;
    }

    /**
     * Retorna a mensagem da notificação.
     * @return a mensagem da notificação
     */
    public String getMensagem(){
        return mensagem;
    }

    /**
     * Define uma nova mensagem para a notificação.
     * @param novaMensagem a nova mensagem a ser definida
     */
    public void setMensagem(String novaMensagem){
        this.mensagem = novaMensagem;
    }

    /**
     * Executa o processo de notificação.
     * 
     * Este método deve ser implementado pelas subclasses que definem
     * a forma específica de notificação.
     */
    public abstract void notificar();
}
