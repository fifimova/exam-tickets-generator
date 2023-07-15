package skypro.course2.examticketsgenerator.service;

import org.springframework.stereotype.Service;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.exception.UnsupportedAmountException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;
    private Random random;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount < 1) {
            throw new UnsupportedAmountException();
        }
        Set<Question> returnList = new HashSet<>();

        while (returnList.size() < amount) {
            Question random = questionService.getRandomQuestion();
            returnList.add(random);
        }
        return returnList;
    }
}
