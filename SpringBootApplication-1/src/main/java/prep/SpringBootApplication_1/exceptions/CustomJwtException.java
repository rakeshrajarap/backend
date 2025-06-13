package prep.SpringBootApplication_1.exceptions;

public class CustomJwtException extends Exception{
    public static class InvalidJwtSignatureException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public InvalidJwtSignatureException(String message) {
            super(message);
        }
    }

    public static class InvalidJwtTokenException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public InvalidJwtTokenException(String message) {
            super(message);
        }
    }

    public static class JwtTokenExpiredException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public JwtTokenExpiredException(String message) {
            super(message);
        }
    }

    public static class UnsupportedJwtTokenException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public UnsupportedJwtTokenException(String message) {
            super(message);
        }
    }

    public static class InvalidJwtException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public InvalidJwtException(String message) {
            super(message);
        }
    }

    public static class InvalidCredentialsException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public InvalidCredentialsException(String message) {
            super(message);
        }
    }

    public static class RefreshTokenExpiredException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public RefreshTokenExpiredException(String message) {
            super(message);
        }
    }

    public static class AlternativeAuthenticationException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public AlternativeAuthenticationException(String message) {
            super(message);
        }
    }

    public static class CustomAuthenticationException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public CustomAuthenticationException(String message) {
            super(message);
        }
    }

    public static class JwtTokenException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public JwtTokenException(String message) {
            super(message);
        }
    }
}
