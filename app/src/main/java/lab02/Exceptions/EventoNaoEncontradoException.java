package lab02.Exceptions;

public class EventoNaoEncontradoException extends Exception {
    public EventoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
