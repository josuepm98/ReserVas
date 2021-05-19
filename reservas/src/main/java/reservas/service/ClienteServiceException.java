package reservas.service;

public class ClienteServiceException extends RuntimeException{
    public ClienteServiceException(String message) {
        super(message);
    }
}