package skypro.course2.examticketsgenerator.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import skypro.course2.examticketsgenerator.model.Question;
import skypro.course2.examticketsgenerator.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
