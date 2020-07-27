package example;

public class GuessProcess {

    private final GuessGame guessGame;

    private boolean allCorrect;

    InputValidation inputValidation = new InputValidation();

    public int getSum() {
        return sum;
    }

    private int sum;

    private final int[] answer;

    public GuessProcess(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generate();
        this.guessGame = new GuessGame();
        this.sum = 0;
    }

    public String guess(int[] inputNumber) {
        if (this.allCorrect) {
            return "win, all correct.";
        }
        if (this.sum == 6) {
            return "end";
        }
        this.sum++;
        boolean isLegal = inputValidation.isLegal(inputNumber);
        StringBuilder result = new StringBuilder();
        if (!isLegal) {
            result.append("Wrong Input, Input again\n");
            return result.toString();
        }
        String guessResult = guessGame.calculateResult(answer,inputNumber);
        result.append(guessResult).append("\n");
        if (guessResult.equals("4A0B")) {
            this.allCorrect = true;
            return "win, all correct.";
        }
        return result.toString();
    }
}
