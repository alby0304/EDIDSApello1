package myAdapter;

public class UnsupportedOperationException extends RuntimeException {
    // Costruttore senza argomenti
    public UnsupportedOperationException() {
        super();
    }

    // Costruttore che accetta un messaggio di errore
    public UnsupportedOperationException(String message) {
        super(message);
    }

    // Costruttore che accetta un messaggio di errore e una causa
    public UnsupportedOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    // Costruttore che accetta una causa
    public UnsupportedOperationException(Throwable cause) {
        super(cause);
    }
}