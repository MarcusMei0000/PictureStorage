package exception;

public class AlreadyExistsException extends LogicException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
