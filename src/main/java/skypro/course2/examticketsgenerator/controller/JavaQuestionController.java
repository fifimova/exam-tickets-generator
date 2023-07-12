package skypro.course2.examticketsgenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question q = new Question(question, answer);
        return questionService.remove(q);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
