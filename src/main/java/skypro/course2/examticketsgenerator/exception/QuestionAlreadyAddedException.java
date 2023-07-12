package skypro.course2.examticketsgenerator.exception;

public class QuestionAlreadyAddedException extends RuntimeException {
    public QuestionAlreadyAddedException() {
    }

    public QuestionAlreadyAddedException(String message) {
        super(message);
    }
}
