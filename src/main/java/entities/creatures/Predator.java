package main.java.entities.creatures;

import main.java.map.Cell;
import main.java.map.WorldMap;
import main.java.searchAlgorithm.PathFinder;

public class Predator extends Creature{
    private static final int damage = 2;
    private Herbivore victim;


    public Predator() {
        chanceSpawn = 0.03f;
        enrichmentPoint = 0.01f;
        speed = 2;
        hp = 3;
        satiety = 5;
    }


    @Override
    public void makeMove(Cell start, WorldMap map) {
        for (Cell neighbor : PathFinder.findNeighbors(start)){
            if (map.getTypeCell(neighbor) == Herbivore.class){
                Herbivore herbivore = map.getEntityFromCell(neighbor);
                if (herbivore.hp <= 0){
                    map.clearCell(neighbor);
                } else {
                    herbivore.hp -= damage;
                }
                hp++;
                satiety = Math.max(satiety + 2, maxSatiety);
                map.clearCell(neighbor);
            }
        }
        satiety--;
        super.makeMove(start, map);
    }
}
