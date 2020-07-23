package example;

public class GuessProcess {

    private GuessGame guessGame;

    InputGuess inputGuess;

    private int sum;

    private int[] answer;

    public GuessProcess() {
        AnswerGenerator answerGenerator = new AnswerGeneratorImpl();
        this.answer = answerGenerator.generate();
        this.guessGame = new GuessGame(answerGenerator);
        this.sum = 0;
    }

    public GuessProcess(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generate();
        this.guessGame = new GuessGame(answerGenerator);
        this.sum = 0;
    }

    public String guess(int[] inputNumber) {
        if (this.sum == 6) {
            return "end";
        }
        this.sum++;
        boolean isLegal = inputGuess.isLegal(inputNumber);
        StringBuilder result = new StringBuilder();
        if (!isLegal) {
            result.append("Wrong Input, Input again\n");
            return result.toString();
        } else {
            String guessResult = guessGame.validation(answer,inputNumber);
            result.append(guessResult).append("\n");
            if (guessResult.equals("4A0B")) {
                this.sum = 6;
            }
            return result.toString();
        }
    }
}
