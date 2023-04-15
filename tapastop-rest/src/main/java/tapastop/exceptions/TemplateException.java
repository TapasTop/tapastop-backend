package tapastop.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class TemplateException {

    private String error;
    private String message;
    private HttpStatus status;
    private LocalDate date;

    public TemplateException(String error, String message, HttpStatus status) {
        this.error = error;
        this.message = message;
        this.status = status;
        this.date = LocalDate.now();
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
