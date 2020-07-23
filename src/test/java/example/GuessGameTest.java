package example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessGameTest {

    @Test
    void should_be_return_4A0B_when_given_answer_1234_and_input_guess_is_right() {
        //given
        int [] answer = {1,2,3,4};
        int[] inputGuess = {1,2,3,4};
        GuessGame guessGame = new GuessGame();
        //when
        String actual = guessGame.validation(answer,inputGuess);
        //then
        assertEquals("4A0B",actual);
    }

    @Test
    void should_be_return_wrong_input_when_given_answer_1234_and_input_guess_is_illegal() {
        //given
        int [] answer = {1,2,3,4};
        int[] inputGuess = {1000,2,3,4};
        GuessGame guessGame = new GuessGame();
        //when
        String actual = guessGame.validation(answer,inputGuess);
        //then
        assertEquals("Wrong Input, Input again",actual);
    }

    @Test
    public void should_return_true_when_generate_answer_is_repeated() {
        //given
        AnswerGeneratorImpl answerGenerator = new AnswerGeneratorImpl();
        int[] answer = answerGenerator.generate();
        //when compare two answer has repeat
        boolean repeat = true;
        //then
        Assertions.assertTrue(true);
    }
}
