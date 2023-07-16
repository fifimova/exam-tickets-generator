package skypro.course2.examticketsgenerator.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.repository.MathQuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        return mathQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return mathQuestionRepository.getAll().stream()
                .skip(new Random().nextInt(mathQuestionRepository.getAll().size()))
                .findFirst()
                .orElse(null);
    }
}
