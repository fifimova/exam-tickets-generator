package skypro.course2.examticketsgenerator.service;

import org.springframework.stereotype.Service;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.repository.MathQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {

    private final MathQuestionRepository mathQuestionRepository;
    private Random rand = new Random();

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
        Question question = new Question(null, null);
        int num1 = rand.nextInt(Integer.MAX_VALUE);
        int num2 = rand.nextInt(Integer.MAX_VALUE);
        int answer = 0;

        List<Character> symbols = new ArrayList<>(List.of('+', '-', '*', '/'));
        char randChar = symbols.get(rand.nextInt(symbols.size()));

        String finalQuestion = String.valueOf(num1) + randChar + num2;

        if (randChar == '+') {
            answer = num1 + num2;
            question.setQuestion(finalQuestion);
            question.setAnswer(" = " + answer);
            return question;
        } else if (randChar == '-') {
            answer = num1 - num2;
            question.setQuestion(finalQuestion);
            question.setAnswer(" = " + answer);
            return question;
        } else if (randChar == '*') {
            answer = num1 * num2;
            question.setQuestion(finalQuestion);
            question.setAnswer(" = " + answer);
            return question;
        } else {
            answer = num1 / num2;
            question.setQuestion(finalQuestion);
            question.setAnswer(" = " + answer);
            return question;
        }
    }
}
