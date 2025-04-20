package lab02.Exceptions;

public class IngressoNaoEncontradoException extends Exception {
    public IngressoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
