package lab02.Exceptions;

public class CancelamentoNaoPermitidoException extends Exception {
    public CancelamentoNaoPermitidoException(String mensagem){
        super(mensagem);
    }
}
