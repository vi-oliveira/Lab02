/*
 * NotificacaoEmail.java
 * 
 * Material usado na disciplina MC322 - Programação orientada a objetos.
 * 
 * A documentação para javadoc deste arquivo foi feita com o uso do
 * ChatGPT e posteriormente revisada e/ou corrigida.
 */
package lab02.Notificacoes;

/**
 * Representa uma notificação do tipo e-mail.
 * 
 * Esta classe estende {@link Notificacao} e inclui um campo adicional para o
 * assunto do e-mail. A notificação é exibida no console com um formato visual
 * simples.
 * 
 * @author Vinícius de Oliveira - 251527
 */
public class NotificacaoEmail extends Notificacao {
    private String assunto;

    /**
     * Construtor da notificação por e-mail.
     *
     * @param mensagem a mensagem do e-mail
     * @param assunto o assunto do e-mail
     */
    public NotificacaoEmail(String mensagem, String assunto){
        super(mensagem);
        this.assunto = assunto;
    }

    /**
     * Retorna o assunto do e-mail.
     * @return o assunto do e-mail
     */
    public String getAssunto(){
        return assunto;
    }

    /**
     * Exibe a notificação formatada no console.
     * 
     * A saída inclui o assunto e a mensagem, com linhas separadoras
     * para facilitar a leitura.
     */
    @Override
    public void notificar(){
        for (int i = 0; i < this.getMensagem().length(); i++)
            System.out.printf("-");
        System.out.printf("\n");

        System.out.println("Assunto: " + this.assunto);

        for (int i = 0; i < this.getMensagem().length(); i++)
            System.out.printf("-");
        System.out.printf("\n");

        System.out.println(this.getMensagem());
    }
}
