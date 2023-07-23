package skypro.course2.examticketsgenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedAmountException extends RuntimeException {
    public UnsupportedAmountException() {
    }

    public UnsupportedAmountException(String message) {
        super(message);
    }
}
