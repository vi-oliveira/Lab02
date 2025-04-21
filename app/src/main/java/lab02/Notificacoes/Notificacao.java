package lab02.Notificacoes;

public abstract class Notificacao implements Notificavel {
    private String mensagem;

    public Notificacao(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem(){
        return mensagem;
    }

    public void setMensagem(String novaMensagem){
        this.mensagem = novaMensagem;
    }

    public abstract void notificar();
}
