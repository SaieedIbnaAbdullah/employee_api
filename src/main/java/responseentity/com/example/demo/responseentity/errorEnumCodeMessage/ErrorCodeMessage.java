package responseentity.com.example.demo.responseentity.errorEnumCodeMessage;

public enum ErrorCodeMessage {
    EMAIL_ALREADY_EXIST(400,"Email already exist"),
    RECORD_NOT_FOUND(404, "Record not found"),
    EMAIL_REQUIRED(400, "Email required"),
    NAME_REQUIRED(400, "Name required"),
    AGE_REQUIRED(400, "Age required");
    private final int code;
    private final String message;

    ErrorCodeMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
