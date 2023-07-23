package skypro.course2.examticketsgenerator.service;

import skypro.course2.examticketsgenerator.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
