package skypro.course2.examticketsgenerator.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.exception.QuestionAlreadyAddedException;
import skypro.course2.examticketsgenerator.exception.QuestionNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {

    private QuestionRepository out = new JavaQuestionRepository();

    @BeforeEach
    void setUp() {
        out.add(new Question("a", "a"));
        out.add(new Question("b", "b"));
        out.add(new Question("c", "c"));

    }

    @Test
    void shouldAddQuestion() {
        Question question = new Question("d", "d");
        out.add(question);
        assertTrue(out.getAll().contains(question));
    }

    @Test
    void shouldThrowExceptionIfQuestionAlreadyAdded() {
        assertThrows(QuestionAlreadyAddedException.class, () -> out.add(new Question("a", "a")));
    }

    @Test
    void shouldRemoveQuestion() {
        Question question = new Question("a", "a");
        out.remove(question);
        assertFalse(out.getAll().contains(question));
    }

    @Test
    void shouldThrowExceptionIfQuestionNotFound() {
        assertThrows(QuestionNotFoundException.class, () -> out.remove(new Question("p", "p")));
    }

    @Test
    void shouldPrintListOfQuestions() {
        List<Question> questions = new ArrayList<>(List.of(
                new Question("a", "a"),
                new Question("b", "b"),
                new Question("c", "c")));
        assertIterableEquals(questions, out.getAll());
    }
}