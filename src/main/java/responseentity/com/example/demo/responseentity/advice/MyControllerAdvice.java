package responseentity.com.example.demo.responseentity.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import responseentity.com.example.demo.responseentity.dto.ErrorDto;
import responseentity.com.example.demo.responseentity.exception.CustomException;
import responseentity.com.example.demo.responseentity.exception.CustomEnumException;

@ControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(CustomEnumException.class)
    public ResponseEntity<Object> handleEmptyInput(CustomEnumException customEnumException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(String.valueOf(customEnumException.getErrorCodeMessageEnum().getMessage()));
        errorDto.setErrorCode(String.valueOf(customEnumException.getErrorCodeMessageEnum().getCode()));
        return ResponseEntity.badRequest().body(errorDto);
    }

}
