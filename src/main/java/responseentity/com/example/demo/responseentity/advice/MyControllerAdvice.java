package responseentity.com.example.demo.responseentity.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import responseentity.com.example.demo.responseentity.dto.ErrorDto;
import responseentity.com.example.demo.responseentity.exception.EmptyInputException;
import responseentity.com.example.demo.responseentity.exception.RecordNotFound;
import responseentity.com.example.demo.responseentity.exception.UnequeEmailException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<Object> handleEmptyInput(EmptyInputException emptyInputException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Input field empty");
        errorDto.setStatusCode(HttpStatusCode.valueOf(400));
        return ResponseEntity.badRequest().body(errorDto);
    }

    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<Object> handleEmptyList(RecordNotFound recordNotFound) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Not found");
        errorDto.setStatusCode(HttpStatusCode.valueOf(400));
        return ResponseEntity.ok().body(errorDto);
    }

    @ExceptionHandler(UnequeEmailException.class)
    public ResponseEntity<Object> handleUniqueEmailException(UnequeEmailException unequeEmailException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Email already exist");
        errorDto.setStatusCode(HttpStatusCode.valueOf(400));
        return ResponseEntity.badRequest().body(errorDto);
    }
}
