package skypro.course2.examticketsgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.exception.UnsupportedAmountException;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;
    private ExaminerService out;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        out = new ExaminerServiceImpl(questionService);
    }

    @Test
    void shouldThrowExceptionIfAmountMoreThenQuestions() {
        when(questionService.getAll()).thenReturn(generateQuestions());
        assertThrows(UnsupportedAmountException.class, () -> out.getQuestions(10));
    }


    @Test
    void shouldReturnListOfUniqueRandomQuestions() {
        Question q1 = new Question("a", "a");
        Question q2 = new Question("b", "b");
        Question q3 = new Question("c", "c");

        when(questionService.getRandomQuestion())
                .thenReturn(q1)
                .thenReturn(q2)
                .thenReturn(q3);

        when(questionService.getAll()).thenReturn(generateQuestions());

        Collection<Question> collection = out.getQuestions(3);
        assertEquals(3, collection.size());
        assertTrue(collection.contains(q1));
        assertTrue(collection.contains(q2));
        assertTrue(collection.contains(q3));
    }

    private Collection<Question> generateQuestions() {
        return List.of(
                new Question("a", "a"),
                new Question("b", "b"),
                new Question("c", "c"));
    }
}