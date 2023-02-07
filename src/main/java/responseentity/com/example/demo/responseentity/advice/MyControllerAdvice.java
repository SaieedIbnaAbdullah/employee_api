package responseentity.com.example.demo.responseentity.advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import responseentity.com.example.demo.responseentity.exception.EmptyInputException;
import responseentity.com.example.demo.responseentity.exception.RecordNotFound;
import responseentity.com.example.demo.responseentity.exception.UnequeEmailException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
        return new ResponseEntity<String>("Empty input", HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(RecordNotFound.class)
     public ResponseEntity<String> handleEmptyList(RecordNotFound recordNotFound){
        return  new ResponseEntity<String>("Record not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UnequeEmailException.class)
    public ResponseEntity<String> handleUniqueEmail(UnequeEmailException unequeEmailException){
        System.out.println("fsgoejh");
        return new ResponseEntity<String>("Eamil already exist", HttpStatus.BAD_REQUEST);
    }
}
