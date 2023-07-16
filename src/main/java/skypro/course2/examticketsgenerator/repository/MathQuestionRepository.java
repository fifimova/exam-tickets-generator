package skypro.course2.examticketsgenerator.repository;

import org.springframework.stereotype.Repository;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.exception.QuestionAlreadyAddedException;
import skypro.course2.examticketsgenerator.exception.QuestionNotFoundException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> mathQuestions;

    public MathQuestionRepository() {
        this.mathQuestions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        mathQuestions.add(new Question("math", ":("));
        mathQuestions.add(new Question("question", "answer"));
        mathQuestions.add(new Question("5 + 5", "10"));
    }

    @Override
    public Question add(Question question) {
        if (mathQuestions.contains(question)) {
            throw new QuestionAlreadyAddedException();
        }
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (mathQuestions.contains(question)) {
            mathQuestions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(mathQuestions);
    }
}
