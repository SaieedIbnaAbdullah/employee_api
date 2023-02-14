package responseentity.com.example.demo.responseentity.errorEnumCodeMessage;

public enum ErrorCodeMessageEnum {
    EMAIL_ALREADY_EXIST("400","Email already exist"),
    RECORD_NOT_FOUND("404", "Record not found");
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
