package skypro.course2.examticketsgenerator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.repository.JavaQuestionRepository;

import java.util.Collection;
import java.util.Random;

@Service
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;
    private final Random rand;

    @Autowired
    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
        this.rand = new Random();
    }

    protected JavaQuestionService(JavaQuestionRepository javaQuestionRepository, Random rand) {
        this.javaQuestionRepository = javaQuestionRepository;
        this.rand = rand;
    }

    @Override
    public Question add(String question, String answer) {
        return javaQuestionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return javaQuestionRepository.getAll().stream()
                .skip(rand.nextInt(javaQuestionRepository.getAll().size()))
                .findFirst()
                .orElse(null);
    }
}
