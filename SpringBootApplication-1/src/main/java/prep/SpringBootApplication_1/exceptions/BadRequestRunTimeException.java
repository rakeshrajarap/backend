package prep.SpringBootApplication_1.exceptions;

public class BadRequestRunTimeException extends RuntimeException{

    private static final long serialVersionUID = -9079454849611061074L;

    public BadRequestRunTimeException() {
        super();
    }

    public BadRequestRunTimeException(final String message) {
        super(message);
    }

}
