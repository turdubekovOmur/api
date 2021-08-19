package kg.cbk.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Something wrong!")

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
