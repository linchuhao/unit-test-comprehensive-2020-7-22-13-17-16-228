package example;

import java.util.HashSet;
import java.util.Set;

public class GuessGame {
    public String validation(int[] answer, int[] inputGuess) {
        int sumOfA = 0;
        int sumOfB = 0;
        for (int i = 0; i < answer.length; i++){
            if (inputGuess[i] == answer[i]){
                sumOfA += 1;
            }
            if (inputGuess[i] != answer[i]){
                if(searchNum(inputGuess[i],answer)){
                    sumOfB += 1;
                }
            }
        }
        return sumOfA + "A" + sumOfB + "B";
    }

    private boolean searchNum(int x, int[] array) {
        for (int index :array){
            if (x == index){
                return true;
            }
        }
        return false;
    }
}
