package responseentity.com.example.demo.responseentity.exception;

public class EmptyInputException extends RuntimeException{
    private String message;
    public EmptyInputException(String message) {
        super(message);
    }

}
