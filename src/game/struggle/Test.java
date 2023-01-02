package game.struggle;

public class Test {

    public static boolean test(int statistic, int modifire){
        boolean result =( statistic + modifire )< Dice.roll(1, 100);
        return  result;
    }
}
