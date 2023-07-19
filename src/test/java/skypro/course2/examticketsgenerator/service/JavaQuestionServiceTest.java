package skypro.course2.examticketsgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.repository.JavaQuestionRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {

    @Mock
    private JavaQuestionRepository javaRepositoryMock;

    private QuestionService out;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        out = new JavaQuestionService(javaRepositoryMock);
    }

    @Test
    void shouldAddStringsParams() {
        String question = "a";
        String answer = "a";
        Question q = new Question(question, answer);
        when(javaRepositoryMock.add(q)).thenReturn(generateQuestions().get(0));

        assertEquals(out.add(question, answer), generateQuestions().get(0));
        verify(javaRepositoryMock).add(q);

    }

    @Test
    void shouldAddQuestion() {
        String question = "a";
        String answer = "a";
        Question q = new Question(question, answer);
        when(javaRepositoryMock.add(q)).thenReturn(generateQuestions().get(0));

        assertEquals(out.add(q), generateQuestions().get(0));
        verify(javaRepositoryMock).add(q);
    }

    @Test
    void shouldRemoveQuestion() {
        String question = "a";
        String answer = "a";
        Question q = new Question(question, answer);
        when(javaRepositoryMock.remove(q)).thenReturn(generateQuestions().get(0));

        assertEquals(out.remove(q), generateQuestions().get(0));
        verify(javaRepositoryMock).remove(q);
    }

    @Test
    void shouldPrintListOfQuestions() {
        when(javaRepositoryMock.getAll()).thenReturn(generateQuestions());
        List<Question> list = new ArrayList<>(List.of(new Question("a", "a"),
                new Question("b", "b"),
                new Question("c", "c")));
        assertEquals(list, out.getAll());
        verify(javaRepositoryMock).getAll();
    }

    @Test
    void shouldGetRandomQuestion() {
        when(javaRepositoryMock.getAll()).thenReturn(generateQuestions());

        assertTrue(generateQuestions().contains(out.getRandomQuestion()));
        verify(javaRepositoryMock, times(2)).getAll();
    }

    private List<Question> generateQuestions() {
        return List.of(
                new Question("a", "a"),
                new Question("b", "b"),
                new Question("c", "c"));
    }
}