package game.cardManager;

import game.cardManager.Warhammer.DecodeArrayStatisticsWarhammer;
import game.interfaces.IDecodeArrayStatistics;
import game.interfaces.Statistics;

import java.util.ArrayList;

public class DecodeArrayStatistics {

    public static Statistics decodeStats(ArrayList<String> stats){
        IDecodeArrayStatistics decode = new DecodeArrayStatisticsWarhammer();
        return decode.decode(stats);
    }
}
