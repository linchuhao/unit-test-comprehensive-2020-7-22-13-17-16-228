package example;


public class GuessGame {

    private final InputGuess inputGuessNum = new InputGuess();

    public GuessGame() {
    }

    public String calculateResult(int[] answer, int[] inputGuess) {
        if (!inputGuessNum.isLegal(inputGuess)){
            return "Wrong Input, Input again";
        }
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
