package skypro.course2.examticketsgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skypro.course2.examticketsgenerator.Question;

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
        assertEquals(question, out.add("d","d"));
        assertTrue(out.getAll().contains(question));
    }

    @Test
    void shouldAddQuestion() {
        Question question = new Question("d", "d");
        out.add(question);
        assertTrue(out.getAll().contains(question));
    }

    @Test
    void shouldRemoveQuestion() {
    }

    @Test
    void shouldPrintListOfQuestions() {
    }

    @Test
    void shouldGetRandomQuestion() {
    }
}