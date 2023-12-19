package main.java;

import main.java.actions.InitActions;
import main.java.actions.TurnActions;
import main.java.map.WorldMap;

public class Simulation {
    WorldMap map = new WorldMap();
    public int numberIteration = 0;
    Render render = new Render();
    InitActions initActions = new InitActions(map);

    protected void initWorld(){
        initActions.addEntitiesToWorld();
    }

    nextTurn(){

    }

    startSimulation(){

    }

    pauseSimulation(){

    }
}
