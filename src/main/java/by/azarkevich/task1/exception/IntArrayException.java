package by.azarkevich.task1.exception;

public class IntArrayException extends Exception {
    public IntArrayException() {
        super();
    }
    public IntArrayException(String message) {
        super(message);
    }
    public IntArrayException(Throwable cause) {
        super(cause);
    }
    public IntArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}
