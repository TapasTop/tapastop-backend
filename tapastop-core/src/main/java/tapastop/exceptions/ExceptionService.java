package tapastop.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tapastop.exceptions.types.BadRequestException;

@ControllerAdvice
public class ExceptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionService.class);

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<TemplateException> handleBadRequestException(BadRequestException ex){
        TemplateException exception = new TemplateException(ex.getCode(), ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(exception, ex.getStatus());
    }
}
