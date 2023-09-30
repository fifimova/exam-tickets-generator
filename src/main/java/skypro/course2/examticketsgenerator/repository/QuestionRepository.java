package skypro.course2.examticketsgenerator.repository;

import skypro.course2.examticketsgenerator.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
