package example;

import java.util.Random;

public class AnswerGeneratorImpl implements AnswerGenerator {
    @Override
    public int[] generate() {
        Random rand = new Random();
        int[] answer = new int[4];
        answer[0] = rand.nextInt(10);
        int i = 1;
        while(i < 4) {
            int randInt = rand.nextInt(10);
            if (!searchNum(randInt,answer)){
                answer[i++] = randInt;
            }
        }
        return answer;
    }

    private boolean searchNum(int x, int[] array) {
        for (int index : array){
            if (x == index){
                return true;
            }
        }
        return false;
    }
}
