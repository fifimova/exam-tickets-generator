package skypro.course2.examticketsgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.repository.MathQuestionRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private MathQuestionRepository mathRepositoryMock;

    private QuestionService out;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        out = new MathQuestionService(mathRepositoryMock);
    }

    @Test
    void shouldAddStringsParams() {
        String question = "a";
        String answer = "a";
        Question q = new Question(question, answer);
        when(mathRepositoryMock.add(q)).thenReturn(generateQuestions().get(0));

        assertEquals(out.add(question, answer), generateQuestions().get(0));
        verify(mathRepositoryMock).add(q);

    }

    @Test
    void shouldAddQuestion() {
        String question = "a";
        String answer = "a";
        Question q = new Question(question, answer);
        when(mathRepositoryMock.add(q)).thenReturn(generateQuestions().get(0));

        assertEquals(out.add(q), generateQuestions().get(0));
        verify(mathRepositoryMock).add(q);
    }

    @Test
    void shouldRemoveQuestion() {
        String question = "a";
        String answer = "a";
        Question q = new Question(question, answer);
        when(mathRepositoryMock.remove(q)).thenReturn(generateQuestions().get(0));

        assertEquals(out.remove(q), generateQuestions().get(0));
        verify(mathRepositoryMock).remove(q);
    }

    @Test
    void shouldPrintListOfQuestions() {
        when(mathRepositoryMock.getAll()).thenReturn(generateQuestions());
        List<Question> list = new ArrayList<>(List.of(new Question("a", "a"),
                new Question("b", "b"),
                new Question("c", "c")));
        assertEquals(list, out.getAll());
        verify(mathRepositoryMock).getAll();
    }

    @Test
    void shouldGetRandomQuestion() {
        when(mathRepositoryMock.getAll()).thenReturn(generateQuestions());

        assertTrue(generateQuestions().contains(out.getRandomQuestion()));
        verify(mathRepositoryMock, times(2)).getAll();
    }

    private List<Question> generateQuestions() {
        return List.of(
                new Question("a", "a"),
                new Question("b", "b"),
                new Question("c", "c"));
    }
}
