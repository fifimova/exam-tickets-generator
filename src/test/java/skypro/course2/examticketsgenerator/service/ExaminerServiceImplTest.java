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
import java.util.HashSet;
import java.util.Set;

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
        Set<QuestionService> questionServices = new HashSet<>();
        questionServices.add(java);
        questionServices.add(math);
        out = new ExaminerServiceImpl(questionServices);
    }

    @Test
    void shouldThrowExceptionIfAmountMoreThenQuestions() {
        assertThrows(UnsupportedAmountException.class, () -> out.getQuestions(0));

    }

    @Test
    void shouldReturnListOfUniqueRandomQuestions() {
        Question q1 = new Question("a", "a");
        Question q2 = new Question("b", "b");
        Question q3 = new Question("c", "c");
        Question q4 = new Question("d", "d");
        Question q5 = new Question("e", "e");

        when(math.getRandomQuestion()).thenReturn(q1)
                .thenReturn(q2)
                .thenReturn(q3)
                .thenReturn(q4)
                .thenReturn(q5);

        when(java.getRandomQuestion()).thenReturn(q1)
                .thenReturn(q2)
                .thenReturn(q3)
                .thenReturn(q4)
                .thenReturn(q5);

        Collection<Question> collection = out.getQuestions(5);
        assertEquals(5, collection.size());

        verify(java, atLeastOnce()).getRandomQuestion();
        verify(math, atLeastOnce()).getRandomQuestion();

        assertTrue(collection.contains(q1));
        assertTrue(collection.contains(q2));
        assertTrue(collection.contains(q3));
        assertTrue(collection.contains(q4));
        assertTrue(collection.contains(q5));
    }
}