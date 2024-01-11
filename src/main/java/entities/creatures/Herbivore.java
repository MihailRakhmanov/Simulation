package main.java.entities.creatures;

import main.java.entities.stationary.Grass;
import main.java.map.Cell;
import main.java.map.WorldMap;
import main.java.searchAlgorithm.PathFinder;

// Травоядное. Стремится найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.
public class Herbivore extends Creature{
    private Grass victim;

    public Herbivore() {
        //super.chanceSpawn = 0.07f;
        chanceSpawn = 0.07f;
        enrichmentPoint = 0.04f;
        speed = 1;
        hp = 5;
        satiety = 5;
    }

    @Override
    public void makeMove(Cell start, WorldMap map) {
        for (Cell neighbor : PathFinder.findNeighbors(start)){
            if (map.getTypeCell(neighbor) == Grass.class){
                hp++;
                satiety = Math.max(satiety + 2, maxSatiety);
                map.clearCell(neighbor);
            }
        }
        satiety--;
        super.makeMove(start, map);
    }
}
