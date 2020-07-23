package example;

import java.util.HashSet;
import java.util.Set;

public class InputGuess {
    public InputGuess() {

    }
    public boolean isLegal(int[] inputGuess) {
        boolean lengthLegal = hasLegalLength(inputGuess);
        boolean legalRange = hasLegalRange(inputGuess);
        boolean hasRepeatNumbers = hasRepeat(inputGuess);
        return !hasRepeatNumbers && lengthLegal && legalRange;
    }

    private boolean hasLegalLength(int[] inputGuess){
        return 4 == inputGuess.length;
    }

    private boolean hasLegalRange(int[] inputGuess){
        for (int num: inputGuess){
            if (num < 0 || num > 9){
                return false;
            }
        }
        return true;
    }

    private boolean hasRepeat(int[] inputGuess){
        Set<Integer> tempSet = new HashSet<Integer>();
        for (int num: inputGuess) {
            tempSet.add(num);
        }
        return inputGuess.length != tempSet.size();
    }
}
