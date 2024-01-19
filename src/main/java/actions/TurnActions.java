package main.java.actions;

import main.java.entities.Entity;
import main.java.entities.creatures.Creature;
import main.java.entities.creatures.Herbivore;
import main.java.entities.creatures.Predator;
import main.java.entities.stationary.Grass;
import main.java.map.Cell;
import main.java.map.WorldMap;

import java.util.Map;


public class TurnActions extends Actions{

    public TurnActions(WorldMap map){
        super(map);
    }

    public void enrichmentOfWorld(){
        Grass grass = new Grass();
        Herbivore herbivore = new Herbivore();
        Predator predator = new Predator();

        if (checkOfQuantity(grass)) {
            addEntitiesToWorld(grass);
        }
        if (checkOfQuantity(herbivore)) {
            addEntitiesToWorld(herbivore);
        }
        if (checkOfQuantity(predator)) {
            addEntitiesToWorld(predator);
        }
    }

    protected boolean checkOfQuantity(Entity entity){
        return (float)(map.getEntitiesOfType(entity.getClass()).size()/sizeOfMap) < entity.getEnrichmentPoint();
    }

    protected void addEntitiesToWorld(Entity entity){
        int minCountTypeOnMap = (int) (entity.getEnrichmentPoint()*sizeOfMap);
        //int currentRate = 30;
        int currentRate = map.getEntitiesOfType(entity.getClass()).size();

        while (currentRate<minCountTypeOnMap){
            Cell cell = getEmptyRandomCoordinates(map);
            map.setEntityInCell(cell, entity.spawnEntity());
            currentRate++;
        }
    }

    public void oneTurn(){
        enrichmentOfWorld();

        for (Map.Entry<Cell, Creature> entry : map.getEntitiesOfType(Creature.class).entrySet()) {
            Creature creature = entry.getValue();
            creature.makeMove(entry.getKey(), map);
        }
    }
}
