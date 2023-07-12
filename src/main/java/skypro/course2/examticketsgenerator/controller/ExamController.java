package skypro.course2.examticketsgenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/random")
    public Collection<Question> getQuestions(@RequestParam("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
