package game.interfaces;

import game.interfaceWarhammer.StatisticsWarhammer;

public class WarhammerStatisticsBuilder extends StatisticsBuilder {
    @Override
    protected void setStats() {
        stats = new StatisticsWarhammer();
    }
}

