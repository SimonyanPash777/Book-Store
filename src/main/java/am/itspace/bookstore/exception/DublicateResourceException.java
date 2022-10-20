package am.itspace.bookstore.exception;

public class DublicateResourceException extends Exception{
    public DublicateResourceException() {
    }

    public DublicateResourceException(String message) {
        super(message);
    }

    public DublicateResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public DublicateResourceException(Throwable cause) {
        super(cause);
    }

    public DublicateResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
