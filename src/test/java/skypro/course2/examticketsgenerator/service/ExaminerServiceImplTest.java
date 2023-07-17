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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService java;
    @Mock
    private QuestionService math;

    private ExaminerServiceImpl out;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        out = new ExaminerServiceImpl(java, math);
    }

    @Test
    void shouldThrowExceptionIfAmountMoreThenQuestions() {
        assertThrows(UnsupportedAmountException.class, () -> out.getQuestions(0));

        when(java.getAll()).thenReturn(generateQuestions());
        when(math.getAll()).thenReturn(generateQuestions());
        assertThrows(UnsupportedAmountException.class, () -> out.getQuestions(100));
    }

    @Test
    void shouldReturnListOfUniqueRandomQuestions() {
        Question q1 = new Question("a", "a");
        Question q2 = new Question("b", "b");
        Question q3 = new Question("c", "c");
        Question q4 = new Question("d", "d");
        Question q5 = new Question("e", "e");

        when(java.getRandomQuestion()).thenReturn(q1)
                .thenReturn(q2)
                .thenReturn(q3);

        when(math.getRandomQuestion()).thenReturn(q4)
                .thenReturn(q5);

        when(java.getAll()).thenReturn(generateQuestions());
        when(math.getAll()).thenReturn(generateQuestions());

        Collection<Question> collection = out.getQuestions(5);
        verify(java, atLeastOnce()).getRandomQuestion();
        verify(math, atLeastOnce()).getRandomQuestion();

        assertEquals(5, collection.size());

        assertTrue(collection.contains(q1));
        assertTrue(collection.contains(q2));
        assertTrue(collection.contains(q3));
        assertTrue(collection.contains(q4));
        assertTrue(collection.contains(q5));
    }

    private Collection<Question> generateQuestions() {
        return List.of(
                new Question("a", "a"),
                new Question("b", "b"),
                new Question("c", "c"),
                new Question("d", "d"),
                new Question("e", "e"));
    }
}