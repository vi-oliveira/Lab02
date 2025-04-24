/*
 * NotificacaoSMS.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 * 
 * A documentação para javadoc deste arquivo foi feita com o uso do
 * ChatGPT e posteriormente revisada e/ou corrigida.
 */
package lab02.Notificacoes;

/**
 * Representa uma notificação do tipo SMS.
 * 
 * Esta classe estende {@link Notificacao} e implementa o método {@code notificar}
 * para exibir a mensagem formatada como um SMS no console.
 * 
 * @author Vinícius de Oliveira - 251527
 */
public class NotificacaoSMS extends Notificacao {

    /**
     * Construtor da notificação por SMS.
     *
     * @param mensagem a mensagem do SMS
     */
    public NotificacaoSMS(String mensagem){
        super(mensagem);
    }

    /**
     * Exibe a notificação de SMS no console.
     * 
     * A saída inclui um prefixo indicando que se trata de um SMS,
     * seguido da mensagem.
     */
    @Override
    public void notificar(){
        System.out.println("SMS: ");
        System.out.println(this.getMensagem());
    }
}
