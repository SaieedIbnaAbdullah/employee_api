package responseentity.com.example.demo.responseentity.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import responseentity.com.example.demo.responseentity.dto.ErrorDto;
import responseentity.com.example.demo.responseentity.exception.CustomEnumException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(CustomEnumException.class)
    public ResponseEntity<Object> handleException(CustomEnumException customEnumException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(String.valueOf(customEnumException.getErrorCodeMessageEnum().getMessage()));
        errorDto.setErrorCode(String.valueOf(customEnumException.getErrorCodeMessageEnum().getCode()));
        return new ResponseEntity(errorDto, HttpStatus.PRECONDITION_FAILED);
    }

}
