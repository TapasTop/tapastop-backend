package tapastop.exceptions.types;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{

    private String code;
    private String message;
    private HttpStatus status;

    public BadRequestException(String code, String message, HttpStatus status) {
        super();
        this.code = code;
        this.message = message;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
