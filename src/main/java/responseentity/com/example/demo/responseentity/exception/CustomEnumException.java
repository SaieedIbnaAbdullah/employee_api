package responseentity.com.example.demo.responseentity.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import responseentity.com.example.demo.responseentity.errorEnumCodeMessage.ErrorCodeMessageEnum;

@Getter
@Setter


public class CustomEnumException extends RuntimeException{
    ErrorCodeMessageEnum errorCodeMessageEnum;
    public CustomEnumException(ErrorCodeMessageEnum errorCodeMessageEnum){
        this.errorCodeMessageEnum = errorCodeMessageEnum;
    }
}
