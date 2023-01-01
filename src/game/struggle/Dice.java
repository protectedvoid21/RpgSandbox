package game.struggle;
import java.util.Random;
public class Dice {

    public static int roll(int numberOfDices, int typeOfDice){
        Random rand = new Random();
        int result = 0;
        for (int i = 0; i < numberOfDices; i ++){
            result += rand.nextInt(typeOfDice) +1;
        }
        return result;

    }
}
