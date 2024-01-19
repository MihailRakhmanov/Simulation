package main.java;

import main.java.actions.InitActions;
import main.java.actions.TurnActions;
import main.java.map.WorldMap;

public class Simulation {
    private WorldMap map;
    public int numberIteration = 0;
    private Render render;

    public Simulation() {
        map = new WorldMap();
        render = new Render();
    }

    protected void initWorld(){
        InitActions initActions = new InitActions(map);
        initActions.addEntitiesToWorld();
    }

    public void nextTurn(){
        TurnActions turnActions = new TurnActions(map);
        turnActions.oneTurn();
        numberIteration++;
        System.out.println("Number of iteration: " + this.numberIteration);
        drawMap();
    }

    public void drawMap(){
        render.drawMap(map);
    }

}
