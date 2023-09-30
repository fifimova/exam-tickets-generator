package skypro.course2.examticketsgenerator.repository;

import org.springframework.stereotype.Repository;
import skypro.course2.examticketsgenerator.model.Question;
import skypro.course2.examticketsgenerator.exception.QuestionAlreadyAddedException;
import skypro.course2.examticketsgenerator.exception.QuestionNotFoundException;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {

    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();

    }

    @PostConstruct
    public void init() {
        questions.add(new Question("java", "cool"));
        questions.add(new Question("question", "answer"));
        questions.add(new Question("are you tired?", "for sure.."));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
}
