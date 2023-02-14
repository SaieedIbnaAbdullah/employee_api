package responseentity.com.example.demo.responseentity.errorEnumCodeMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public enum ErrorCodeMessageEnum {
    EMAIL_ALREADY_EXIST("400","Email already exist"),
    RECORD_NOT_FOUND("404", "Record not found"),
    EMAIL_REQUIRED("400", "Email required"),
    NAME_REQUIRED("400", "Name required"),
    AGE_REQUIRED("400", "Age required");
    private final String code;
    private final String message;

    ErrorCodeMessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
