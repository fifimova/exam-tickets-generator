package skypro.course2.examticketsgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skypro.course2.examticketsgenerator.Question;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final Random rand;
    private final List<MathOperation> operations;

    @Autowired
    public MathQuestionService() {
        this.rand = new Random();
        operations = List.of(
                (num1, num2) -> new Question(num1 + "+" + num2, String.valueOf(num1 + num2)),
                (num1, num2) -> new Question(num1 + "-" + num2, String.valueOf(num1 - num2)),
                (num1, num2) -> new Question(num1 + "*" + num2, String.valueOf(num1 * num2)),
                (num1, num2) -> new Question(num1 + "/" + num2, String.valueOf(num1 / num2))
        );
    }

    protected MathQuestionService(Random rand) {
        this.rand = rand;
        operations = List.of(
                (num1, num2) -> new Question(num1 + "+" + num2, String.valueOf(num1 + num2)),
                (num1, num2) -> new Question(num1 + "-" + num2, String.valueOf(num1 - num2)),
                (num1, num2) -> new Question(num1 + "*" + num2, String.valueOf(num1 * num2)),
                (num1, num2) -> new Question(num1 + "/" + num2, String.valueOf(num1 / num2))
        );
    }

    @Override
    public Question add(String question, String answer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Question add(Question question) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Question remove(Question question) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Question getRandomQuestion() {
        Integer randInx = rand.nextInt(operations.size());
        Integer num1 = rand.nextInt(Integer.MAX_VALUE);
        Integer num2 = rand.nextInt(Integer.MAX_VALUE);
        return operations.get(randInx).generateQuestion(num1, num2);
    }
}
