package game.interfaceWarhammer;

import game.interfaceWarhammer.StatisticsWarhammer;
import game.interfaces.StatisticsBuilder;

public class WarhammerStatisticsBuilder extends StatisticsBuilder {
    @Override
    protected void setStats() {
        stats = new StatisticsWarhammer();
    }
}

