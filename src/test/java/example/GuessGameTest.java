package example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessGameTest {

    @Test
    void should_be_return_4A0B_when_given_answer_1234_and_input_guess_is_right() {
        //given
        int [] answer = {1,2,3,4};
        int[] inputGuess = {1,2,3,4};
        GuessGame guessGame = new GuessGame();
        //when
        String actual = guessGame.calculateResult(answer,inputGuess);
        //then
        assertEquals("4A0B",actual);
    }

    @Test
    void should_be_return_0A4B_when_given_answer_1234_and_input_guess_is_right_but_all_position_is_wrong() {
        //given
        int [] answer = {1,2,3,4};
        int[] inputGuess = {4,3,2,1};
        GuessGame guessGame = new GuessGame();
        //when
        String actual = guessGame.calculateResult(answer,inputGuess);
        //then
        assertEquals("0A4B",actual);
    }

    @Test
    void should_be_return_wrong_input_when_given_answer_1234_and_input_guess_is_illegal() {
        //given
        int [] answer = {1,2,3,4};
        int[] inputGuess = {1000,2,3,4};
        GuessGame guessGame = new GuessGame();
        //when
        String actual = guessGame.calculateResult(answer,inputGuess);
        //then
        assertEquals("Wrong Input, Input again",actual);
    }

    @Test
    public void should_return_true_when_generate_answer_is_not_repeated() {
        //given
        AnswerGenerator answerGenerator = new AnswerGenerator();
        int[] answer = answerGenerator.generate();
        //when
        Set<Integer> tempSet = new HashSet<Integer>();
        for (int num: answer) {
            tempSet.add(num);
        }
        //then
        boolean isNotRepeat = answer.length == tempSet.size();
        Assertions.assertTrue(isNotRepeat);
    }

}
