package fcss_dev.uber.email_service.core.exceptions;

public class EmailServiceException extends RuntimeException {

    public EmailServiceException(String message){
        super(message);
    }

    public EmailServiceException(String message, Throwable causa){
        super(message, causa);
    }
}
