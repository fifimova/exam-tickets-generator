package skypro.course2.examticketsgenerator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;
import skypro.course2.examticketsgenerator.model.Question;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class MathQuestionServiceTest {
    private Random rand;
    private QuestionService out;

    @BeforeEach
    void setUp() {
        rand = Mockito.mock(Random.class);
        out = new MathQuestionService(rand);
    }

    @ParameterizedTest
    @CsvSource({"2,2,0,2+2,4"})
    void shouldGetRandomQuestion(Integer num1, Integer num2, Integer mathOperation,
                                 String expectedQuestion, String expectedAnswer) {
        when(rand.nextInt(anyInt()))
                .thenReturn(num1)
                .thenReturn(num2);
        when(rand.nextInt(anyInt()))
                .thenReturn(mathOperation);

        Question actual = out.getRandomQuestion();
        assertEquals(expectedQuestion, actual.getQuestion());
        assertEquals(expectedAnswer, actual.getAnswer());
    }
}
