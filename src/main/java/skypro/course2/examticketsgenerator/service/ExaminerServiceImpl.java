package skypro.course2.examticketsgenerator.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.exception.UnsupportedAmountException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private Random rand;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size() || amount < 1) {
            throw new UnsupportedAmountException();
        }
        Set<Question> returnList = new HashSet<>();

        while (returnList.size() < amount) {
            Question random = getMathOrJavaQuestion();
            if (random != null) {
                returnList.add(random);
            }
        }
        return returnList;
    }

    private Question getMathOrJavaQuestion() {
        List<QuestionService> list = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
        QuestionService randService = list.get(rand.nextInt(list.size()));
        return randService.getRandomQuestion();
    }
}
