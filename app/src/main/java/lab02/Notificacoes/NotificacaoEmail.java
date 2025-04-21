package lab02.Notificacoes;

public class NotificacaoEmail extends Notificacao implements Notificavel {
    private String assunto;

    public NotificacaoEmail(String mensagem, String assunto){
        super(mensagem);
        this.assunto = assunto;
    }

    private String getAssunto(){
        return assunto;
    }

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
