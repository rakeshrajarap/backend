package prep.SpringBootApplication_1.exceptions;

public class ResourceNotFoundRunTimeException extends RuntimeException{

    private static final long serialVersionUID = -9079454849611061074L;

    public ResourceNotFoundRunTimeException() {
        super();
    }

    public ResourceNotFoundRunTimeException( String message) {
        super(message);
    }

}
