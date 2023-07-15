package skypro.course2.examticketsgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.exception.QuestionAlreadyAddedException;
import skypro.course2.examticketsgenerator.exception.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private QuestionService out = new JavaQuestionService();

    @BeforeEach
    void setUp() {
        out.add("a", "a");
        out.add("b", "b");
        out.add("c", "c");

    }

    @Test
    void shouldAddStringsParams() {
        Question question = new Question("d", "d");
        assertEquals(question, out.add("d", "d"));
        assertTrue(out.getAll().contains(question));
    }

    @Test
    void shouldAddQuestion() {
        Question question = new Question("d", "d");
        out.add(question);
        assertTrue(out.getAll().contains(question));
    }

    @Test
    void shouldThrowExceptionIfQuestionAlreadyAdded() {
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add("a", "a"));
    }

    @Test
    void shouldRemoveQuestion() {
        Question question = new Question("a", "a");
        out.remove(question);
        assertFalse(out.getAll().contains(question));
    }

    @Test
    void shouldThrowExceptionIfQuestionNotFound() {
        Question question = new Question("p", "p");
        assertThrows(QuestionNotFoundException.class, () -> out.remove(question));
    }

    @Test
    void shouldPrintListOfQuestions() {
        List<Question> questions = new ArrayList<>(List.of(
                new Question("a", "a"),
                new Question("b", "b"),
                new Question("c", "c")));
        assertIterableEquals(questions, out.getAll());
    }

    @Test
    void shouldGetRandomQuestion() {
        List<Question> questions = new ArrayList<>();
        int count = 0;
        while (count < 10) {
            questions.add(out.getRandomQuestion());
            count++;
        }
        assertSame(10, questions.size());
        assertNotNull(questions.get(0));
        assertNotNull(questions.get(1));
        assertNotNull(questions.get(2));
        Question q1 = new Question("a", "a");
        Question q2 = new Question("b", "b");
        Question q3 = new Question("c", "c");
        assertTrue(questions.contains(q1));
        assertTrue(questions.contains(q2));
        assertTrue(questions.contains(q3));
    }
}