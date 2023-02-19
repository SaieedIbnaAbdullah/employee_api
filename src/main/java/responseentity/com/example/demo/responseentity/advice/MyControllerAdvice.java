package responseentity.com.example.demo.responseentity.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import responseentity.com.example.demo.responseentity.dto.ErrorDto;
import responseentity.com.example.demo.responseentity.errorEnumCodeMessage.ErrorCodeMessageEnum;
import responseentity.com.example.demo.responseentity.exception.CustomEnumException;

@RestControllerAdvice
public class MyControllerAdvice {
    @ExceptionHandler(CustomEnumException.class)
    public ResponseEntity<Object> handleException(CustomEnumException customEnumException) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(String.valueOf(customEnumException.getErrorCodeMessageEnum().getMessage()));
        errorDto.setErrorCode(String.valueOf(customEnumException.getErrorCodeMessageEnum().getCode()));
        return new ResponseEntity(errorDto, HttpStatus.PRECONDITION_FAILED);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDto handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        ErrorDto errorDto = new ErrorDto();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errorMessage = fieldName + ": " + errorMessage;
            errorDto.setErrorCode(ErrorCodeMessageEnum.INVALID_REQUEST.getCode());
            errorDto.setMessage(errorMessage);

        });
        return errorDto;
    }
    
}
