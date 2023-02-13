package responseentity.com.example.demo.responseentity.exception;

import lombok.Data;
import lombok.Getter;

@Data
public class CustomException extends RuntimeException{
    private String message;
    private String httpStatusCode;
    public CustomException(String message) {
        this.message = message;
    }
    public CustomException(String message, String httpStatusCode) {
        this.message = message;
        this.httpStatusCode = httpStatusCode;
    }

}
