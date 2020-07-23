package example;
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
}
