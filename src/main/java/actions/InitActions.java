package main.java.actions;

import main.java.entities.Entity;
import main.java.entities.creatures.Herbivore;
import main.java.entities.creatures.Predator;
import main.java.entities.stationary.Grass;
import main.java.entities.stationary.Rock;
import main.java.entities.stationary.Tree;
import main.java.map.Cell;
import main.java.map.WorldMap;


public class InitActions extends Actions{

    public InitActions(WorldMap map){
        super.map = map;
    }

    protected void getInitActions(Entity entity){
        int countTypeOnMap = (int) entity.getChanceSpawn()*sizeOfMap;
        int currentRate = 0;

        while (currentRate<countTypeOnMap){
            Cell cell = getEmptyRandomCoordinates(map);
            map.setEntityInCell(cell, entity);
        }
    }

    public void addEntitiesToWorld(){
        getInitActions(new Grass());
        getInitActions(new Rock());
        getInitActions(new Tree());
        getInitActions(new Herbivore());
        getInitActions(new Predator());
    }




}
