package prep.SpringBootApplication_1.exceptions;

public class TokenExpiredException extends  Exception{


    private static final long serialVersionUID = 1L;

    public TokenExpiredException() {
        super();
    }

    public TokenExpiredException(String message) {
        super(message);
    }

}
