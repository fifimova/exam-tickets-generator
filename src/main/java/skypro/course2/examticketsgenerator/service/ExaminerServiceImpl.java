package skypro.course2.examticketsgenerator.service;

import org.springframework.stereotype.Service;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.exception.AmountOutOfBoundQuestionsStorage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random = new Random();
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new AmountOutOfBoundQuestionsStorage();
        }
        List<Question> list = new ArrayList<>();
        int count = 0;
        while (count <= amount) {
            if (list.contains(questionService.getRandomQuestion())) {
                count--;
            } else {
                list.add(questionService.getRandomQuestion());
                count++;
            }
        }
        return list;
    }
}
