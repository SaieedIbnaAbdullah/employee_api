package responseentity.com.example.demo.responseentity.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import responseentity.com.example.demo.responseentity.dto.ErrorDto;
import responseentity.com.example.demo.responseentity.exception.CustomException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleEmptyInput(CustomException emptyInputException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(emptyInputException.getMessage());
        errorDto.setErrorCode(emptyInputException.getHttpStatusCode());
        return ResponseEntity.badRequest().body(errorDto);
    }

}
