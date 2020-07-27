package example;

import java.util.HashSet;
import java.util.Set;

public class InputGuess {
    public InputGuess() {

    }
    public boolean isLegal(int[] inputGuess) {
        boolean isLegalLength = isLegalLength(inputGuess);
        boolean isLegalRange = isLegalRange(inputGuess);
        boolean isRepeatNumbers = isRepeat(inputGuess);
        return !isRepeatNumbers && isLegalLength && isLegalRange;
    }

    private boolean isLegalLength(int[] inputGuess){
        return 4 == inputGuess.length;
    }

    private boolean isLegalRange(int[] inputGuess){
        for (int num: inputGuess){
            if (num < 0 || num > 9){
                return false;
            }
        }
        return true;
    }

    private boolean isRepeat(int[] inputGuess){
        Set<Integer> tempSet = new HashSet<Integer>();
        for (int num: inputGuess) {
            tempSet.add(num);
        }
        return inputGuess.length != tempSet.size();
    }
}
