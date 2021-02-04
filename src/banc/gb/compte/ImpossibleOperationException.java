package banc.gb.compte;

public class ImpossibleOperationException extends Exception{
    public ImpossibleOperationException(String message) {
        super(message);
    }
}
