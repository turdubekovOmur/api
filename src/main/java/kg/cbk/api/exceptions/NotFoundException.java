package kg.cbk.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Something wrong!")
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
