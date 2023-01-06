package game.board;

import java.util.List;

public class Scenario {
    private int width;
    private int height;
    
    private List<ScenarioData> scenarioDataList;

    public Scenario(int width, int height, List<ScenarioData> scenarioDataList) {
        this.width = width;
        this.height = height;
        this.scenarioDataList = scenarioDataList;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<ScenarioData> getScenarioDataList() {
        return scenarioDataList;
    }
}

