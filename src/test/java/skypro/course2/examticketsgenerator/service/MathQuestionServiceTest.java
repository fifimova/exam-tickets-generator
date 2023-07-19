package skypro.course2.examticketsgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import skypro.course2.examticketsgenerator.Question;
import skypro.course2.examticketsgenerator.repository.MathQuestionRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void shouldGetRandomQuestion() {
        Question question = out.getRandomQuestion();
        assertNotNull(question);
    }
}
