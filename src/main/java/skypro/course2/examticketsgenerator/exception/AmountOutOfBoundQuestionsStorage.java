package skypro.course2.examticketsgenerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountOutOfBoundQuestionsStorage extends RuntimeException {
    public AmountOutOfBoundQuestionsStorage() {
    }

    public AmountOutOfBoundQuestionsStorage(String message) {
        super(message);
    }
}
