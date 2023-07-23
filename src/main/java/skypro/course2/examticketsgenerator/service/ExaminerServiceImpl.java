package skypro.course2.examticketsgenerator.service;

import org.springframework.stereotype.Service;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.exception.UnsupportedAmountException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final Set<QuestionService> questionServices;

    public ExaminerServiceImpl(Set<QuestionService> questionServices) {
        this.questionServices = questionServices;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 1) {
            throw new UnsupportedAmountException();
        }

        Set<Question> returnList = new HashSet<>();
        while (returnList.size() < amount) {
            for (QuestionService questionService : questionServices) {
                Question randQuestion = questionService.getRandomQuestion();
                returnList.add(randQuestion);
            }
        }
        return returnList;
    }
}
