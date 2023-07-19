package skypro.course2.examticketsgenerator.service;

import org.springframework.web.server.MethodNotAllowedException;
import skypro.course2.examticketsgenerator.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer) throws MethodNotAllowedException;

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}

