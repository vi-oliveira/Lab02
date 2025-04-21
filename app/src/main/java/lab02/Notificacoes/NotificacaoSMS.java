package lab02.Notificacoes;

public class NotificacaoSMS extends Notificacao {

    public NotificacaoSMS(String mensagem){
        super(mensagem);
    }

    public void notificar(){
        System.out.println("SMS: ");
        System.out.println(this.getMensagem());
    }
}
