package main.java.entities.creatures;

import main.java.entities.Entity;
import main.java.entities.stationary.Grass;
import main.java.map.Cell;
import main.java.map.WorldMap;
import main.java.searchAlgorithm.PathFinder;


public class Herbivore extends Creature{

    public Herbivore() {
        chanceSpawn = 0.07f;
        enrichmentPoint = 0.05f;
        speed = 1;
        hp = 5;
        satiety = 5;
        victim = Grass.class;
    }

    @Override
    public void makeMove(Cell start, WorldMap map) {
        for (Cell neighbor : PathFinder.findNeighbors(start)){
            if (map.getTypeCell(neighbor) == Grass.class){
                hp++;
                satiety = Math.min(satiety + 2, maxSatiety);
                map.clearCell(neighbor);
                return;
            }
        }
        satiety--;
        super.makeMove(start, map);
    }

    @Override
    public Entity spawnEntity() {
        return new Herbivore();
    }
}
