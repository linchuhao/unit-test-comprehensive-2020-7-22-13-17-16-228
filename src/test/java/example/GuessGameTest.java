package example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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

    @Test
    public void should_be_return_win_when_input_guess_two_times_given_input_guess_and_answer1234() {
        //given
        int [] answer = {1,2,3,4};
        int [] inputGuess1 = {1,2,3,5};
        int [] inputGuess2 = {1,2,3,4};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessProcess guessProcess = new GuessProcess(answerGenerator);
        //when
        guessProcess.guess(inputGuess1);
        String actual = guessProcess.guess(inputGuess2);
        //then
        Assertions.assertEquals("win, all correct.", actual);
    }

    @Test
    public void should_be_return_end_when_input_guess_six_times_given_input_guess_and_answer1234() {
        //given
        int [] answer = {1,2,3,4};
        int [] inputGuess1 = {1,2,3,5};
        int [] inputGuess2 = {1,2,3,6};
        int [] inputGuess3 = {1,2,3,7};
        int [] inputGuess4 = {1,2,3,8};
        int [] inputGuess5 = {1,2,3,9};
        int [] inputGuess6 = {1,2,3,10};
        AnswerGenerator answerGenerator = Mockito.mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        GuessProcess guessProcess = new GuessProcess(answerGenerator);
        //when
        guessProcess.guess(inputGuess1);
        guessProcess.guess(inputGuess2);
        guessProcess.guess(inputGuess3);
        guessProcess.guess(inputGuess4);
        guessProcess.guess(inputGuess5);
        guessProcess.guess(inputGuess6);
        //then
        Assertions.assertEquals(6, guessProcess.getSum());
        String actual = guessProcess.guess(inputGuess6);
        Assertions.assertEquals("end", actual);
    }

}
